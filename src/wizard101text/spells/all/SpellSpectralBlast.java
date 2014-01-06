package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellSpectralBlast extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(0.85);
				
				if(acc){
					Random random = new Random();
					int next = random.nextInt(2) + 1;
					
					switch(next){
						case 1:
							Character.doDamage(user, opponent, SpellType.FIRE, 440);
							break;
						case 2:
							Character.doDamage(user, opponent, SpellType.ICE, 365);
							break;
						case 3:
							Character.doDamage(user, opponent, SpellType.STORM, 550);
							break;
					}
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type() {
		return SpellType.BALANCE;
	}
	
	public String name() {
		return "Spectral Blast";
	}
	
	public int pips() {
		return 4;
	}
}
