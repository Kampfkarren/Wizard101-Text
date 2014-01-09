package wizard101text.spells;

public enum SpellType {
	BALANCE, DEATH, LIFE, FIRE, ICE, STORM, MYTH, NONE;
	
	public static String getTypeName(SpellType type){
		switch(type){
			case BALANCE:
				return "Balance";
			case DEATH:
				return "Death";
			case LIFE:
				return "Life";
			case FIRE:
				return "Fire";
			case ICE:
				return "Ice";
			case STORM:
				return "Storm";
			case MYTH:
				return "Myth";
			default:
				return "None";	
		}
	}
}
