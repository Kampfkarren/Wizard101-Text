package wizard101text.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import wizard101text.spells.*;
import wizard101text.spells.all.SpellSkip;

public class Main {
	public static String version = "Alpha 1A Copy";
	public static Global currentGlobal = Global.NORMAL;
	public static boolean debug = false;
	
	private static Random rand = new Random();
	private static Random rand2;
	
	public static Spell[] deck;
	public static Spell[] opponentDeck;
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		System.out.println("Wizard101 Text "+version);
		System.out.println("Wizard101 is made by Kingsisle Entertainment. This is just a fan creation.");
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(Spell.spellClasses.length+" spells loaded.");
		
		Scanner reader = new Scanner(System.in);
		
		Spell[] spells = new Spell[]{
			Spell.randomSpell(),
			Spell.randomSpell(),
			Spell.randomSpell(),
			Spell.randomSpell(),
			Spell.randomSpell(),
			new SpellSkip()
		};
		
		String deckStr;
		opponentDeck = new Spell[]{
			Spell.randomSpell(),
			Spell.randomSpell(),
			Spell.randomSpell(),
			Spell.randomSpell(),
			Spell.randomSpell(),
			new SpellSkip()
		};
		do{
			System.out.println("Choose a random deck(1) or make your own(2)?");
			deckStr = reader.next();
		}while(!(chkString(deckStr) > 0 && chkString(deckStr) < 3));
		
		deck = spells;
		
		Character user = new Character(deck, rand.nextInt((8000 - 100) + 1) + 100, "You");
		
		rand2 = new Random();
		
		Character opponent = new Character(opponentDeck, rand2.nextInt((8000 - 100) + 1) + 100, "They");
		
		while(user.getHP() >= 0 && opponent.getHP() >= 0){
			int choice = -1;
			int val = 0;
			
			System.out.println("You have "+user.getHP()+"/"+user.getMaxHP()+" health left.");
			System.out.println("The opponent has "+opponent.getHP()+"/"+opponent.getMaxHP()+" health left.");
			
			System.out.print("You: o");
			
			for(int i = 1; i < user.getPips(); i++){
				System.out.print("o");
			}
			
			System.out.print("\n");
			
			System.out.print("Opponent: o");
			
			for(int i = 1; i < opponent.getPips(); i++){
				System.out.print("o");
			}
			
			System.out.print("\n");
			
			for(Spell s : deck){
				val++;
				System.out.println(val+". "+s.name()+" - "+s.pips()+" pips");
			}
			
			do{
				String temp = reader.nextLine();
				if(chkString(temp) > 0 && chkString(temp) < 7){
					choice = chkString(temp) - 1;
				}
			}while(choice == -1);
			
			Collections.shuffle(Arrays.asList(opponentDeck));
			
			System.out.println("You used "+deck[choice].name());
			runSpell(deck[choice], user, opponent);
			System.out.println("They used "+opponentDeck[0].name());
			runSpell(opponentDeck[0], opponent, user);
			
			user.addPip();
			opponent.addPip();
		}
		
		System.out.println((user.getHP() <= 0) ? "The opponent won!" : "The user won!");
	}
	
	private static int chkString(String s){
		try{
			int ret = Integer.parseInt(s);
			
			return ret;
		}catch(NumberFormatException nfe){
			return 0;
		}
	}
	
	private static void runSpell(Spell s, Character user, Character opponent){
		if(s.pips() > user.getPips()){
			System.out.println("But "+user.getName().toLowerCase()+" didn't have enough pips!");
			return;
		}
		
		if(s.effect().effect(user, opponent) == false)
			System.out.println("But it fizzled!");
		else
			user.takePips(s.pips());
	}
	
	public static void debug(String s){
		if(debug) System.out.println(s);
	}
}
