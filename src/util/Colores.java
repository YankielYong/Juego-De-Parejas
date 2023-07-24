package util;

import java.awt.Color;

public class Colores {

	public static int ROJO = 1;
	public static int NARANJA = 2;
	public static int AMARILLO = 3;
	public static int VERDE = 4;
	public static int AZUL = 5;
	public static int MORADO = 6;
	public static int ROSA = 7;
	public static int GRIS = 8;
	
	public static Color C_ROJO = new Color(255, 0, 0);
	public static Color C_NARANJA = new Color(255, 128, 0);
	public static Color C_AMARILLO = new Color(255, 255, 0);
	public static Color C_VERDE = new Color(0, 176, 80);
	public static Color C_AZUL = new Color(0, 112, 192);
	public static Color C_MORADO = new Color(112, 48, 160);
	public static Color C_ROSA = new Color(255, 51, 204);
	public static Color C_GRIS = new Color(128, 128, 128);
	
	public static int numeroColor(Color c){
		int n = 0;
		
		if(c.equals(C_ROJO))
			n = ROJO;
		else if(c.equals(C_NARANJA))
			n = NARANJA;
		else if(c.equals(C_AMARILLO))
			n = AMARILLO;
		else if(c.equals(C_VERDE))
			n = VERDE;
		else if(c.equals(C_AZUL))
			n = AZUL;
		else if(c.equals(C_MORADO))
			n = MORADO;
		else if(c.equals(C_ROSA))
			n = ROSA;
		else if(c.equals(C_GRIS))
			n = GRIS;
		
		return n;
	}
}
