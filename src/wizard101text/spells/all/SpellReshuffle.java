package wizard101text.spells.all;

import wizard101text.spells.Spell;
import wizard101text.spells.SpellInterface;
import wizard101text.spells.SpellType;
import wizard101text.src.Character;
import wizard101text.src.Main;

public class SpellReshuffle extends Spell {
	public SpellInterface effect() {
		return new SpellInterface(){
			public boolean effect(Character user, Character opponent) {
				Spell[] deck = new Spell[]{
					Spell.randomSpell(),
					Spell.randomSpell(),
					Spell.randomSpell(),
					Spell.randomSpell(),
					Spell.randomSpell(),
					new SpellSkip()
				};
				
				if(user.getName() == "You")
					Main.deck = deck;
				else
					Main.opponentDeck = deck;
				
				System.out.println(user.getName()+" reshuffled their deck!");
				
				return true;
			}
		};
	}
	
	public SpellType type() {	
		return SpellType.BALANCE;
	}
	
	public String name() {
		return "Reshuffle";
	}
	
	public int pips() {
		return 4;
	}
}
