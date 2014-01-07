package wizard101text.spells.all;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellSpiritBlade extends Spell {
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Character.addWard(user, SpellType.DEATH, WardType.BLADE, 35);
				Character.addWard(user, SpellType.MYTH, WardType.BLADE, 35);
				Character.addWard(user, SpellType.LIFE, WardType.BLADE, 35);
				
				return true;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.BALANCE;
	}
	
	public String name(){
		return "Spirit Blade";
	}
	
	public int pips(){
		return 1;
	}
}
