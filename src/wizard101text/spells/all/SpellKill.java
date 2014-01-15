package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellKill extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.doDamage(user, opponent, SpellType.NONE, Integer.MAX_VALUE);
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.NONE;
	}
	
	public String name() {
		return "Kill";
	}
	 
	public int pips() {
		return 0;
	}
}
