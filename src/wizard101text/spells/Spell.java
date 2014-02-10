package wizard101text.spells;

import wizard101text.spells.all.*;
import wizard101text.spells.all.cas.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Spell{
	public abstract SpellInterface effect();
	public abstract SpellType type();
	public abstract String name();
	public abstract int pips();
	
	public static Spell[] spellClasses = new Spell[]{
		new SpellDarkFairy(),
		new SpellDeathTrap(),
		new SpellScarab(),
		new SpellPixie(),
		new SpellSpiritTrap(),
		new SpellElementalTrap(),
		new SpellSandstorm(),
		new SpellLocustStorm(),
		new SpellPowerPlay(),
		new SpellSpectralBlast(),
		new SpellHydra(),
		new SpellReshuffle(),
		new SpellUnbalance(),
		new SpellSpiritBlade(),
		new SpellElementalBlade(),
		new SpellElementalShield(),
		new SpellSpiritShield(),
		new SpellGhoul(),
		new SpellDreamShield(),
		new SpellBanshee(),
		new SpellVampire(),
		new SpellSkeletalPirate(),
		new SpellFeint(),
		new SpellDoomAndGloom(),
		new SpellWraith(),
		new SpellStrangle(),
		new SpellDeathPrism(),
		new SpellSanctuary(),
		new SpellHealAura(),
		new SpellSunbird(),
		new SpellKraken()
	};
	
	public static String getCategory(Spell s){
		return SpellType.getTypeName(s.type())+" Spells";
	}
	
	public static Spell[] getAllInCategory(String s){
		List<Spell> ret = new ArrayList<Spell>();
		
		for(Spell sp : spellClasses){
			if(getCategory(sp) == s)
				ret.add(sp);
		}
		
		return ret.toArray(new Spell[0]);
	}
	
	public static boolean accuracy(double d){
		return Math.random() <= d;
	}
	
	public static Spell randomSpell(){
		Collections.shuffle(Arrays.asList(spellClasses));
		return spellClasses[0];	
	}
}
