package logica;

import interfaz.Inicio;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
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

	public int lanzarDado(){
		return new Random().nextInt(6) + 1;
	}
	
	private void crearCasillas(){
		ImageIcon imgBajarEscalera = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/baja escalera.PNG"));
		Image bajarEscaleraArr = imgBajarEscalera.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconBajarEscalera = new ImageIcon(bajarEscaleraArr);
		
		ImageIcon imgCruzarPuente = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/cruza puente.PNG"));
		Image cruzarPuenteArr = imgCruzarPuente.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconCruzarPuente = new ImageIcon(cruzarPuenteArr);
		
		ImageIcon imgConfesion = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/confesion p.PNG"));
		Image confesionArr = imgConfesion.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconConfesion = new ImageIcon(confesionArr);
		
		ImageIcon imgRopaFuera = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/ropa fuera p.PNG"));
		Image ropaFueraArr = imgRopaFuera.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconRopaFuera = new ImageIcon(ropaFueraArr);
		
		ImageIcon imgBeso = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/beso p.PNG"));
		Image besoArr = imgBeso.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconBeso = new ImageIcon(besoArr);
		
		ImageIcon imgBesoCuello = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/beso cuello p.PNG"));
		Image besoCuelloArr = imgBesoCuello.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconBesoCuello = new ImageIcon(besoCuelloArr);
		
		ImageIcon imgBesoCarinyo = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/beso cariñoso p.PNG"));
		Image besoCarinyoArr = imgBesoCarinyo.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconBesoCarinyo = new ImageIcon(besoCarinyoArr);
		
		ImageIcon imgLamer = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/lamer p.PNG"));
		Image lamerArr = imgLamer.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconLamer = new ImageIcon(lamerArr);
		
		ImageIcon imgMorder = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/morder p.PNG"));
		Image morderArr = imgMorder.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconMorder = new ImageIcon(morderArr);
		
		ImageIcon imgDemostracion = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/demostracion p.PNG"));
		Image demostracionArr = imgDemostracion.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconDemostracion = new ImageIcon(demostracionArr);
		
		ImageIcon imgDescripcion = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/descripcion p.PNG"));
		Image descripcionArr = imgDescripcion.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconDescripcion = new ImageIcon(descripcionArr);
		
		ImageIcon imgBaileSexy = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/baile sexy p.PNG"));
		Image baileSexyArr = imgBaileSexy.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconBaileSexy = new ImageIcon(baileSexyArr);
		
		ImageIcon imgMasaje = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/masaje p.PNG"));
		Image masajeArr = imgMasaje.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconMasaje = new ImageIcon(masajeArr);
		
		ImageIcon imgEscogePrueba = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/escoge prueba p.PNG"));
		Image escogePruebaArr = imgEscogePrueba.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconEscogePrueba = new ImageIcon(escogePruebaArr);
		
		ImageIcon imgNalgada = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/nalgada p.PNG"));
		Image nalgadaArr = imgNalgada.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconNalgada = new ImageIcon(nalgadaArr);
		
		ImageIcon imgACiegas = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/a ciegas p.PNG"));
		Image aCiegasArr = imgACiegas.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconACiegas = new ImageIcon(aCiegasArr);
		
		ImageIcon imgMostrarRI = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/mostrar ri p.PNG"));
		Image mostrarRIArr = imgMostrarRI.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconMostrarRI = new ImageIcon(mostrarRIArr);
		
		ImageIcon imgCuclillasRI = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/cuclillas ri p.PNG"));
		Image cuclillasRIArr = imgCuclillasRI.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconCuclillasRI = new ImageIcon(cuclillasRIArr);
		
		ImageIcon imgQuedarseRI = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/quedarse ri p.PNG"));
		Image quedarseRIArr = imgQuedarseRI.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconQuedarseRI = new ImageIcon(quedarseRIArr);
		
		ImageIcon imgSusurro = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/susurro p.PNG"));
		Image susurroArr = imgSusurro.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconSusurro = new ImageIcon(susurroArr);
		
		ImageIcon imgTocar = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/tocar p.PNG"));
		Image tocarArr = imgTocar.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconTocar = new ImageIcon(tocarArr);
		
		ImageIcon imgAtar = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/atala p.PNG"));
		Image atarArr = imgAtar.getImage().getScaledInstance(120, 90, Image.SCALE_SMOOTH);
		Icon iconAtar = new ImageIcon(atarArr);
		
		casillas = new ArrayList<Casilla>(41);
		
		Casilla c00 = new Casilla("SALIDA");
		c00.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/00 salida p.PNG")));
		c00.setBounds(new Rectangle(30, 540, 140, 140));
		c00.setpJ1(new Point(55, 610));
		c00.setpJ2(new Point(111, 610));
		casillas.add(c00);
		
		Casilla c01 = new Casilla("Confiesa la parte de su cuerpo que mas te gusta");
		c01.setImagenP(iconConfesion);
		c01.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/01 confesion.png")));
		c01.setBounds(new Rectangle(170, 590, 120, 90));
		c01.setpJ1(new Point(190, 610));
		c01.setpJ2(new Point(236, 610));
		casillas.add(c01);
		
		Casilla c02 = new Casilla("Quitate una prenda");
		c02.setImagenP(iconRopaFuera);
		c02.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/02 ropa fuera.png")));
		c02.setBounds(new Rectangle(290, 590, 120, 90));
		c02.setpJ1(new Point(310, 610));
		c02.setpJ2(new Point(356, 610));
		casillas.add(c02);
		
		Casilla c03 = new Casilla("Hazle un masaje de 30 segundos donde te pidan");
		c03.setImagenP(iconMasaje);
		c03.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/03 masaje.png")));
		c03.setBounds(new Rectangle(410, 590, 120, 90));
		c03.setpJ1(new Point(430, 610));
		c03.setpJ2(new Point(476, 610));
		casillas.add(c03);
		
		Casilla c04 = new Casilla("Beso sin tocarse durante 30 segundos");
		c04.setImagenP(iconBeso);
		c04.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/04 beso.png")));
		c04.setBounds(new Rectangle(530, 590, 120, 90));
		c04.setpJ1(new Point(550, 610));
		c04.setpJ2(new Point(596, 610));
		casillas.add(c04);
		
		Casilla c05 = new Casilla("Quitale una prenda");
		c05.setImagenP(iconRopaFuera);
		c05.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/05 ropa fuera.png")));
		c05.setBounds(new Rectangle(650, 590, 120, 90));
		c05.setpJ1(new Point(670, 610));
		c05.setpJ2(new Point(716, 610));
		casillas.add(c05);
		
		Casilla c06 = new Casilla("Dale una nalgada");
		c06.setImagenP(iconNalgada);
		c06.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/06 nalgada.png")));
		c06.setBounds(new Rectangle(770, 590, 120, 90));
		c06.setpJ1(new Point(790, 610));
		c06.setpJ2(new Point(836, 610));
		casillas.add(c06);
		
		Casilla c07 = new Casilla("Susurrale algo hot");
		c07.setImagenP(iconSusurro);
		c07.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/07 susurro.png")));
		c07.setBounds(new Rectangle(890, 590, 120, 90));
		c07.setpJ1(new Point(910, 610));
		c07.setpJ2(new Point(956, 610));
		casillas.add(c07);
		
		Casilla c08 = new Casilla("Muestrale tu ropa interior");
		c08.setImagenP(iconMostrarRI);
		c08.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/08 ri.png")));
		c08.setBounds(new Rectangle(1010, 590, 120, 90));
		c08.setpJ1(new Point(1030, 610));
		c08.setpJ2(new Point(1076, 610));
		casillas.add(c08);
		
		Casilla c09 = new Casilla("Confiesa una fantasia sexual");
		c09.setImagenP(iconConfesion);
		c09.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/09 confesion.png")));
		c09.setBounds(new Rectangle(1130, 590, 120, 90));
		c09.setpJ1(new Point(1150, 610));
		c09.setpJ2(new Point(1196, 610));
		casillas.add(c09);
		
		Casilla c10 = new Casilla("Toca lo que quieras");
		c10.setImagenP(iconTocar);
		c10.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/10 tocar.png")));
		c10.setBounds(new Rectangle(1130, 500, 120, 90));
		c10.setpJ1(new Point(1150, 520));
		c10.setpJ2(new Point(1196, 520));
		casillas.add(c10);
		
		Casilla c11 = new Casilla("20 cuclillas en ropa interior");
		c11.setImagenP(iconCuclillasRI);
		c11.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/11 ri.png")));
		c11.setBounds(new Rectangle(1130, 410, 120, 90));
		c11.setpJ1(new Point(1150, 430));
		c11.setpJ2(new Point(1196, 430));
		casillas.add(c11);
		
		Casilla c12 = new Casilla("Quitate una prenda");
		c12.setImagenP(iconRopaFuera);
		c12.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/12 ropa fuera.png")));
		c12.setBounds(new Rectangle(1130, 320, 120, 90));
		c12.setpJ1(new Point(1150, 340));
		c12.setpJ2(new Point(1196, 340));
		casillas.add(c12);
		
		Casilla c13 = new Casilla("Hacerle un baile sexy de 30 segundos");
		c13.setImagenP(iconBaileSexy);
		c13.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/13 baile sexy.png")));
		c13.setBounds(new Rectangle(1130, 230, 120, 90));
		c13.setpJ1(new Point(1150, 250));
		c13.setpJ2(new Point(1196, 250));
		casillas.add(c13);
		
		Casilla c14 = new Casilla("Besal@ donde te pida");
		c14.setImagenP(iconBeso);
		c14.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/14 beso.png")));
		c14.setBounds(new Rectangle(1130,140, 120, 90));
		c14.setpJ1(new Point(1150, 160));
		c14.setpJ2(new Point(1196, 160));
		casillas.add(c14);
		
		Casilla c15 = new Casilla("Ponle una venda y hazle lo que quieras durante 30 segundos");
		c15.setImagenP(iconACiegas);
		c15.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/15 a ciegas.png")));
		c15.setBounds(new Rectangle(1010,140, 120, 90));
		c15.setpJ1(new Point(1030, 160));
		c15.setpJ2(new Point(1076, 160));
		casillas.add(c15);
		
		Casilla c16 = new Casilla("Lame la parte de su cuerpo que quieras");
		c16.setImagenP(iconLamer);
		c16.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/16 lamer.png")));
		c16.setBounds(new Rectangle(890,140, 120, 90));
		c16.setpJ1(new Point(910, 160));
		c16.setpJ2(new Point(956, 160));
		casillas.add(c16);
		
		Casilla c17 = new Casilla("Recibes un masaje de 30 segundos donde quieras");
		c17.setImagenP(iconMasaje);
		c17.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/17 masaje.png")));
		c17.setBounds(new Rectangle(890, 230, 120, 90));
		c17.setpJ1(new Point(910, 250));
		c17.setpJ2(new Point(956, 250));
		casillas.add(c17);
		
		Casilla c18 = new Casilla("Cruza por el puente");
		c18.setImagenP(iconCruzarPuente);
		c18.setBounds(new Rectangle(890, 320, 120, 90));
		c18.setpJ1(new Point(910, 340));
		c18.setpJ2(new Point(956, 340));
		casillas.add(c18);
		
		Casilla c19 = new Casilla("Besa todo su cuerpo");
		c19.setImagenP(iconBeso);
		c19.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/19 beso.png")));
		c19.setBounds(new Rectangle(890, 410, 120, 90));
		c19.setpJ1(new Point(910, 430));
		c19.setpJ2(new Point(956, 430));
		casillas.add(c19);
		
		Casilla c20 = new Casilla("Recibes un baile sexy de 30 segundos");
		c20.setImagenP(iconBaileSexy);
		c20.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/20 baile sexy.png")));
		c20.setBounds(new Rectangle(770, 410, 120, 90));
		c20.setpJ1(new Point(790, 430));
		c20.setpJ2(new Point(836, 430));
		casillas.add(c20);
		
		Casilla c21 = new Casilla("Besal@ y acaricial@ dulcemente");
		c21.setImagenP(iconBesoCarinyo);
		c21.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/21 beso cariñoso.png")));
		c21.setBounds(new Rectangle(650, 410, 120, 90));
		c21.setpJ1(new Point(670, 430));
		c21.setpJ2(new Point(716, 430));
		casillas.add(c21);
		
		Casilla c22 = new Casilla("Quitale una prenda usando la boca");
		c22.setImagenP(iconRopaFuera);
		c22.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/22 ropa fuera.png")));
		c22.setBounds(new Rectangle(530, 410, 120, 90));
		c22.setpJ1(new Point(550, 430));
		c22.setpJ2(new Point(596, 430));
		casillas.add(c22);
		
		Casilla c23 = new Casilla("Ponte una venda y deja que te haga lo que quiera durante 30 segundos");
		c23.setImagenP(iconACiegas);
		c23.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/23 a ciegas.png")));
		c23.setBounds(new Rectangle(410, 410, 120, 90));
		c23.setpJ1(new Point(430, 430));
		c23.setpJ2(new Point(476, 430));
		casillas.add(c23);
		
		Casilla c24 = new Casilla("Baja por la escalera");
		c24.setImagenP(iconBajarEscalera);
		c24.setBounds(new Rectangle(290, 410, 120, 90));
		c24.setpJ1(new Point(310, 430));
		c24.setpJ2(new Point(356, 430));
		casillas.add(c24);
		
		Casilla c25 = new Casilla("Describele una posicion que te gustaria hacer ahora mismo  ");
		c25.setImagenP(iconDescripcion);
		c25.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/25 descripcion.png")));
		c25.setBounds(new Rectangle(170, 410, 120, 90));
		c25.setpJ1(new Point(190, 430));
		c25.setpJ2(new Point(236, 430));
		casillas.add(c25);
		
		Casilla c26 = new Casilla("Lamen tus pechos");
		c26.setImagenP(iconLamer);
		c26.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/26 lamer.png")));
		c26.setBounds(new Rectangle(50, 410, 120, 90));
		c26.setpJ1(new Point(70, 430));
		c26.setpJ2(new Point(116, 430));
		casillas.add(c26);
		
		Casilla c27 = new Casilla("Confiesa lo que mas te prende");
		c27.setImagenP(iconConfesion);
		c27.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/27 confesion.png")));
		c27.setBounds(new Rectangle(50, 320, 120, 90));
		c27.setpJ1(new Point(70, 340));
		c27.setpJ2(new Point(116, 340));
		casillas.add(c27);
		
		Casilla c28 = new Casilla("Muerde la parte de su cuerpo que mas te gusta");
		c28.setImagenP(iconMorder);
		c28.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/28 morder.png")));
		c28.setBounds(new Rectangle(50, 230, 120, 90));
		c28.setpJ1(new Point(70, 250));
		c28.setpJ2(new Point(116, 250));
		casillas.add(c28);
		
		Casilla c29 = new Casilla("Beso de lengua de al menos 30 segundos");
		c29.setImagenP(iconBeso);
		c29.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/29 beso.png")));
		c29.setBounds(new Rectangle(170, 230, 120, 90));
		c29.setpJ1(new Point(190, 250));
		c29.setpJ2(new Point(236, 250));
		casillas.add(c29);
		
		Casilla c30 = new Casilla("Lame la parte de su cuerpo que te pida");
		c30.setImagenP(iconLamer);
		c30.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/30 lamer.png")));
		c30.setBounds(new Rectangle(290, 230, 120, 90));
		c30.setpJ1(new Point(310, 250));
		c30.setpJ2(new Point(356, 250));
		casillas.add(c30);
		
		Casilla c31 = new Casilla("Quedate en ropa interior");
		c31.setImagenP(iconQuedarseRI);
		c31.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/31 ri.png")));
		c31.setBounds(new Rectangle(410, 230, 120, 90));
		c31.setpJ1(new Point(430, 250));
		c31.setpJ2(new Point(476, 250));
		casillas.add(c31);
		
		Casilla c32 = new Casilla("Besale el cuello durante al menos 15 segundos");
		c32.setImagenP(iconBesoCuello);
		c32.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/32 beso cuello.png")));
		c32.setBounds(new Rectangle(530, 230, 120, 90));
		c32.setpJ1(new Point(550, 250));
		c32.setpJ2(new Point(596, 250));
		casillas.add(c32);
		
		Casilla c33 = new Casilla("Atal@ y hazle lo que quieras");
		c33.setImagenP(iconAtar);
		c33.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/33 atala.png")));
		c33.setBounds(new Rectangle(650, 230, 120, 90));
		c33.setpJ1(new Point(670, 250));
		c33.setpJ2(new Point(716, 250));
		casillas.add(c33);
		
		Casilla c34 = new Casilla("Cruza por el puente");
		c34.setImagenP(iconCruzarPuente);
		c34.setBounds(new Rectangle(650, 140, 120, 90));
		c34.setpJ1(new Point(670, 160));
		c34.setpJ2(new Point(716, 160));
		casillas.add(c34);
		
		Casilla c35 = new Casilla("Coge mis manos y enseñame como te gusta que te toque");
		c35.setImagenP(iconDemostracion);
		c35.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/35 demostracion.png")));
		c35.setBounds(new Rectangle(650, 50, 120, 90));
		c35.setpJ1(new Point(670, 70));
		c35.setpJ2(new Point(716, 70));
		casillas.add(c35);
		
		Casilla c36 = new Casilla("Mete tu mano por debajo de su ropa");
		c36.setImagenP(iconTocar);
		c36.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/36 tocar.png")));
		c36.setBounds(new Rectangle(530, 50, 120, 90));
		c36.setpJ1(new Point(550, 70));
		c36.setpJ2(new Point(596, 70));
		casillas.add(c36);
		
		Casilla c37 = new Casilla("Besale la parte de su cuerpo que quieras");
		c37.setImagenP(iconBeso);
		c37.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/37 beso.png")));
		c37.setBounds(new Rectangle(410, 50, 120, 90));
		c37.setpJ1(new Point(430, 70));
		c37.setpJ2(new Point(476, 70));
		casillas.add(c37);
		
		Casilla c38 = new Casilla("Baja por la escalera");
		c38.setImagenP(iconBajarEscalera);
		c38.setBounds(new Rectangle(290, 50, 120, 90));
		c38.setpJ1(new Point(310, 70));
		c38.setpJ2(new Point(356, 70));
		casillas.add(c38);
		
		Casilla c39 = new Casilla("Escoge una de las pruebas");
		c39.setImagenP(iconEscogePrueba);
		c39.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/39 escoge prueba.png")));
		c39.setBounds(new Rectangle(170, 50, 120, 90));
		c39.setpJ1(new Point(190, 70));
		c39.setpJ2(new Point(236, 70));
		casillas.add(c39);
		
		Casilla c40 = new Casilla("ESCOGE TU PREMIO");
		c40.setImagenP(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/40 escoge tu premio p.PNG")));
		c40.setImagenG(new ImageIcon(Inicio.class.getResource("/imagenes_casillas/40 escoge tu premio g.PNG")));
		c40.setBounds(new Rectangle(30, 30, 140, 140));
		c40.setpJ1(new Point(55, 70));
		c40.setpJ2(new Point(111, 70));
		casillas.add(c40);
	}
}
