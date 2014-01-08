package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellSkeletalPirate extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(.85);
				
				if(acc){
					Character.doDamage(user, opponent, SpellType.DEATH, new Random().nextInt((520 - 430) + 1) + 420);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.DEATH;
	}
	
	public String name() {
		return "Skeletal Pirate";
	}
	
	public int pips() {
		return 5;
	}
}
