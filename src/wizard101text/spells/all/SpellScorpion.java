package wizard101text.spells.all;

import java.util.Random;

import wizard101text.spells.*;
import wizard101text.src.Character;

public class SpellScorpion extends Spell{
	public SpellInterface effect(){
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				boolean acc = accuracy(0.85);
				
				if(acc){
					int damage = new Random().nextInt((200 - 160) + 1) + 160;
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
		return "Scorpion";
	}
	
	public int pips(){
		return 2;
	}
}
