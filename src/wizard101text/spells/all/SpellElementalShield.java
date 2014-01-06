package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.spells.WardType;
import wizard101text.src.Character;

public class SpellElementalShield extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(user, SpellType.FIRE, WardType.SHIELD);
				Character.addWard(user, SpellType.ICE, WardType.SHIELD);
				Character.addWard(user, SpellType.STORM, WardType.SHIELD);
				
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.BALANCE;
	}
	
	public String name() {
		return "Elemental Shield";
	}
	
	public int pips() {
		return 0;
	}
}
