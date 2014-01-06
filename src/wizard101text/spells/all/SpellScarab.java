package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;

public class SpellScarab extends Spell{
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(0.85);
				if(acc){
					int damage = new Random().nextInt((105 - 65) + 1) + 65;
					Character.doDamage(user, opponent, SpellType.BALANCE, damage);
				}
				
				return acc;
			}
		};
	}
	
	public SpellType type(){
		return SpellType.BALANCE;
	}
	
	public String name(){
		return "Scarab";
	}
	
	public int pips(){
		return 1;
	}
}
