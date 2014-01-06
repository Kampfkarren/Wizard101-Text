package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;
import wizard101text.src.Global;
import wizard101text.src.Main;

public class SpellPowerPlay extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Main.currentGlobal = Global.POWERPLAY;
				
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.BALANCE;
	}
	
	public String name() {
		return "Power Play";
	}
	
	public int pips() {
		return 4;
	}
}
