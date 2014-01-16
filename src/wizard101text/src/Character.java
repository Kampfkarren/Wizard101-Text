package wizard101text.src;

import java.util.HashMap;
import java.util.Map.Entry;

import wizard101text.spells.*;

public class Character {
	private HashMap<Integer, Object[]> wards = new HashMap<Integer, Object[]>();
	private int maxHP;
	private int HP;
	private int pips;
	private String name;
	
	public Character(Spell[] spellsval, int HPval, String name){
		this.maxHP = HPval;
		this.HP = HPval;
		this.pips = 1;
		this.name = name;
	}
	
	public static void addWard(Character c, SpellType spell, WardType wardType, int amount){
		c.wards.put(c.wards.size()+1, new Object[]{wardType, spell, amount});
	}
	
	public static void addConvert(Character c, SpellType convertme, SpellType tome, String name){
		c.wards.put(c.wards.size()+1, new Object[]{WardType.CONVERT, convertme, tome, name});
	}
	
	public static void addDot(Character c, SpellType spell, int amount, int time){
		c.wards.put(c.wards.size()+1, new Object[]{WardType.DOT, spell, amount, time});
	}
	
	@SuppressWarnings("rawtypes")
	public static int doDamage(Character attacker, Character opponent, SpellType t, int dmg){
		HashMap<Integer, Entry> remove = new HashMap<Integer, Entry>();
		HashMap<Integer, Entry> removeAtt = new HashMap<Integer, Entry>();
		int damage = dmg;
		
		Main.debug("[DEBUG] Default damage is "+dmg);
		
		for(Entry<Integer, Object[]> entry : opponent.wards.entrySet()){
			if(opponent == null) break;
			
			SpellType s = (SpellType)entry.getValue()[1];
			
			if((WardType)(entry.getValue()[0]) == WardType.TRAP){
				if(s == t){
					damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
					remove.put(remove.size(), entry);
				}
			}else if((WardType)(entry.getValue()[0]) == WardType.SHIELD){
				if(s == t){
					damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
					remove.put(remove.size(), entry);
				}
			}else if((WardType)(entry.getValue()[0]) == WardType.NEXTDAMAGE){
				damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
				remove.put(remove.size(), entry);
			}else if((WardType)(entry.getValue()[0]) == WardType.CONVERT){
				SpellType convertme = (SpellType)(entry.getValue()[1]);
				SpellType tome = (SpellType)(entry.getValue()[2]);
				System.out.println("The "+entry.getValue()[3]+" converted "+SpellType.getTypeName(convertme)+" to "+SpellType.getTypeName(tome)+"!");
				remove.put(remove.size(), entry);
			}
		}
		
		for(Entry<Integer, Object[]> entry : attacker.wards.entrySet()){
			if(attacker == null) break;
			
			SpellType s = (SpellType)entry.getValue()[1];
			
			if((WardType)(entry.getValue()[0]) == WardType.BLADE){
				if(s == t){
					damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
					removeAtt.put(removeAtt.size(), entry);
				}
			}
		}
		
		for(Entry<Integer, Entry> r : remove.entrySet()){
			Main.debug("[DEBUG] Removing ward "+r.getKey());
			Main.debug("[DEBUG] Current length: "+opponent.wards.size());
			opponent.wards.remove(r.getValue().getKey());
			Main.debug("[DEBUG] New length: "+opponent.wards.size());
		}
		
		for(Entry<Integer, Entry> r : removeAtt.entrySet()){
			Main.debug("[DEBUG] Removing ward "+r.getKey());
			Main.debug("[DEBUG] Current length: "+attacker.wards.size());
			attacker.wards.remove(r.getValue().getKey());
			Main.debug("[DEBUG] New length: "+attacker.wards.size());
		}
		
		Main.debug("[DEBUG] Final damage is "+damage);
		
		opponent.HP -= damage;
		
		return damage;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean checkDispel(Character attacker, SpellType t){
		HashMap<Integer, Entry> remove = new HashMap<Integer, Entry>();
		boolean has = false;
		
		for(Entry<Integer, Object[]> entry : attacker.wards.entrySet()){
			SpellType s = (SpellType)entry.getValue()[1];
			
			if((WardType)(entry.getValue()[0]) == WardType.DISPEL){
				if(s == t){
					has = true;
					remove.put(remove.size(), entry);
					break;
				}
			}
		}
		
		for(Entry<Integer, Entry> r : remove.entrySet()){
			Main.debug("[DEBUG] Removing ward "+r.getKey());
			Main.debug("[DEBUG] Current length: "+attacker.wards.size());
			attacker.wards.remove(r.getValue().getKey());
			Main.debug("[DEBUG] New length: "+attacker.wards.size());
		}
		
		return has;
	}
	
	public void damageOverTime(){
		for(Entry<Integer, Object[]> entry : this.wards.entrySet()){
			SpellType s = (SpellType)entry.getValue()[1];
			
			if((WardType)(entry.getValue()[0]) == WardType.DOT){
				System.out.println(this.getName()+" took damage from a DoT spell!");
				Character.doDamage(null, this, s, (int)entry.getValue()[2]);
				int newTime = (int)entry.getValue()[3] - 1;
				Object[] newObj = entry.getValue();
				newObj[3] = newTime;
				
				this.wards.put(entry.getKey(), newObj);
				
				if(newTime == 0){
					System.out.println("The DoT spell went away!");
					this.wards.remove(entry.getKey());
				}
			}
		}
	}
	
	public int heal(int HP){
		Main.debug("Adding "+HP+" health...");
		if(this.maxHP == this.HP)
			System.out.println("But they couldn't heal because they had max HP!");
		else{
			int newHP = HP;
			
			if(Main.currentGlobal == Global.DOOMANDGLOOM)
				newHP -= (int)newHP * .65;
				
			if(Main.currentGlobal == Global.SANCTUARY)
			        newHP += (int)newHP * .25;
			
			if(this.HP + newHP > this.maxHP)
				this.HP = maxHP;
			else
				this.HP += newHP;
			
			System.out.println("They recieved "+newHP+" health!");
			
			return newHP;
		}
		
		return 0;
	}
	
	public void addPip(){
		this.pips++;
		double greaterThan = .4;
		
		//TODO Add proper Power Pips
		
		if(Main.currentGlobal == Global.POWERPLAY)
			greaterThan += greaterThan * .35;
		
		if(Math.random() <= greaterThan){
			if(this.getName() == "They")
				System.out.println("The opponent gained an extra pip!");
			else
				System.out.println("You gained an extra pip!");
			
			this.pips++;
		}
	}
	
	public void takePips(int amount){
		this.pips -= amount;
	}
	
	public int getHP(){
		return this.HP;
	}
	
	public int getMaxHP(){
		return this.maxHP;
	}
	
	public int getPips(){
		return this.pips;
	}
	
	public String getName(){
		return this.name;
	}
	
	private static int trapDamage(int amount, int damage, boolean print){
		if(print){
			System.out.println("The trap boosted the attack!");
			Main.debug("[DEBUG] Adding trap damage - " + trapDamage(amount, damage, false));
		}
		
		return (int) (amount * 100.0 / damage);
	}
}
