package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.spells.WardType;
import wizard101text.src.Character;

public class SpellFeint extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(user, SpellType.NONE, WardType.NEXTDAMAGE, 30);
				Character.addWard(opponent, SpellType.NONE, WardType.NEXTDAMAGE, 70);
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.DEATH;
	}
	
	public String name() {
		return "Feint";
	}
	
	public int pips() {
		return 1;
	}
}
