package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellBanshee extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(.85);
				
				if(acc){
					Character.doDamage(user, opponent, SpellType.DEATH, new Random().nextInt((305 - 245) + 1) + 245);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.DEATH;
	}
	
	public String name() {
		return "Banshee";
	}
	
	public int pips() {
		return 3;
	}
}
