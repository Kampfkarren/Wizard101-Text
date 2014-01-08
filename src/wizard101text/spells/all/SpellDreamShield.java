package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.spells.WardType;
import wizard101text.src.Character;

public class SpellDreamShield extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(user, SpellType.LIFE, WardType.SHIELD, 70);
				Character.addWard(user, SpellType.MYTH, WardType.SHIELD, 70);
				
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.DEATH;
	}
	
	public String name() {
		return "Dream Shield";
	}
	
	public int pips() {
		return 0;
	}
}
