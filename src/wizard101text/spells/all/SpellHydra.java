package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellHydra extends Spell{
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(.85);
				
				if(acc){
					Character.doDamage(user, opponent, SpellType.FIRE, 190);
					Character.doDamage(user, opponent, SpellType.ICE, 190);
					Character.doDamage(user, opponent, SpellType.STORM, 190);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.BALANCE;
	}
	
	public String name() {
		return "Hydra";
	}
	
	public int pips() {	
		return 6;
	}
}
