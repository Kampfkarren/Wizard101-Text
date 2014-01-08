package wizard101text.spells.all;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellDeathTrap extends Spell{
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent){
				Character.addWard(opponent, SpellType.DEATH, WardType.TRAP, 40);
				
				return true;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.DEATH;
	}
	
	public String name(){
		return "Death Trap";
	}
	
	public int pips(){
		return 0;
	}
}
