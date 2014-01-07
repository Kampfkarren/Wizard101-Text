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
	
	public static void addWard(Character c, SpellType spell, WardType wardType){
		c.wards.put(c.wards.size()+1, new Object[]{wardType, spell, 40});
	}
	
	public static void addWard(Character c, SpellType spell, WardType wardType, int amount){
		c.wards.put(c.wards.size()+1, new Object[]{wardType, spell, amount});
	}
	
	@SuppressWarnings("rawtypes")
	public static int doDamage(Character attacker, Character opponent, SpellType t, int dmg){
		HashMap<Integer, Entry> remove = new HashMap<Integer, Entry>();
		int damage = dmg;
		
		Main.debug("[DEBUG] Default damage is "+dmg);
		
		for(Entry<Integer, Object[]> entry : opponent.wards.entrySet()){
			SpellType s = (SpellType)entry.getValue()[1];
			
			if((WardType)(entry.getValue()[0]) == WardType.TRAP){
				if(s == t){
					damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
					remove.put(remove.size(), entry);
				}
			}else if((WardType)(entry.getValue()[0]) == WardType.BLADE){
				if(s == t){
					damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
					remove.put(remove.size(), entry);
				}
			}else if((WardType)(entry.getValue()[0]) == WardType.SHIELD){
				if(s == t){
					damage = damage + trapDamage((int)(entry.getValue()[2]), damage, true);
					remove.put(remove.size(), entry);
				}
			}
		}
		
		for(Entry<Integer, Entry> r : remove.entrySet()){
			Main.debug("[DEBUG] Removing ward "+r.getKey());
			Main.debug("[DEBUG] Current length: "+opponent.wards.size());
			opponent.wards.remove(r.getValue().getKey());
			Main.debug("[DEBUG] New length: "+opponent.wards.size());
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
	
	public void heal(int HP){
		Main.debug("Adding "+HP+" health...");
		if(this.maxHP == this.HP)
			System.out.println("The spell failed because they already have max HP!");
		else{
			if(this.HP + 400 > this.maxHP)
				this.HP = maxHP;
			else
				this.HP += HP;
		}
	}
	
	public void addPip(){
		this.pips++;
		double greaterThan = .4;
		
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
