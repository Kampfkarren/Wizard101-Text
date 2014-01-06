package wizard101text.spells.all;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellElementalBlade extends Spell {
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(user, SpellType.FIRE, WardType.BLADE, 35);
				Character.addWard(user, SpellType.ICE, WardType.BLADE, 35);
				Character.addWard(user, SpellType.STORM, WardType.BLADE, 35);
				
				return true;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.BALANCE;
	}
	
	public String name(){
		return "Elemental Blade";
	}
	
	public int pips(){
		return 1;
	}
}
