package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellVampire extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(.85);
				
				if(acc){
					int damage = Character.doDamage(user, opponent, SpellType.DEATH, 350);
					int heal = (int) damage / 2;
					
					user.heal(heal);
					System.out.println(user.getName()+" healed "+heal);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.DEATH;
	}
	
	public String name() {
		return "Vampire";
	}
	
	public int pips() {
		return 4;
	}
}
