package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellDeathPrism extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addConvert(opponent, SpellType.DEATH, SpellType.LIFE, "Death Prism");
				
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.DEATH;
	}
	
	public String name() {
		return "Death Prism";
	}
	
	public int pips() {
		return 0;
	}
}
