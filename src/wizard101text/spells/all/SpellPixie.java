package wizard101text.spells.all;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellPixie extends Spell{
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				user.heal(400);
				return true;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.LIFE;
	}
	
	public String name(){
		return "Pixie";
	}
	
	public int pips(){
		return 2;
	}
}
