package wizard101text.spells.all;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellElementalTrap extends Spell {
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(opponent, SpellType.FIRE, WardType.TRAP, 25);
				Character.addWard(opponent, SpellType.ICE, WardType.TRAP, 25);
				Character.addWard(opponent, SpellType.STORM, WardType.TRAP, 25);
				
				return true;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.BALANCE;
	}
	
	public String name(){
		return "Elemental Trap";
	}
	
	public int pips(){
		return 1;
	}
}
