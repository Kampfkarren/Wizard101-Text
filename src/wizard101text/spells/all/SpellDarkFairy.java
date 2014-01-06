package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellDarkFairy extends Spell{
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(0.85);
				
				if(acc){
					int damage = new Random().nextInt((105 - 65) + 1) + 65;
					Character.doDamage(user, opponent, SpellType.DEATH, damage);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.DEATH;
	}
	
	public String name(){
		return "Dark Sprite";
	}
	
	public int pips(){
		return 1;
	}
}
