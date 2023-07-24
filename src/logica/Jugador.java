package logica;

import java.awt.Color;

public class Jugador {
	private String nick;
	private Color color;
	private int posicion;
	
	public Jugador(String nick, Color color) {
		this.nick = nick;
		this.color = color;
		this.posicion = 0;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color color){
		this.color = color;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
