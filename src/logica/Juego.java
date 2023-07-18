package logica;

import java.util.ArrayList;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private ArrayList<Casilla> casillas;
	
	public Juego(Jugador j1, Jugador j2){
		jugador1 = j1;
		jugador2 = j2;
		crearCasillas();
	}
	
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	public ArrayList<Casilla> getCasillas() {
		return casillas;
	}

	private void crearCasillas(){
		casillas = new ArrayList<Casilla>(40);
	}
}
