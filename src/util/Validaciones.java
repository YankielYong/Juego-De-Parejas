package util;

public class Validaciones {
	public static boolean jugador(String nick){
		boolean ok = false;
		if(!nick.isEmpty())
			for(int i=0; i<nick.length() && !ok; i++)
				if(!Character.isSpaceChar(nick.charAt(i)))
					ok = true;
		return ok;
	}
}
