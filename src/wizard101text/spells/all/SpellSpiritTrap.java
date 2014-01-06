package wizard101text.spells.all;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellSpiritTrap extends Spell{
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(opponent, SpellType.DEATH, WardType.TRAP, 25);
				Character.addWard(opponent, SpellType.LIFE, WardType.TRAP, 25);
				Character.addWard(opponent, SpellType.MYTH, WardType.TRAP, 25);
				return true;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.BALANCE;
	}
	
	public String name(){
		return "Spirit Trap";
	}
	
	public int pips(){
		return 1;
	}
}
