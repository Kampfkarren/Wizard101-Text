package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;
import wizard101text.src.Global;
import wizard101text.src.Main;

public class SpellSanctuary extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Main.currentGlobal = Global.SANCTUARY;
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.LIFE;
	}
	
	public String name() {
		return "Sanctuary";
	}
	
	public int pips() {
		return 3;
	}
}
