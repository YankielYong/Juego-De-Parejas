package logica;

import interfaz.Inicio;

import java.util.ArrayList;

import javax.swing.ImageIcon;

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
		casillas = new ArrayList<Casilla>(41);
		
		Casilla c00 = new Casilla("SALIDA");
		c00.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c00);
		
		Casilla c01 = new Casilla("");
		c01.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c01);
		
		Casilla c02 = new Casilla("");
		c02.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c02);
		
		Casilla c03 = new Casilla("");
		c03.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c03);
		
		Casilla c04 = new Casilla("");
		c04.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c04);
		
		Casilla c05 = new Casilla("SALIDA");
		c05.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c05);
		
		Casilla c06 = new Casilla("");
		c06.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c06);
		
		Casilla c07 = new Casilla("");
		c07.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c07);
		
		Casilla c08 = new Casilla("");
		c08.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c08);
		
		Casilla c09 = new Casilla("");
		c09.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c09);
		
		Casilla c10 = new Casilla("");
		c10.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c10);
		
		Casilla c11 = new Casilla("");
		c11.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c11);
		
		Casilla c12 = new Casilla("");
		c12.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c12);
		
		Casilla c13 = new Casilla("");
		c13.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c13);
		
		Casilla c14 = new Casilla("");
		c14.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c14);
		
		Casilla c15 = new Casilla("SALIDA");
		c15.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c15);
		
		Casilla c16 = new Casilla("");
		c16.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c16);
		
		Casilla c17 = new Casilla("");
		c17.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c17);
		
		Casilla c18 = new Casilla("Cruza por el puente");
		c18.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/cruza puente.png")));
		casillas.add(c18);
		
		Casilla c19 = new Casilla("");
		c19.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c19);
		
		Casilla c20 = new Casilla("");
		c20.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c20);
		
		Casilla c21 = new Casilla("");
		c21.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c21);
		
		Casilla c22 = new Casilla("");
		c22.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c22);
		
		Casilla c23 = new Casilla("");
		c23.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c23);
		
		Casilla c24 = new Casilla("Baja por la escalera");
		c24.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/baja escalera.png")));
		casillas.add(c24);
		
		Casilla c25 = new Casilla("SALIDA");
		c25.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c25);
		
		Casilla c26 = new Casilla("");
		c26.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c26);
		
		Casilla c27 = new Casilla("");
		c27.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c27);
		
		Casilla c28 = new Casilla("");
		c28.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c28);
		
		Casilla c29 = new Casilla("");
		c29.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c29);
		
		Casilla c30 = new Casilla("");
		c30.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c30);
		
		Casilla c31 = new Casilla("");
		c31.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c31);
		
		Casilla c32 = new Casilla("");
		c32.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c32);
		
		Casilla c33 = new Casilla("");
		c33.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c33);
		
		Casilla c34 = new Casilla("Cruza por el puente");
		c34.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/cruza puente.png")));
		casillas.add(c34);
		
		Casilla c35 = new Casilla("SALIDA");
		c35.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c35);
		
		Casilla c36 = new Casilla("");
		c36.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c36);
		
		Casilla c37 = new Casilla("");
		c37.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c37);
		
		Casilla c38 = new Casilla("Baja por la escalera");
		c38.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/baja escalera.PNG")));
		casillas.add(c38);
		
		Casilla c39 = new Casilla("");
		c39.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		casillas.add(c39);
		
		Casilla c40 = new Casilla("ESCOGE TU PREMIO");
		c40.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/40 escoge tu premio p.PNG")));
		c40.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/40 escoge tu premio g.PNG")));
		casillas.add(c40);
	}
}
