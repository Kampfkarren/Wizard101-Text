package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellSunbird extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(.75);
				
				if(acc){
					Character.doDamage(user, opponent, SpellType.FIRE, new Random().nextInt((295 - 355) + 1) + 295);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.FIRE;
	}
	
	public String name() {
		return "Sunbird";
	}
	
	public int pips() {
		return 3;
	}
}
