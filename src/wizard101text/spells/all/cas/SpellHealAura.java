package wizard101text.spells.all.cas;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;
import wizard101text.src.Global;
import wizard101text.src.Main;

public class SpellHealAura extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Main.currentGlobal = Global.HEALAURA;
				return true;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.LIFE;
	}
	
	public String name() {
		return "- CAS - Heal Aura";
	}
	
	public int pips() {
		return 2;
	}
}
