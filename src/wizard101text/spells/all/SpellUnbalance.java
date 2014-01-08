package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.spells.WardType;
import wizard101text.src.Character;

public class SpellUnbalance extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(opponent, SpellType.BALANCE, WardType.DISPEL, 0);
				
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.BALANCE;
	}
	
	public String name() {
		return "Unbalance";
	}
	
	public int pips() {
		return 2;
	}
}
