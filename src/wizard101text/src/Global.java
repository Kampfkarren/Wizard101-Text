package wizard101text.src;

public enum Global {
	NORMAL, POWERPLAY, DOOMANDGLOOM;
	
	public static String getName(Global name){
		switch(name){
			case POWERPLAY:
				return "Power Play";
			case DOOMANDGLOOM:
				return "Doom and Gloom";
			default:
				return "None";
		}
	}
}
