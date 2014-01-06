package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellSkip extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				System.out.println(user.getName()+" skipped!");
				return true;
			}
		};
	}
	
	public SpellType type() {
		return null;
	}
	
	public String name() {
		return "Skip";
	}
	
	public int pips() {
		return 0;
	}
}
