package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellKraken extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(.70);
				
				if(acc){
					    Character.doDamage(user, opponent, SpellType.STORM, new Random().nextInt((520 - 580) + 1) + 520);
				}
				
				return acc;
				
			}
		};
	}


public SpellType type() {
	    return SpellType.STORM;
}

public String name() {
	    return "Kraken";
}

public int pips() {
	    return 4;
}
}
