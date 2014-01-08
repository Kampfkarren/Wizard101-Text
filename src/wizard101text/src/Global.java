package wizard101text.src;

public enum Global {
	NORMAL, POWERPLAY;
	
	public static String getName(Global name){
		switch(name){
			case POWERPLAY:
				return "Power Play";
			default:
				return "None";
		}
	}
}
