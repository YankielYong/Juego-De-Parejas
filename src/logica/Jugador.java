package logica;

public class Jugador {
	private String nick;
	private int posicion;
	
	public Jugador(String nick) {
		this.nick = nick;
		this.posicion = 0;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
}
