package wizard101text.src;

public enum Global {
	NORMAL, POWERPLAY, DOOMANDGLOOM, SANCTUARY;
	
	public static String getName(Global name){
		switch(name){
			case POWERPLAY:
				return "Power Play";
			case DOOMANDGLOOM:
				return "Doom and Gloom";
			case SANCTUARY:
				return "Sanctuary";
			default:
				return "None";
		}
	}
}
