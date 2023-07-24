package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import util.Colores;
import util.MyButtonModel;
import util.Validaciones;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import logica.Juego;
import logica.Jugador;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private Inicio este;

	/*
	 * Panel General
	 */
	private JPanel contentPane;
	/*
	 * Panel Superior donde estaran los botones de cerrar y minimizar
	 */
	private JPanel panelSuperior;
	private JButton btnCerrar;
	private JButton btnMinimizar;
	private int xMouse;
	private int yMouse;
	/*
	 * Panel donde se introducen los nombres de los jugadores
	 */
	private JPanel panelInicio;
	private JLabel lblTitulo;
	private JLabel lblJ1;
	private JLabel lblJ2;
	private JTextField txtJ1;
	private JTextField txtJ2;
	private JLabel colorJ1;
	private JLabel colorJ2;
	private JButton btnIniciar;
	private JLabel lblCorazon;
	private JLabel lblLabios;
	private JLabel lblFuego;
	private JLabel lblEmoji;
	private String txt;
	/*
	 * Panel para cambiar color de jugador
	 */
	private JPanel panelColor;
	private boolean panelColorVisible = false;
	/*
	 * Panel donde se mostrara el tablero
	 */
	private JPanel panelTablero;
	/*
	 * Panel donde saldra el reto
	 */
	private JPanel panelCasilla;
	private JLabel casillaG;
	/*
	 * Casillas
	 */
	private JLabel casilla00;
	private JLabel casilla01;
	private JLabel casilla02;
	private JLabel casilla03;
	private JLabel casilla04;
	private JLabel casilla05;
	private JLabel casilla06;
	private JLabel casilla07;
	private JLabel casilla08;
	private JLabel casilla09;
	private JLabel casilla10;
	private JLabel casilla11;
	private JLabel casilla12;
	private JLabel casilla13;
	private JLabel casilla14;
	private JLabel casilla15;
	private JLabel casilla16;
	private JLabel casilla17;
	private JLabel casilla18;
	private JLabel casilla19;
	private JLabel casilla20;
	private JLabel casilla21;
	private JLabel casilla22;
	private JLabel casilla23;
	private JLabel casilla24;
	private JLabel casilla25;
	private JLabel casilla26;
	private JLabel casilla27;
	private JLabel casilla28;
	private JLabel casilla29;
	private JLabel casilla30;
	private JLabel casilla31;
	private JLabel casilla32;
	private JLabel casilla33;
	private JLabel casilla34;
	private JLabel casilla35;
	private JLabel casilla36;
	private JLabel casilla37;
	private JLabel casilla38;
	private JLabel casilla39;
	private JLabel casilla40;
	private JLabel escalera01;
	private JLabel escalera02;
	private JLabel puente01;
	private JLabel puente02;
	/*
	 * Zona del dado
	 */
	private JLabel nombreJugador;
	private JLabel lanzaDados;
	private JPanel panelDados;
	private JLabel dado;
	private Icon dado1;
	private Icon dado2;
	private Icon dado3;
	private Icon dado4;
	private Icon dado5;
	private Icon dado6;
	private int tirada;
	private Timer timer;
	private boolean isCanceled = true;
	/*
	 * Para controlar animacion del dado
	 */
	private TimerTask contTimerTask;
	private Timer controlador;
	/*
	 * Fichas
	 */
	private JLabel fichaJ1;
	private JLabel fichaJ2;
	/*
	 * Para controlar animacion de movimiento de ficha
	 */
	private TimerTask animMover;
	private TimerTask contFichasTT;
	private Timer contFichas;
	private boolean moviendoFicha = false;

	private boolean terminarJuego = false;
	private Juego game;
	private Jugador j1;
	private Jugador j2;
	private Jugador jugadorActual;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		
		este = this;
		
		/*-----------------------------------*\
		|     Panel General Con Sus Datos     |
		\*-----------------------------------*/
		setResizable(false);
		setTitle("Juego de Parejas");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);


		/*--------------------------------------------------------*\
		|     Panel Superior Con Botones de cerrar y minimizar     |
		\*--------------------------------------------------------*/
		panelSuperior = new JPanel();
		panelSuperior.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-xMouse, y-yMouse);
			}
		});
		panelSuperior.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
				if(panelColorVisible)
					cerrarPanelColor();
			}
		});
		panelSuperior.setBackground(new Color(200, 0, 0));
		panelSuperior.setBounds(1, 1, 1278, 26);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);

		ImageIcon imgCerrar = new ImageIcon(Inicio.class.getResource("/imagenes/close.png"));
		Image cerrarArr = imgCerrar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Icon iconCerrar = new ImageIcon(cerrarArr);

		btnCerrar = new JButton("");
		btnCerrar.setIcon(iconCerrar);
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setContentAreaFilled(false);
			}
		});
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setBackground(new Color(250, 128, 114));
		btnCerrar.setModel(new MyButtonModel());
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCerrar.setBounds(1238, 0, 40, 26);
		btnCerrar.setFocusable(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		panelSuperior.add(btnCerrar);

		btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/minimize.png")));
		btnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimizar.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMinimizar.setContentAreaFilled(false);
			}
		});
		btnMinimizar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMinimizar.setBackground(SystemColor.scrollbar);
		btnMinimizar.setModel(new MyButtonModel());
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMinimizar.setContentAreaFilled(false);
				setExtendedState(ICONIFIED);
			}
		});
		btnMinimizar.setBounds(1198, 0, 40, 26);
		btnMinimizar.setFocusable(false);
		btnMinimizar.setContentAreaFilled(false);
		btnMinimizar.setBorderPainted(false);
		panelSuperior.add(btnMinimizar);


		/*---------------------------------------------------------------*\
		|     Panel Inicio para introducir los datos de los jugadores     |
		\*---------------------------------------------------------------*/
		panelInicio = new JPanel();
		panelInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelColorVisible)
					cerrarPanelColor();
			}
		});
		panelInicio.setBackground(Color.WHITE);
		panelInicio.setBounds(1, 27, 1278, 692);
		panelInicio.setLayout(null);
		contentPane.add(panelInicio);

		lblJ1 = new JLabel("Jugador 1");
		lblJ1.setForeground(Color.BLACK);
		lblJ1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblJ1.setBounds(400, 220, 300, 50);
		panelInicio.add(lblJ1);

		lblJ2 = new JLabel("Jugador 2");
		lblJ2.setForeground(Color.BLACK);
		lblJ2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblJ2.setBounds(400, 380, 300, 50);
		panelInicio.add(lblJ2);

		lblTitulo = new JLabel();
		lblTitulo.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/titulo.png")));
		lblTitulo.setBounds(140, 40, 1000, 100);
		panelInicio.add(lblTitulo);

		txtJ1 = new JTextField();
		txtJ1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(panelColorVisible)
					cerrarPanelColor();
			}
		});
		txtJ1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				realizarAccion(1, e.getKeyCode());
				txt = txtJ1.getText();
				if(Validaciones.jugador(txt)){
					j1 = new Jugador(txt, colorJ1.getBackground());
					actualizarBoton();
				}
				else{
					j1 = null;
					actualizarBoton();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean ok = false;
				if((key >= 65 && key <= 90) || (key >= 97 && key <= 122))
					ok = true;
				if(!ok)
					e.consume();
			}
		});
		txtJ1.setFont(new Font("Arial", Font.PLAIN, 24));
		txtJ1.setForeground(Color.BLACK);
		txtJ1.setBorder(new LineBorder(new Color(200, 0, 0), 4, true));
		txtJ1.setBackground(Color.WHITE);
		txtJ1.setBounds(400, 270, 480, 50);
		panelInicio.add(txtJ1);

		txtJ2 = new JTextField();
		txtJ2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(panelColorVisible)
					cerrarPanelColor();
			}
		});
		txtJ2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				realizarAccion(2, e.getKeyCode());
				txt = txtJ2.getText();
				if(Validaciones.jugador(txt)){
					j2 = new Jugador(txt, colorJ2.getBackground());
					actualizarBoton();
				}
				else{
					j2 = null;
					actualizarBoton();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean ok = false;
				if((key >= 65 && key <= 90) || (key >= 97 && key <= 122))
					ok = true;
				if(!ok)
					e.consume();
			}
		});
		txtJ2.setFont(new Font("Arial", Font.PLAIN, 24));
		txtJ2.setForeground(Color.BLACK);
		txtJ2.setBorder(new LineBorder(new Color(200, 0, 0), 4, true));
		txtJ2.setBackground(Color.WHITE);
		txtJ2.setBounds(400, 430, 480, 50);
		panelInicio.add(txtJ2);

		colorJ1 = new JLabel("");
		colorJ1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelColorVisible)
					cerrarPanelColor();
				llamarPanelCambiarColor(colorJ1);
				panelColorVisible = true;
			}
		});
		colorJ1.setOpaque(true);
		colorJ1.setBackground(new Color(255, 0, 0));
		colorJ1.setBorder(new LineBorder(new Color(80, 80, 80), 2));
		colorJ1.setBounds(900, 270, 50, 50);
		panelInicio.add(colorJ1);

		colorJ2 = new JLabel("");
		colorJ2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelColorVisible)
					cerrarPanelColor();
				llamarPanelCambiarColor(colorJ2);
				panelColorVisible = true;
			}
		});
		colorJ2.setOpaque(true);
		colorJ2.setBackground(new Color(0, 112, 192));
		colorJ2.setBorder(new LineBorder(new Color(80, 80, 80), 2));
		colorJ2.setBounds(900, 430, 50, 50);
		panelInicio.add(colorJ2);

		btnIniciar = new JButton("Jugar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarPanelTablero(panelInicio);
				game = new Juego(j1, j2);
				jugadorActual = j1;
				colocarFichas();
				inicializarCasillas();
				inicializarZonaDados();
			}
		});
		btnIniciar.setModel(new MyButtonModel());
		btnIniciar.setForeground(Color.BLACK);
		btnIniciar.setBorder(new LineBorder(new Color(150, 0, 0), 4));
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnIniciar.isEnabled())
					btnIniciar.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(btnIniciar.isEnabled())
					btnIniciar.setBackground(Color.white);
			}
		});
		btnIniciar.setFont(new Font("Arial", Font.BOLD, 30));
		btnIniciar.setBackground(Color.white);
		btnIniciar.setBounds(400, 580, 480, 50);
		btnIniciar.setFocusable(false);
		btnIniciar.setEnabled(false);
		panelInicio.add(btnIniciar);

		lblCorazon = new JLabel("");
		lblCorazon.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/coraz dr.png")));
		lblCorazon.setBounds(140, 254, 98, 98);
		panelInicio.add(lblCorazon);

		lblLabios = new JLabel("");
		lblLabios.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/labios 96.png")));
		lblLabios.setBounds(987, 500, 96, 96);
		panelInicio.add(lblLabios);

		lblFuego = new JLabel("");
		lblFuego.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/emoji fuego 96.png")));
		lblFuego.setBounds(208, 474, 96, 96);
		panelInicio.add(lblFuego);

		lblEmoji = new JLabel("");
		lblEmoji.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/emoji enamorado 96.png")));
		lblEmoji.setBounds(1110, 270, 98, 98);
		panelInicio.add(lblEmoji);


		/*---------------------*\
		|     Panel Tablero     |
		\*---------------------*/
		panelTablero = new JPanel();
		panelTablero.setBackground(Color.WHITE);
		panelTablero.setBounds(1, 27, 1278, 692);
		panelTablero.setLayout(null);

		panelDados = new JPanel();
		panelDados.setBackground(new Color(200, 0, 0));
		panelDados.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDados.setBounds(1130, 15, 120, 100);
		panelDados.setLayout(null);
		panelTablero.add(panelDados);


	}

	/**
	 * Coloca las fichas
	 */
	private void colocarFichas(){
		ImageIcon imgFicha1 = null;
		Image imageFicha1 = null;
		Icon iconFich1 = null;
		ImageIcon imgFicha2 = null;
		Image imageFicha2 = null;
		Icon iconFich2 = null;
		int colJ1 = Colores.numeroColor(j1.getColor());
		int colJ2 = Colores.numeroColor(j2.getColor());

		switch(colJ1){
		case 1:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha roja.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 2:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha naranja.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 3:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha amarilla.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 4:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha verde.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 5:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha azul.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 6:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha morada.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 7:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha rosa.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 8:
			imgFicha1 = new ImageIcon(Inicio.class.getResource("/fichas/ficha gris.png"));
			imageFicha1 = imgFicha1.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		}

		switch(colJ2){
		case 1:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha roja.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 2:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha naranja.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 3:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha amarilla.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 4:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha verde.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 5:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha azul.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 6:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha morada.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 7:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha rosa.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		case 8:
			imgFicha2 = new ImageIcon(Inicio.class.getResource("/fichas/ficha gris.png"));
			imageFicha2 = imgFicha2.getImage().getScaledInstance(34, 50, Image.SCALE_SMOOTH);
			break;
		}

		iconFich1 = new ImageIcon(imageFicha1);
		iconFich2 = new ImageIcon(imageFicha2);

		int cx1 = (int)game.getCasillas().get(0).getpJ1().getX();
		int cy1 = (int)game.getCasillas().get(0).getpJ1().getY();
		int cx2 = (int)game.getCasillas().get(0).getpJ2().getX();
		int cy2 = (int)game.getCasillas().get(0).getpJ2().getY();

		fichaJ1 = new JLabel("");
		fichaJ1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(j1.getPosicion());
			}
		});
		fichaJ1.setBounds(cx1, cy1, 34, 50);
		fichaJ1.setIcon(iconFich1);
		panelTablero.add(fichaJ1);

		fichaJ2 = new JLabel("");
		fichaJ2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(j2.getPosicion());
			}
		});
		fichaJ2.setBounds(cx2, cy2, 34, 50);
		fichaJ2.setIcon(iconFich2);
		panelTablero.add(fichaJ2);

		contFichasTT = new TimerTask() {
			@Override
			public void run() {
				if(moviendoFicha){
					timer.cancel();
					moviendoFicha = false;
				}
			}
		};
		contFichas = new Timer();
		contFichas.schedule(contFichasTT, 0, 1000); 
	}

	/**
	 * Mueve la ficha del jugador en dependencia de su tirada
	 * @param j el jugador en turno
	 * @param tirada la tirada del jugador
	 */
	private void mover(Jugador j, int tirada){
		if(j.equals(j1)){
			if(j1.getPosicion() + tirada <= 40){
				for(int i=0; i<tirada; i++){
					int pos = j1.getPosicion();
					dormir(1);
					avanzarFicha(fichaJ1, 1, pos, pos+1);
					j1.setPosicion(pos+1);
				}
				dormir(1);
				if(j1.getPosicion() == 18){
					dormir(1);
					cruzar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(12);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 34){
					dormir(1);
					cruzar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 24){
					dormir(1);
					bajar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(2);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 38){
					dormir(1);
					bajar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(30);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 40){
					terminarJuego = true;
					mostrarCasilla(40);
				}
				else
					mostrarCasilla(j1.getPosicion());
				cambiarTurno();
			}
			else{
				for(int i=0; i<tirada; i++){
					int pos = j1.getPosicion();
					dormir(1);
					retrocederFicha(fichaJ1, 1, pos, pos-1);
					j1.setPosicion(pos-1);
				}
				dormir(1);
				if(j1.getPosicion() == 38){
					dormir(1);
					bajar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(30);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 34){
					dormir(1);
					cruzar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else
					mostrarCasilla(j1.getPosicion());
				cambiarTurno();
			}
		}
		else{
			if(j2.getPosicion() + tirada <= 40){
				for(int i=0; i<tirada; i++){
					int pos = j2.getPosicion();
					dormir(1);
					avanzarFicha(fichaJ2, 2, pos, pos+1);
					j2.setPosicion(pos+1);
				}
				dormir(1);
				if(j2.getPosicion() == 18){
					dormir(1);
					cruzar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(12);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 34){
					dormir(1);
					cruzar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 24){
					dormir(1);
					bajar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(2);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 38){
					dormir(1);
					bajar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(30);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 40){
					terminarJuego = true;
					mostrarCasilla(40);
				}
				else
					mostrarCasilla(j2.getPosicion());
				cambiarTurno();
			}
			else{
				for(int i=0; i<tirada; i++){
					int pos = j2.getPosicion();
					dormir(1);
					retrocederFicha(fichaJ2, 2, pos, pos-1);
					j2.setPosicion(pos-1);
				}
				dormir(1);
				if(j2.getPosicion() == 38){
					dormir(1);
					bajar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(30);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 34){
					dormir(1);
					cruzar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else
					mostrarCasilla(j2.getPosicion());
				cambiarTurno();
			}
		}
	}

	/**
	 * Cambia de turno
	 */
	private void cambiarTurno(){
		if(jugadorActual.equals(j1)){
			jugadorActual = j2;
			nombreJugador.setText(j2.getNick());
			nombreJugador.setForeground(j2.getColor());
		}
		else{
			jugadorActual = j1;
			nombreJugador.setText(j1.getNick());
			nombreJugador.setForeground(j1.getColor());
		}
	}

	/**
	 * Hace que una ficha avance en el tablero
	 * @param fich la ficha del jugador
	 * @param numeroJugador el numero del jugador
	 * @param inicio casilla de inicio
	 * @param destino casilla de destino
	 */
	private void avanzarFicha(JLabel fich, int numeroJugador, int inicio, final int destino){
		final JLabel ficha = fich;
		switch(numeroJugador){
		case 1:
			if((inicio >= 0 && inicio <= 8) || (inicio >= 28 && inicio <= 32)){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 9 && inicio <= 13) || (inicio >= 26 && inicio <= 27) || (inicio >= 33 && inicio <= 34)){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, --y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 14 && inicio <= 15) || (inicio >= 19 && inicio <= 25) || (inicio >= 35 && inicio <= 39)){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 16 && inicio <= 18){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			break;

		case 2:
			if((inicio >= 0 && inicio <= 8) || (inicio >= 28 && inicio <= 32)){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 9 && inicio <= 13) || (inicio >= 26 && inicio <= 27) || (inicio >= 33 && inicio <= 34)){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, --y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 14 && inicio <= 15) || (inicio >= 19 && inicio <= 25) || (inicio >= 35 && inicio <= 39)){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 16 && inicio <= 18){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			break;
		}
	}
	/**
	 * Hace que una ficha retroceda en el tablero
	 * @param fich la ficha a mover
	 * @param numeroJugador el numero del jugador
	 * @param inicio la casilla de inicio
	 * @param destino la casilla de destino
	 */
	private void retrocederFicha(JLabel fich, int numeroJugador, int inicio, final int destino){
		final JLabel ficha = fich;
		switch(numeroJugador){
		case 1:
			if(inicio >= 36 && inicio <= 39){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 34 && inicio <= 35){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 29 && inicio <= 33){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			break;
		case 2:
			if(inicio >= 36 && inicio <= 39){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 34 && inicio <= 35){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 29 && inicio <= 33){
				moviendoFicha = true;
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			break;
		}

	}
	/**
	 * Mueve la ficha a la posicion indicada
	 * @param ficha ficha a mover
	 * @param x coordenada X
	 * @param y coordenada Y
	 */
	private void moverPaso(JLabel ficha, int x, int y){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ficha.setLocation(x, y);
	}
	/**
	 * Mueve la ficha a la posicion indicada de forma mas lenta
	 *  @param ficha ficha a mover
	 * @param x coordenada X
	 * @param y coordenada Y
	 */
	private void moverPasoLento(JLabel ficha, int x, int y){
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ficha.setLocation(x, y);
	}
	/**
	 * Mueve la ficha a traves de un puente
	 * @param fich la ficha a mover
	 * @param numeroJugador el numero del juador
	 * @param pos la posicion de la casilla a la q cruzara
	 */
	private void cruzar(JLabel fich, int numeroJugador, final int pos){
		final JLabel ficha = fich;
		switch(numeroJugador){
		case 1:
			moviendoFicha = true;
			animMover = new TimerTask() {
				@Override
				public void run() {
					int salto;
					if(pos == 18)
						salto = 12;
					else
						salto = 16;
					while(!game.getCasillas().get(salto).getpJ1().equals(ficha.getLocation())){
						int x = ficha.getX();
						int y = ficha.getY();
						moverPasoLento(ficha, ++x, y);
					}
				}
			};
			timer = new Timer();
			timer.schedule(animMover,0,2*60*10000);
			break;
		case 2:
			moviendoFicha = true;
			animMover = new TimerTask() {
				@Override
				public void run() {
					int salto;
					if(pos == 18)
						salto = 12;
					else
						salto = 16;
					while(!game.getCasillas().get(salto).getpJ2().equals(ficha.getLocation())){
						int x = ficha.getX();
						int y = ficha.getY();
						moverPasoLento(ficha, ++x, y);
					}
				}
			};
			timer = new Timer();
			timer.schedule(animMover,0,2*60*10000);
			break;
		}
	}
	/**
	 * Mueve la ficha a traves de una escalera
	 * @param fich la ficha a mover
	 * @param numeroJugador el numero del juador
	 * @param pos la posicion de la casilla a la q cruzara
	 */
	private void bajar(JLabel fich, int numeroJugador, final int pos){
		final JLabel ficha = fich;
		switch(numeroJugador){
		case 1:
			moviendoFicha = true;
			animMover = new TimerTask() {
				@Override
				public void run() {
					int salto;
					if(pos == 24)
						salto = 2;
					else
						salto = 30;
					while(!game.getCasillas().get(salto).getpJ1().equals(ficha.getLocation())){
						int x = ficha.getX();
						int y = ficha.getY();
						moverPasoLento(ficha, x, ++y);
					}
				}
			};
			timer = new Timer();
			timer.schedule(animMover,0,2*60*10000);
			break;
		case 2:
			moviendoFicha = true;
			animMover = new TimerTask() {
				@Override
				public void run() {
					int salto;
					if(pos == 24)
						salto = 2;
					else
						salto = 30;
					while(!game.getCasillas().get(salto).getpJ2().equals(ficha.getLocation())){
						int x = ficha.getX();
						int y = ficha.getY();
						moverPasoLento(ficha, x, ++y);
					}
				}
			};
			timer = new Timer();
			timer.schedule(animMover,0,2*60*10000);
			break;
		}
	}
	/**
	 * duerme un periodo corto
	 * @param i
	 */
	private void dormir(int i){
		if(i != 0){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Duerme un periodo largo
	 */
	private void dormirLargo(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Llama al panel para cambiar el color del jugador
	 */
	private void llamarPanelCambiarColor(final JLabel p){
		panelColor = new JPanel();
		panelColor.setBackground(Color.white);
		panelColor.setBorder(new LineBorder(Color.gray, 2));
		panelColor.setBounds(950, p.getY(), 145, 75);

		final JLabel rojo = new JLabel("");
		rojo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(rojo.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(rojo.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(rojo.getBackground());
				}
				cerrarPanelColor();
			}
		});
		rojo.setOpaque(true);
		rojo.setBackground(Colores.C_ROJO);
		rojo.setBounds(5, 5, 30, 30);
		panelColor.add(rojo);

		final JLabel naranja = new JLabel("");
		naranja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(naranja.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(naranja.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(naranja.getBackground());
				}
				cerrarPanelColor();
			}
		});
		naranja.setOpaque(true);
		naranja.setBackground(Colores.C_NARANJA);
		naranja.setBounds(40, 5, 30, 30);
		panelColor.add(naranja);

		final JLabel amarillo = new JLabel("");
		amarillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(amarillo.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(amarillo.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(amarillo.getBackground());
				}
				cerrarPanelColor();
			}
		});
		amarillo.setOpaque(true);
		amarillo.setBackground(Colores.C_AMARILLO);
		amarillo.setBounds(75, 5, 30, 30);
		panelColor.add(amarillo);

		final JLabel verde = new JLabel("");
		verde.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(verde.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(verde.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(verde.getBackground());
				}
				cerrarPanelColor();
			}
		});
		verde.setOpaque(true);
		verde.setBackground(Colores.C_VERDE);
		verde.setBounds(110, 5, 30, 30);
		panelColor.add(verde);

		final JLabel azul = new JLabel("");
		azul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(azul.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(azul.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(azul.getBackground());
				}
				cerrarPanelColor();
			}
		});
		azul.setOpaque(true);
		azul.setBackground(Colores.C_AZUL);
		azul.setBounds(5, 40, 30, 30);
		panelColor.add(azul);

		final JLabel morado = new JLabel("");
		morado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(morado.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(morado.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(morado.getBackground());
				}
				cerrarPanelColor();
			}
		});
		morado.setOpaque(true);
		morado.setBackground(Colores.C_MORADO);
		morado.setBounds(40, 40, 30, 30);
		panelColor.add(morado);

		final JLabel rosa = new JLabel("");
		rosa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(rosa.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(rosa.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(rosa.getBackground());
				}
				cerrarPanelColor();
			}
		});
		rosa.setOpaque(true);
		rosa.setBackground(Colores.C_ROSA);
		rosa.setBounds(75, 40, 30, 30);
		panelColor.add(rosa);

		final JLabel gris = new JLabel("");
		gris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				p.setBackground(gris.getBackground());
				if(p.equals(colorJ1)){
					if(j1 != null)
						j1.setColor(gris.getBackground());
				}
				else{
					if(j2 != null)
						j2.setColor(gris.getBackground());
				}
				cerrarPanelColor();
			}
		});
		gris.setOpaque(true);
		gris.setBackground(Colores.C_GRIS);
		gris.setBounds(110, 40, 30, 30);
		panelColor.add(gris);

		panelInicio.add(panelColor);
		panelInicio.repaint();
	}
	/**
	 * Cierra el panel de cambiar el color del jugador
	 */
	private void cerrarPanelColor(){
		panelInicio.remove(panelColor);
		repaint();
		actualizarBoton();
		panelColorVisible = false;
	}
	/**
	 * Inicializa y coloca lo relacionado al dado
	 */
	private void inicializarZonaDados(){
		nombreJugador = new JLabel(j1.getNick());
		nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador.setFont(new Font("DomBold BT", Font.BOLD, 50));
		nombreJugador.setForeground(j1.getColor());
		nombreJugador.setBounds(890, 20, 230, 60);
		panelTablero.add(nombreJugador);

		lanzaDados = new JLabel("Toque el dado para lanzar");
		lanzaDados.setHorizontalAlignment(SwingConstants.CENTER);
		lanzaDados.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lanzaDados.setForeground(Color.black);
		lanzaDados.setBounds(890, 75, 230, 30);
		panelTablero.add(lanzaDados);

		ImageIcon imgDado1 = new ImageIcon(Inicio.class.getResource("/caras_dado/dado 1.png"));
		Image imageDado1 = imgDado1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		dado1 = new ImageIcon(imageDado1);

		ImageIcon imgDado2 = new ImageIcon(Inicio.class.getResource("/caras_dado/dado 2.png"));
		Image imageDado2 = imgDado2.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		dado2 = new ImageIcon(imageDado2);

		ImageIcon imgDado3 = new ImageIcon(Inicio.class.getResource("/caras_dado/dado 3.png"));
		Image imageDado3 = imgDado3.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		dado3 = new ImageIcon(imageDado3);

		ImageIcon imgDado4 = new ImageIcon(Inicio.class.getResource("/caras_dado/dado 4.png"));
		Image imageDado4 = imgDado4.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		dado4 = new ImageIcon(imageDado4);

		ImageIcon imgDado5 = new ImageIcon(Inicio.class.getResource("/caras_dado/dado 5.png"));
		Image imageDado5 = imgDado5.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		dado5 = new ImageIcon(imageDado5);

		ImageIcon imgDado6 = new ImageIcon(Inicio.class.getResource("/caras_dado/dado 6.png"));
		Image imageDado6 = imgDado6.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		dado6 = new ImageIcon(imageDado6);

		dado = new JLabel("");
		dado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isCanceled && !moviendoFicha){
					isCanceled = false;
					TimerTask animTask = new TimerTask() {
						@Override
						public void run() {
							for(int i=0; i<100; i++){
								actualizarDado(game.lanzarDado());
							}
							tirada = game.lanzarDado();
							actualizarDado(tirada);
							mover(jugadorActual, tirada);
						}
					};
					timer = new Timer();
					timer.schedule(animTask,0,2*60*10000);
				}
			}
		});
		dado.setBounds(20, 10, 80, 80);
		dado.setIcon(dado1);
		panelDados.add(dado);

		/*----------------------------*\
		|     Controlador del dado     |
		\*----------------------------*/
		contTimerTask = new TimerTask() {
			@Override
			public void run() {
				if(!isCanceled){
					timer.cancel();
					isCanceled = true;
				}
			}
		};
		controlador = new Timer();
		controlador.schedule(contTimerTask, 0, 100);

	}
	/**
	 * Actualiza visualmente el dado
	 */
	private void actualizarDado(int tirada){
		try {
			Thread.sleep(15);

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		switch(tirada){
		case 1: dado.setIcon(dado1); break;
		case 2: dado.setIcon(dado2); break;
		case 3: dado.setIcon(dado3); break;
		case 4: dado.setIcon(dado4); break;
		case 5: dado.setIcon(dado5); break;
		case 6: dado.setIcon(dado6); break;
		}
	}
	/**
	 * Coloca visualmente las casillas del tablero
	 */
	private void inicializarCasillas(){
		casilla00 = new JLabel("");
		casilla00.setBounds(game.getCasillas().get(0).getBounds());
		casilla00.setIcon(game.getCasillas().get(0).getImagenP());
		casilla00.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla00);

		casilla01 = new JLabel("");
		casilla01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(1);
			}
		});
		casilla01.setBounds(game.getCasillas().get(1).getBounds());
		casilla01.setIcon(game.getCasillas().get(1).getImagenP());
		casilla01.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla01);

		casilla02 = new JLabel("");
		casilla02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(2);
			}
		});
		casilla02.setBounds(game.getCasillas().get(2).getBounds());
		casilla02.setIcon(game.getCasillas().get(2).getImagenP());
		casilla02.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla02);

		casilla03 = new JLabel("");
		casilla03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(3);
			}
		});
		casilla03.setBounds(game.getCasillas().get(3).getBounds());
		casilla03.setIcon(game.getCasillas().get(3).getImagenP());
		casilla03.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla03);

		casilla04 = new JLabel("");
		casilla04.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(4);
			}
		});
		casilla04.setBounds(game.getCasillas().get(4).getBounds());
		casilla04.setIcon(game.getCasillas().get(4).getImagenP());
		casilla04.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla04);

		casilla05 = new JLabel("");
		casilla05.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(5);
			}
		});
		casilla05.setBounds(game.getCasillas().get(5).getBounds());
		casilla05.setIcon(game.getCasillas().get(5).getImagenP());
		casilla05.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla05);

		casilla06 = new JLabel("");
		casilla06.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(6);
			}
		});
		casilla06.setBounds(game.getCasillas().get(6).getBounds());
		casilla06.setIcon(game.getCasillas().get(6).getImagenP());
		casilla06.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla06);

		casilla07 = new JLabel("");
		casilla07.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(7);
			}
		});
		casilla07.setBounds(game.getCasillas().get(7).getBounds());
		casilla07.setIcon(game.getCasillas().get(7).getImagenP());
		casilla07.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla07);

		casilla08 = new JLabel("");
		casilla08.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(8);
			}
		});
		casilla08.setBounds(game.getCasillas().get(8).getBounds());
		casilla08.setIcon(game.getCasillas().get(8).getImagenP());
		casilla08.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla08);

		casilla09 = new JLabel("");
		casilla09.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(9);
			}
		});
		casilla09.setBounds(game.getCasillas().get(9).getBounds());
		casilla09.setIcon(game.getCasillas().get(9).getImagenP());
		casilla09.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla09);

		casilla10 = new JLabel("");
		casilla10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(10);
			}
		});
		casilla10.setBounds(game.getCasillas().get(10).getBounds());
		casilla10.setIcon(game.getCasillas().get(10).getImagenP());
		casilla10.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla10);

		casilla11 = new JLabel("");
		casilla11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(11);
			}
		});
		casilla11.setBounds(game.getCasillas().get(11).getBounds());
		casilla11.setIcon(game.getCasillas().get(11).getImagenP());
		casilla11.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla11);

		casilla12 = new JLabel("");
		casilla12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(12);
			}
		});
		casilla12.setBounds(game.getCasillas().get(12).getBounds());
		casilla12.setIcon(game.getCasillas().get(12).getImagenP());
		casilla12.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla12);

		casilla13 = new JLabel("");
		casilla13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(13);
			}
		});
		casilla13.setBounds(game.getCasillas().get(13).getBounds());
		casilla13.setIcon(game.getCasillas().get(13).getImagenP());
		casilla13.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla13);

		casilla14 = new JLabel("");
		casilla14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(14);
			}
		});
		casilla14.setBounds(game.getCasillas().get(14).getBounds());
		casilla14.setIcon(game.getCasillas().get(14).getImagenP());
		casilla14.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla14);

		casilla15 = new JLabel("");
		casilla15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(15);
			}
		});
		casilla15.setBounds(game.getCasillas().get(15).getBounds());
		casilla15.setIcon(game.getCasillas().get(15).getImagenP());
		casilla15.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla15);

		casilla16 = new JLabel("");
		casilla16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(16);
			}
		});
		casilla16.setBounds(game.getCasillas().get(16).getBounds());
		casilla16.setIcon(game.getCasillas().get(16).getImagenP());
		casilla16.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla16);

		casilla17 = new JLabel("");
		casilla17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(17);
			}
		});
		casilla17.setBounds(game.getCasillas().get(17).getBounds());
		casilla17.setIcon(game.getCasillas().get(17).getImagenP());
		casilla17.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla17);

		casilla18 = new JLabel("");
		casilla18.setBounds(game.getCasillas().get(18).getBounds());
		casilla18.setIcon(game.getCasillas().get(18).getImagenP());
		casilla18.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla18);

		casilla19 = new JLabel("");
		casilla19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(19);
			}
		});
		casilla19.setBounds(game.getCasillas().get(19).getBounds());
		casilla19.setIcon(game.getCasillas().get(19).getImagenP());
		casilla19.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla19);

		casilla20 = new JLabel("");
		casilla20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(20);
			}
		});
		casilla20.setBounds(game.getCasillas().get(20).getBounds());
		casilla20.setIcon(game.getCasillas().get(20).getImagenP());
		casilla20.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla20);

		casilla21 = new JLabel("");
		casilla21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(21);
			}
		});
		casilla21.setBounds(game.getCasillas().get(21).getBounds());
		casilla21.setIcon(game.getCasillas().get(21).getImagenP());
		casilla21.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla21);

		casilla22 = new JLabel("");
		casilla22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(22);
			}
		});
		casilla22.setBounds(game.getCasillas().get(22).getBounds());
		casilla22.setIcon(game.getCasillas().get(22).getImagenP());
		casilla22.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla22);

		casilla23 = new JLabel("");
		casilla23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(23);
			}
		});
		casilla23.setBounds(game.getCasillas().get(23).getBounds());
		casilla23.setIcon(game.getCasillas().get(23).getImagenP());
		casilla23.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla23);

		casilla24 = new JLabel("");
		casilla24.setBounds(game.getCasillas().get(24).getBounds());
		casilla24.setIcon(game.getCasillas().get(24).getImagenP());
		casilla24.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla24);

		casilla25 = new JLabel("");
		casilla25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(25);
			}
		});
		casilla25.setBounds(game.getCasillas().get(25).getBounds());
		casilla25.setIcon(game.getCasillas().get(25).getImagenP());
		casilla25.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla25);

		casilla26 = new JLabel("");
		casilla26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(26);
			}
		});
		casilla26.setBounds(game.getCasillas().get(26).getBounds());
		casilla26.setIcon(game.getCasillas().get(26).getImagenP());
		casilla26.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla26);

		casilla27 = new JLabel("");
		casilla27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(27);
			}
		});
		casilla27.setBounds(game.getCasillas().get(27).getBounds());
		casilla27.setIcon(game.getCasillas().get(27).getImagenP());
		casilla27.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla27);

		casilla28 = new JLabel("");
		casilla28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(28);
			}
		});
		casilla28.setBounds(game.getCasillas().get(28).getBounds());
		casilla28.setIcon(game.getCasillas().get(28).getImagenP());
		casilla28.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla28);

		casilla29 = new JLabel("");
		casilla29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(29);
			}
		});
		casilla29.setBounds(game.getCasillas().get(29).getBounds());
		casilla29.setIcon(game.getCasillas().get(29).getImagenP());
		casilla29.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla29);

		casilla30 = new JLabel("");
		casilla30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(30);
			}
		});
		casilla30.setBounds(game.getCasillas().get(30).getBounds());
		casilla30.setIcon(game.getCasillas().get(30).getImagenP());
		casilla30.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla30);

		casilla31 = new JLabel("");
		casilla31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(31);
			}
		});
		casilla31.setBounds(game.getCasillas().get(31).getBounds());
		casilla31.setIcon(game.getCasillas().get(31).getImagenP());
		casilla31.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla31);

		casilla32 = new JLabel("");
		casilla32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(32);
			}
		});
		casilla32.setBounds(game.getCasillas().get(32).getBounds());
		casilla32.setIcon(game.getCasillas().get(32).getImagenP());
		casilla32.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla32);

		casilla33 = new JLabel("");
		casilla33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(33);
			}
		});
		casilla33.setBounds(game.getCasillas().get(33).getBounds());
		casilla33.setIcon(game.getCasillas().get(33).getImagenP());
		casilla33.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla33);

		casilla34 = new JLabel("");
		casilla34.setBounds(game.getCasillas().get(34).getBounds());
		casilla34.setIcon(game.getCasillas().get(34).getImagenP());
		casilla34.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla34);

		casilla35 = new JLabel("");
		casilla35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(35);
			}
		});
		casilla35.setBounds(game.getCasillas().get(35).getBounds());
		casilla35.setIcon(game.getCasillas().get(35).getImagenP());
		casilla35.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla35);

		casilla36 = new JLabel("");
		casilla36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(36);
			}
		});
		casilla36.setBounds(game.getCasillas().get(36).getBounds());
		casilla36.setIcon(game.getCasillas().get(36).getImagenP());
		casilla36.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla36);

		casilla37 = new JLabel("");
		casilla37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(37);
			}
		});
		casilla37.setBounds(game.getCasillas().get(37).getBounds());
		casilla37.setIcon(game.getCasillas().get(37).getImagenP());
		casilla37.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla37);

		casilla38 = new JLabel("");
		casilla38.setBounds(game.getCasillas().get(38).getBounds());
		casilla38.setIcon(game.getCasillas().get(38).getImagenP());
		casilla38.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla38);

		casilla39 = new JLabel("");
		casilla39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(39);
			}
		});
		casilla39.setBounds(game.getCasillas().get(39).getBounds());
		casilla39.setIcon(game.getCasillas().get(39).getImagenP());
		casilla39.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla39);

		casilla40 = new JLabel("");
		casilla40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarCasilla(40);
			}
		});
		casilla40.setBounds(game.getCasillas().get(40).getBounds());
		casilla40.setIcon(game.getCasillas().get(40).getImagenP());
		casilla40.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla40);

		ImageIcon imgEscalera = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/escalera grande.png"));
		Image escaleraArr = imgEscalera.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		Icon iconEscalera = new ImageIcon(escaleraArr);

		ImageIcon imgPuente = new ImageIcon(Inicio.class.getResource("/imagenes_casillas/puente grande.png"));
		Image puenteArr = imgPuente.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		Icon iconPuente = new ImageIcon(puenteArr);

		escalera01 = new JLabel("");
		escalera01.setBounds(305, 500, 120, 90);
		escalera01.setIcon(iconEscalera);
		panelTablero.add(escalera01);

		escalera02 = new JLabel("");
		escalera02.setBounds(305, 140, 120, 90);
		escalera02.setIcon(iconEscalera);
		panelTablero.add(escalera02);

		puente01 = new JLabel("");
		puente01.setBounds(1010, 320, 120, 90);
		puente01.setIcon(iconPuente);
		panelTablero.add(puente01);

		puente02 = new JLabel("");
		puente02.setBounds(770, 140, 120, 90);
		puente02.setIcon(iconPuente);
		panelTablero.add(puente02);

	}

	/**
	 * Muestra la casilla en la que ha caido un jugador
	 * @param pos - la posicion de la casilla
	 */
	private void mostrarCasilla(int pos){
		contentPane.remove(panelTablero);
		repaint();

		panelCasilla = new JPanel();
		panelCasilla.setBackground(Color.WHITE);
		panelCasilla.setBounds(1, 27, 1278, 692);
		panelCasilla.setLayout(null);

		casillaG = new JLabel("");
		casillaG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!terminarJuego)
					llamarPanelTablero(panelCasilla);
				else{
					dispose();
					este = new Inicio();
					este.setVisible(true);
				}
			}
		});
		casillaG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!terminarJuego)
					llamarPanelTablero(panelCasilla);
				else{
					dispose();
					este = new Inicio();
					este.setVisible(true);
				}
			}
		});
		casillaG.setBounds(0, 0, 1278, 692);
		casillaG.setIcon(game.getCasillas().get(pos).getImagenG());
		panelCasilla.add(casillaG);


		contentPane.add(panelCasilla);
		repaint();
		casillaG.requestFocus();
	}

	/**
	 * Realiza la accion determinada de cada tecla
	 * @param txtID el id del JTextField donde se presiono la tecla
	 * @param key la clave de la tecla que fue presionada
	 */
	private void realizarAccion(int txtID, int key){
		switch(txtID){
		case 1:
			switch(key){
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER: txtJ2.requestFocus(); break;
			}
			break;

		case 2:
			switch(key){
			case KeyEvent.VK_UP: txtJ1.requestFocus(); break;
			case KeyEvent.VK_ENTER: 
				if(btnIniciar.isEnabled()){
					llamarPanelTablero(panelInicio);
					game = new Juego(j1, j2);
					jugadorActual = j1;
					colocarFichas();
					inicializarCasillas();
					inicializarZonaDados();
				}
				break;
			}
			break;
		}
	}

	/**
	 * Muestra el panel del tablero una vez se hayan 
	 * introducido los datos de los jugadores
	 */
	private void llamarPanelTablero(JPanel panel){
		contentPane.remove(panel);
		repaint();
		contentPane.add(panelTablero);

	}

	/**
	 * Habilita o deshabilita el boton de jugar
	 * dependiendo si son correctos los datos de los jugadores
	 */
	private void actualizarBoton(){
		boolean ok = false;
		if(j1 != null && j2 != null)
			if(!j1.getColor().equals(j2.getColor()))
				ok = true;

		if(ok)
			btnIniciar.setEnabled(true);
		else
			btnIniciar.setEnabled(false);
	}
}
