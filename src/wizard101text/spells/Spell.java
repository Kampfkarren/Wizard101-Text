package wizard101text.spells;

import wizard101text.spells.all.*;
import java.util.Arrays;
import java.util.Collections;

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
		new SpellDoomAndGloom()
	};
	
	public static boolean accuracy(double d){
		return Math.random() <= d;
	}
	
	public static Spell randomSpell(){
		Collections.shuffle(Arrays.asList(spellClasses));
		return spellClasses[0];	
	}
}
