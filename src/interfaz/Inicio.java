package interfaz;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import util.Colores;
import util.EditorTexto;
import util.MyButtonModel;
import util.Validaciones;

import javax.swing.SwingConstants;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

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
	private JButton btnAyuda;
	private Icon iconSoundOn;
	private Icon iconSoundOff;
	private JButton btnSonido;
	private boolean sound = true;
	private int numPanel;
	private int xMouse;
	private int yMouse;
	/*
	 * Panel donde se introducen los nombres de los jugadores
	 */
	private JPanel panelInicio;
	private JLabel lblTitulo;
	private JLabel lblLogo;
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
	 * Panel donde se mostrara una ayuda sobre el juego
	 */
	private JScrollPane scrollPane;
	private JPanel panelAyuda;
	private JButton btnRegresar;
	private boolean mostrandoAyuda = false;
	private int numCasilla;
	/*
	 * Panel Final
	 */
	private JPanel panelFinal;
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
	private boolean sePuedeJugar = true;
	/*
	 * Sonidos del juego
	 */
	private AudioClip sonidoPaso;
	private BasicPlayer musicaFondo;
	private BasicPlayer musicaCasilla;
	private TimerTask reproduccion;
	private Timer contReproduccion;

	private boolean terminarJuego = false;
	private Juego game;
	private Jugador j1;
	private Jugador j2;
	private Jugador jugadorActual;

	private int pantallaCompleta;

	public static void main(String[] args) {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int pant = 1;
		if(pantalla.width == 1280 && pantalla.height == 720)
			pant = 0;

		Inicio frame = new Inicio(pant);
		frame.setVisible(true);
	}

	public Inicio(int pant) {
		cargarSonidos();
		pantallaCompleta = pant;
		/*-----------------------------------*\
		|     Panel General Con Sus Datos     |
		\*-----------------------------------*/
		setResizable(false);
		setTitle("Juego de Parejas");
		setIconImage(new ImageIcon(Inicio.class.getResource("/imagenes/logo.png")).getImage());
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Aviso m = null;
		if(pantallaCompleta == 0){
			iniciarAppCompleta();
		}
		else{
			m = new Aviso(this);
			m.setVisible(true);
			if(m.continuar())
				iniciarApp();
			else
				System.exit(0);
		}
		
	}
	/**
	 * Inicia la app en modo ventana
	 */
	private void iniciarApp(){
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
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

		btnAyuda = new JButton();
		btnAyuda.setBorder(null);
		btnAyuda.setFont(new Font("Arial", Font.BOLD, 15));
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setText("Ayuda");
		btnAyuda.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/ayuda.png")));
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!mostrandoAyuda && sePuedeJugar){
					mostrandoAyuda = true;
					mostrarAyuda();
					scrollPane.getVerticalScrollBar().setValue(0);
				}
			}
		});
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAyuda.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAyuda.setContentAreaFilled(false);
			}
		});
		btnAyuda.setBounds(0, 0, 80, 26);
		btnAyuda.setModel(new MyButtonModel());
		btnAyuda.setBackground(SystemColor.scrollbar);
		btnAyuda.setFocusable(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		panelSuperior.add(btnAyuda);

		ImageIcon img = new ImageIcon(Inicio.class.getResource("/imagenes/sound on.png"));
		Image image = img.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		iconSoundOn = new ImageIcon(image);
		img = new ImageIcon(Inicio.class.getResource("/imagenes/sound off.png"));
		image = img.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		iconSoundOff = new ImageIcon(image);

		btnSonido = new JButton();
		btnSonido.setBorder(null);
		btnSonido.setIcon(iconSoundOn);
		btnSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnSonido.getIcon().equals(iconSoundOn)){
					btnSonido.setIcon(iconSoundOff);
					sound = false;
					switch(numPanel){
					case 2:
						try {
							musicaFondo.pause();
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
						break;
					case 3: 
					case 4:
						try {
							musicaCasilla.stop();
							musicaCasilla = null;
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
						break;
					}
				}
				else{
					btnSonido.setIcon(iconSoundOn);
					sound = true;
					switch(numPanel){
					case 2:
						try {
							musicaFondo.resume();
							break;
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
					case 3: 
					case 4:
						try {
							reproducirMusica(numCasilla);
							break;
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSonido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSonido.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSonido.setContentAreaFilled(false);
			}
		});
		btnSonido.setBounds(80, 0, 40, 26);
		btnSonido.setModel(new MyButtonModel());
		btnSonido.setBackground(SystemColor.scrollbar);
		btnSonido.setFocusable(false);
		btnSonido.setContentAreaFilled(false);
		btnSonido.setBorderPainted(false);
		panelSuperior.add(btnSonido);

		/*---------------------------------------------------------------*\
		|     Panel Inicio para introducir los datos de los jugadores     |
		\*---------------------------------------------------------------*/
		crearPanelInicio();
		contentPane.add(panelInicio);
		numPanel = 1;

		crearPanelAyuda();
		
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
	 * Inicia la app en pantalla completa
	 */
	private void iniciarAppCompleta(){
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);


		/*--------------------------------------------------------*\
		|     Panel Superior Con Botones de cerrar y minimizar     |
		\*--------------------------------------------------------*/
		panelSuperior = new JPanel();
		panelSuperior.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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

		btnAyuda = new JButton();
		btnAyuda.setBorder(null);
		btnAyuda.setFont(new Font("Arial", Font.BOLD, 15));
		btnAyuda.setForeground(Color.BLACK);
		btnAyuda.setText("Ayuda");
		btnAyuda.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/ayuda.png")));
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!mostrandoAyuda && sePuedeJugar){
					mostrandoAyuda = true;
					mostrarAyuda();
					scrollPane.getVerticalScrollBar().setValue(0);
				}
			}
		});
		btnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAyuda.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAyuda.setContentAreaFilled(false);
			}
		});
		btnAyuda.setBounds(0, 0, 80, 26);
		btnAyuda.setModel(new MyButtonModel());
		btnAyuda.setBackground(SystemColor.scrollbar);
		btnAyuda.setFocusable(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		panelSuperior.add(btnAyuda);

		ImageIcon img = new ImageIcon(Inicio.class.getResource("/imagenes/sound on.png"));
		Image image = img.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		iconSoundOn = new ImageIcon(image);
		img = new ImageIcon(Inicio.class.getResource("/imagenes/sound off.png"));
		image = img.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		iconSoundOff = new ImageIcon(image);

		btnSonido = new JButton();
		btnSonido.setBorder(null);
		btnSonido.setIcon(iconSoundOn);
		btnSonido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnSonido.getIcon().equals(iconSoundOn)){
					btnSonido.setIcon(iconSoundOff);
					sound = false;
					switch(numPanel){
					case 2:
						try {
							musicaFondo.pause();
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
						break;
					case 3: 
					case 4:
						try {
							musicaCasilla.stop();
							musicaCasilla = null;
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
						break;
					}
				}
				else{
					btnSonido.setIcon(iconSoundOn);
					sound = true;
					switch(numPanel){
					case 2:
						try {
							musicaFondo.resume();
							break;
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
					case 3: 
					case 4:
						try {
							reproducirMusica(numCasilla);
							break;
						} catch (BasicPlayerException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSonido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSonido.setContentAreaFilled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSonido.setContentAreaFilled(false);
			}
		});
		btnSonido.setBounds(80, 0, 40, 26);
		btnSonido.setModel(new MyButtonModel());
		btnSonido.setBackground(SystemColor.scrollbar);
		btnSonido.setFocusable(false);
		btnSonido.setContentAreaFilled(false);
		btnSonido.setBorderPainted(false);
		panelSuperior.add(btnSonido);

		/*---------------------------------------------------------------*\
		|     Panel Inicio para introducir los datos de los jugadores     |
		\*---------------------------------------------------------------*/
		crearPanelInicio();
		contentPane.add(panelInicio);
		numPanel = 1;

		crearPanelAyuda();
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
	 * Coloca visualmente las fichas
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
		contFichas.schedule(contFichasTT, 0, 100); 
	}

	/**
	 * Mueve la ficha del jugador en dependencia de su tirada
	 * @param j el jugador en turno
	 * @param tirada la tirada del jugador
	 * @throws BasicPlayerException 
	 */
	private void mover(Jugador j, int tirada) throws BasicPlayerException {
		if(j.equals(j1)){
			if(j1.getPosicion() + tirada <= 40){
				sePuedeJugar = false;
				for(int i=0; i<tirada; i++){
					int pos = j1.getPosicion();
					dormir();
					avanzarFicha(fichaJ1, 1, pos, pos+1);
					j1.setPosicion(pos+1);
					dormirCorto();
				}
				dormir();
				if(j1.getPosicion() == 18){
					dormir();
					cruzar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(12);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 34){
					dormir();
					cruzar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 24){
					dormir();
					bajar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(2);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 38){
					dormir();
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

				reproducirMusica(j1.getPosicion());
				cambiarTurno();
				sePuedeJugar = true;
			}
			else{
				for(int i=0; i<tirada; i++){
					sePuedeJugar = false;
					int pos = j1.getPosicion();
					dormir();
					retrocederFicha(fichaJ1, 1, pos, pos-1);
					j1.setPosicion(pos-1);
					dormirCorto();
				}
				dormir();
				if(j1.getPosicion() == 38){
					dormir();
					bajar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(30);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else if(j1.getPosicion() == 34){
					dormir();
					cruzar(fichaJ1, 1, j1.getPosicion());
					j1.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j1.getPosicion());
				}
				else
					mostrarCasilla(j1.getPosicion());

				reproducirMusica(j1.getPosicion());
				sePuedeJugar = true;
				cambiarTurno();
			}
		}
		else{
			if(j2.getPosicion() + tirada <= 40){
				sePuedeJugar = false;
				for(int i=0; i<tirada; i++){
					int pos = j2.getPosicion();
					dormir();
					avanzarFicha(fichaJ2, 2, pos, pos+1);
					j2.setPosicion(pos+1);
					dormirCorto();
				}
				dormir();
				if(j2.getPosicion() == 18){
					dormir();
					cruzar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(12);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 34){
					dormir();
					cruzar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 24){
					dormir();
					bajar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(2);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 38){
					dormir();
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

				reproducirMusica(j2.getPosicion());
				cambiarTurno();
				sePuedeJugar = true;
			}
			else{
				sePuedeJugar = false;
				for(int i=0; i<tirada; i++){
					int pos = j2.getPosicion();
					dormir();
					retrocederFicha(fichaJ2, 2, pos, pos-1);
					j2.setPosicion(pos-1);
					dormirCorto();
				}
				dormir();
				if(j2.getPosicion() == 38){
					dormir();
					bajar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(30);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else if(j2.getPosicion() == 34){
					dormir();
					cruzar(fichaJ2, 2, j2.getPosicion());
					j2.setPosicion(16);
					dormirLargo();
					mostrarCasilla(j2.getPosicion());
				}
				else
					mostrarCasilla(j2.getPosicion());

				reproducirMusica(j2.getPosicion());
				cambiarTurno();
				sePuedeJugar = true;
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
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 9 && inicio <= 13) || (inicio >= 26 && inicio <= 27) || (inicio >= 33 && inicio <= 34)){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, --y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 14 && inicio <= 15) || (inicio >= 19 && inicio <= 25) || (inicio >= 35 && inicio <= 39)){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 16 && inicio <= 18){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			break;

		case 2:
			if((inicio >= 0 && inicio <= 8) || (inicio >= 28 && inicio <= 32)){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 9 && inicio <= 13) || (inicio >= 26 && inicio <= 27) || (inicio >= 33 && inicio <= 34)){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, --y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if((inicio >= 14 && inicio <= 15) || (inicio >= 19 && inicio <= 25) || (inicio >= 35 && inicio <= 39)){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 16 && inicio <= 18){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
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
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 34 && inicio <= 35){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 29 && inicio <= 33){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ1().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			break;
		case 2:
			if(inicio >= 36 && inicio <= 39){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, ++x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 34 && inicio <= 35){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, x, ++y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
					}
				};
				timer = new Timer();
				timer.schedule(animMover,0,2*60*10000);
			}
			else if(inicio >= 29 && inicio <= 33){
				animMover = new TimerTask() {
					@Override
					public void run() {
						while(!game.getCasillas().get(destino).getpJ2().equals(ficha.getLocation())){
							int x = ficha.getX();
							int y = ficha.getY();
							moverPaso(ficha, --x, y);
						}
						if(sound)
							sonidoPaso.play();
						moviendoFicha = true;
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
					moviendoFicha = true;
				}
			};
			timer = new Timer();
			timer.schedule(animMover,0,2*60*10000);
			break;
		case 2:
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
					moviendoFicha = true;
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
					moviendoFicha = true;
				}
			};
			timer = new Timer();
			timer.schedule(animMover,0,2*60*10000);
			break;
		case 2:
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
					moviendoFicha = true;
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
	private void dormir(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Duerme un periodo corto
	 */
	private void dormirCorto(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
				if(isCanceled && sePuedeJugar){
					sePuedeJugar = false;
					TimerTask animTask = new TimerTask() {
						@Override
						public void run() {
							for(int i=0; i<100; i++){
								actualizarDado(game.lanzarDado());
							}
							tirada = game.lanzarDado();
							actualizarDado(tirada);
							try {
								mover(jugadorActual, tirada);
							} catch (BasicPlayerException e) {
								e.printStackTrace();
							}
							isCanceled = false;
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
					sePuedeJugar = true;
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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
				if(sePuedeJugar)
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

		adornarTablero();
	}

	/**
	 * Coloca los demas adornos del tablero
	 */
	private void adornarTablero(){
		ImageIcon img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji fuego 96.png"));
		Image image = img.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		Icon iconFuego = new ImageIcon(image);

		JLabel lblFuego1 = new JLabel();
		lblFuego1.setBounds(570, 150, 70, 70);
		lblFuego1.setIcon(iconFuego);
		panelTablero.add(lblFuego1);

		JLabel lblFuego2 = new JLabel();
		lblFuego2.setBounds(770, 510, 70, 70);
		lblFuego2.setIcon(iconFuego);
		panelTablero.add(lblFuego2);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/c3.png"));
		image = img.getImage().getScaledInstance(27, 55, Image.SCALE_SMOOTH);
		Icon iconCoraLarg1 = new ImageIcon(image);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/c3.png"));
		image = img.getImage().getScaledInstance(34, 70, Image.SCALE_SMOOTH);
		Icon iconCoraLarg2 = new ImageIcon(image);

		JLabel lblCoraLarg1 = new JLabel();
		lblCoraLarg1.setBounds(520, 145, 27, 55);
		lblCoraLarg1.setIcon(iconCoraLarg1);
		panelTablero.add(lblCoraLarg1);

		JLabel lblCoraLarg2 = new JLabel();
		lblCoraLarg2.setBounds(174, 325, 34, 70);
		lblCoraLarg2.setIcon(iconCoraLarg2);
		panelTablero.add(lblCoraLarg2);

		JLabel lblCoraLarg3 = new JLabel();
		lblCoraLarg3.setBounds(1088, 490, 34, 70);
		lblCoraLarg3.setIcon(iconCoraLarg2);
		panelTablero.add(lblCoraLarg3);

		JLabel lblCoraLarg4 = new JLabel();
		lblCoraLarg4.setBounds(1013, 233, 27, 55);
		lblCoraLarg4.setIcon(iconCoraLarg1);
		panelTablero.add(lblCoraLarg4);

		JLabel lblCoraLarg5 = new JLabel();
		lblCoraLarg5.setBounds(270, 509, 34, 70);
		lblCoraLarg5.setIcon(iconCoraLarg2);
		panelTablero.add(lblCoraLarg5);

		JLabel lblCoraLarg6 = new JLabel();
		lblCoraLarg6.setBounds(270, 145, 34, 70);
		lblCoraLarg6.setIcon(iconCoraLarg2);
		panelTablero.add(lblCoraLarg6);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji coqueto girado 15 izq.png"));
		image = img.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		Icon iconEmojiCoquetoGirado1 = new ImageIcon(image);

		JLabel lblEmojiCoquetoGirado1 = new JLabel();
		lblEmojiCoquetoGirado1.setBounds(1052, 260, 70, 70);
		lblEmojiCoquetoGirado1.setIcon(iconEmojiCoquetoGirado1);
		panelTablero.add(lblEmojiCoquetoGirado1);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/corazon rosa.png"));
		image = img.getImage().getScaledInstance(80, 63, Image.SCALE_SMOOTH);
		Icon iconCoraRosa1 = new ImageIcon(image);

		JLabel lblCoraRosa1 = new JLabel();
		lblCoraRosa1.setBounds(1015, 428, 80, 63);
		lblCoraRosa1.setIcon(iconCoraRosa1);
		panelTablero.add(lblCoraRosa1);

		JLabel lblCoraRosa2 = new JLabel();
		lblCoraRosa2.setBounds(770, 62, 80, 63);
		lblCoraRosa2.setIcon(iconCoraRosa1);
		panelTablero.add(lblCoraRosa2);

		JLabel lblCoraRosa3 = new JLabel();
		lblCoraRosa3.setBounds(667, 335, 80, 63);
		lblCoraRosa3.setIcon(iconCoraRosa1);
		panelTablero.add(lblCoraRosa3);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji enamorado babeado gir der.png"));
		image = img.getImage().getScaledInstance(60, 65, Image.SCALE_SMOOTH);
		Icon iconEmojiEnamBabeado1 = new ImageIcon(image);

		JLabel lblEmojiEnamBabeado1 = new JLabel();
		lblEmojiEnamBabeado1.setBounds(1005, 512, 60, 65);
		lblEmojiEnamBabeado1.setIcon(iconEmojiEnamBabeado1);
		panelTablero.add(lblEmojiEnamBabeado1);

		JLabel lblEmojiEnamBabeado2 = new JLabel();
		lblEmojiEnamBabeado2.setBounds(448, 160, 60, 65);
		lblEmojiEnamBabeado2.setIcon(iconEmojiEnamBabeado1);
		panelTablero.add(lblEmojiEnamBabeado2);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/c2.png"));
		image = img.getImage().getScaledInstance(100, 64, Image.SCALE_SMOOTH);
		Icon iconC2_1 = new ImageIcon(image);

		JLabel lblC2_1 = new JLabel();
		lblC2_1.setBounds(870, 515, 100, 64);
		lblC2_1.setIcon(iconC2_1);
		panelTablero.add(lblC2_1);

		JLabel lblC2_2 = new JLabel();
		lblC2_2.setBounds(550, 330, 100, 64);
		lblC2_2.setIcon(iconC2_1);
		panelTablero.add(lblC2_2);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji diablo gir izq.png"));
		image = img.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		Icon iconEmojiDiablo1 = new ImageIcon(image);

		JLabel lblEmojiDiablo1 = new JLabel();
		lblEmojiDiablo1.setBounds(792, 232, 80, 80);
		lblEmojiDiablo1.setIcon(iconEmojiDiablo1);
		panelTablero.add(lblEmojiDiablo1);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/labio corazon gir izq.png"));
		image = img.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Icon iconLabioCora1 = new ImageIcon(image);

		JLabel lblLabioCora1 = new JLabel();
		lblLabioCora1.setBounds(395, 148, 40, 40);
		lblLabioCora1.setIcon(iconLabioCora1);
		panelTablero.add(lblLabioCora1);

		JLabel lblLabioCora2 = new JLabel();
		lblLabioCora2.setBounds(717, 515, 40, 40);
		lblLabioCora2.setIcon(iconLabioCora1);
		panelTablero.add(lblLabioCora2);

		JLabel lblLabioCora3 = new JLabel();
		lblLabioCora3.setBounds(835, 110, 40, 40);
		lblLabioCora3.setIcon(iconLabioCora1);
		panelTablero.add(lblLabioCora3);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/c4.png"));
		image = img.getImage().getScaledInstance(74, 70, Image.SCALE_SMOOTH);
		Icon iconC4_1 = new ImageIcon(image);

		JLabel lblC4_1 = new JLabel();
		lblC4_1.setBounds(620, 510, 74, 70);
		lblC4_1.setIcon(iconC4_1);
		panelTablero.add(lblC4_1);

		JLabel lblC4_2 = new JLabel();
		lblC4_2.setBounds(230, 330, 74, 70);
		lblC4_2.setIcon(iconC4_1);
		panelTablero.add(lblC4_2);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/morder labio 512.png"));
		image = img.getImage().getScaledInstance(96, 60, Image.SCALE_SMOOTH);
		Icon iconMorderLabio = new ImageIcon(image);

		JLabel lblMorderLabio1 = new JLabel();
		lblMorderLabio1.setBounds(755, 340, 96, 60);
		lblMorderLabio1.setIcon(iconMorderLabio);
		panelTablero.add(lblMorderLabio1);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/labios 96.png"));
		image = img.getImage().getScaledInstance(94, 60, Image.SCALE_SMOOTH);
		Icon iconLabio = new ImageIcon(image);

		JLabel lblLabios1 = new JLabel();
		lblLabios1.setBounds(430, 335, 94, 60);
		lblLabios1.setIcon(iconLabio);
		panelTablero.add(lblLabios1);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji gafas 96.png"));
		image = img.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		Icon iconEmojiGafas = new ImageIcon(image);

		JLabel lblEmojiGafas1 = new JLabel();
		lblEmojiGafas1.setBounds(190, 512, 65, 65);
		lblEmojiGafas1.setIcon(iconEmojiGafas);
		panelTablero.add(lblEmojiGafas1);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/saborear labio 512.png"));
		image = img.getImage().getScaledInstance(80, 70, Image.SCALE_SMOOTH);
		Icon iconSaborear = new ImageIcon(image);

		JLabel lblSaborear = new JLabel();
		lblSaborear.setBounds(410, 512, 80, 70);
		lblSaborear.setIcon(iconSaborear);
		panelTablero.add(lblSaborear);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji beso gir der.png"));
		image = img.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		Icon iconBeso = new ImageIcon(image);

		JLabel lblBeso1 = new JLabel();
		lblBeso1.setBounds(518, 510, 70, 70);
		lblBeso1.setIcon(iconBeso);
		panelTablero.add(lblBeso1);

		JLabel lblBeso2 = new JLabel();
		lblBeso2.setBounds(190, 150, 70, 70);
		lblBeso2.setIcon(iconBeso);
		panelTablero.add(lblBeso2);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/emoji abrazo gir izq.png"));
		image = img.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		Icon iconEmojiAbrazo = new ImageIcon(image);

		JLabel lblEmojiAbrazo = new JLabel();
		lblEmojiAbrazo.setBounds(335, 330, 70, 70);
		lblEmojiAbrazo.setIcon(iconEmojiAbrazo);
		panelTablero.add(lblEmojiAbrazo);

	}


	/**
	 * Muestra la casilla en la que ha caido un jugador
	 * @param pos - la posicion de la casilla
	 */
	private void mostrarCasilla(int pos){
		numCasilla = pos;
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
				if(!terminarJuego){
					if(sound){
						if(musicaCasilla != null){
							try {
								musicaCasilla.pause();
								musicaCasilla = null;
								musicaFondo.resume();
							} catch (BasicPlayerException e2) {
								e2.printStackTrace();
							}
						}
					}
					llamarPanelTablero(panelCasilla);
				}
				else{
					ponerPanelFinal();
				}
			}
		});
		casillaG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!terminarJuego){
					if(sound){
						if(musicaCasilla != null){
							try {
								musicaCasilla.pause();
								musicaCasilla = null;
								musicaFondo.resume();
							} catch (BasicPlayerException e2) {
								e2.printStackTrace();
							}
						}
					}
					llamarPanelTablero(panelCasilla);
				}
				else{
					ponerPanelFinal();
				}
			}
		});
		casillaG.setBounds(0, 0, 1278, 692);
		casillaG.setIcon(game.getCasillas().get(pos).getImagenG());
		panelCasilla.add(casillaG);

		numPanel = 3;
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
					contentPane.remove(scrollPane);
					llamarPanelTablero(panelInicio);
					game = new Juego(j1, j2);
					jugadorActual = j1;
					colocarFichas();
					inicializarCasillas();
					inicializarZonaDados();
					try {
						if(sound)
							musicaFondo.play();
					} catch (BasicPlayerException e1) {
						e1.printStackTrace();
					}
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
		numPanel = 2;
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

	/**
	 * Crea el panel de inicio
	 */
	private void crearPanelInicio(){
		panelInicio = new JPanel();
		panelInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(panelColorVisible)
					cerrarPanelColor();
			}
		});
		panelInicio.setBackground(Color.white);
		panelInicio.setBounds(1, 27, 1278, 692);
		panelInicio.setLayout(null);

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
		lblTitulo.setBounds(270, 40, 1000, 100);
		panelInicio.add(lblTitulo);

		ImageIcon img = new ImageIcon(Inicio.class.getResource("/imagenes/logo inicio.png"));
		Image image = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		Icon iconLogo = new ImageIcon(image);

		lblLogo = new JLabel();
		lblLogo.setIcon(iconLogo);
		lblLogo.setBounds(60, 0, 200, 200);
		panelInicio.add(lblLogo);

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
				contentPane.remove(scrollPane);
				llamarPanelTablero(panelInicio);
				game = new Juego(j1, j2);
				jugadorActual = j1;
				colocarFichas();
				inicializarCasillas();
				inicializarZonaDados();
				try {
					if(sound)
						musicaFondo.play();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
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
	}

	/**
	 * Muestra el panel de ayuda
	 */
	private void mostrarAyuda(){
		switch(numPanel){
		case 1:
			contentPane.remove(panelInicio);
			repaint();
			contentPane.add(scrollPane);
			break;
		case 2:
			contentPane.remove(panelTablero);
			repaint();
			contentPane.add(scrollPane);
			break;
		case 3:
			contentPane.remove(panelCasilla);
			repaint();
			contentPane.add(scrollPane);
			break;
		case 4:
			contentPane.remove(panelFinal);
			repaint();
			contentPane.add(scrollPane);
			break;
		}
	}

	/**
	 * Crea el panel que muestra la ayuda sobre el juego
	 */
	private void crearPanelAyuda(){
		panelAyuda = new JPanel();
		panelAyuda.setBackground(Color.WHITE);
		panelAyuda.setPreferredSize(new Dimension(1260, 4770));
		panelAyuda.setLayout(null);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setUI(new BasicScrollBarUI(){
			@Override
			protected void configureScrollBarColors() {
				LookAndFeel.installColors(scrollbar, "ScrollBar.background",
						"ScrollBar.foreground");
				thumbHighlightColor = new Color(100, 0, 0);
				thumbLightShadowColor = new Color(100, 0, 0);
				thumbDarkShadowColor = new Color(100, 0, 0);
				thumbColor = Color.red;
				trackColor = UIManager.getColor("ScrollBar.track");
				trackHighlightColor = new Color(100, 0, 0);
			}
			@Override
			protected JButton createDecreaseButton(int orientation) {
				return new BasicArrowButton(orientation,
						Color.red,
						new Color(100, 0, 0),
						new Color(100, 0, 0),
						new Color(100, 0, 0));
			}
			@Override
			protected JButton createIncreaseButton(int orientation) {
				return new BasicArrowButton(orientation,
						Color.red,
						new Color(100, 0, 0),
						new Color(100, 0, 0),
						new Color(100, 0, 0));
			}
		});
		scrollBar.setFocusable(false);
		scrollBar.setUnitIncrement(50);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.white);
		scrollPane.setBounds(1, 27, 1278, 692);
		scrollPane.setBorder(null);
		scrollPane.setVerticalScrollBar(scrollBar);
		scrollPane.setViewportView(panelAyuda);

		lblTitulo = new JLabel();
		lblTitulo.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/titulo.png")));
		lblTitulo.setBounds(270, 40, 1000, 100);
		panelAyuda.add(lblTitulo);

		ImageIcon img = new ImageIcon(Inicio.class.getResource("/imagenes/logo inicio.png"));
		Image image = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		Icon iconLogo = new ImageIcon(image);

		lblLogo = new JLabel();
		lblLogo.setIcon(iconLogo);
		lblLogo.setBounds(60, 0, 200, 200);
		panelAyuda.add(lblLogo);

		JLabel lblCreador = new JLabel("Creador");
		lblCreador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreador.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblCreador.setForeground(Color.BLACK);
		lblCreador.setBounds(140, 195, 1000, 40);
		panelAyuda.add(lblCreador);

		JLabel lblNombre = new JLabel("Yankiel Yong Martínez");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Arial", Font.ITALIC, 28));
		lblNombre.setForeground(Color.black);
		lblNombre.setBounds(140, 240, 1000, 40);
		panelAyuda.add(lblNombre);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/instagram 512.png"));
		image = img.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Icon iconInsta = new ImageIcon(image);

		JLabel lblInsta = new JLabel("@el_yanko_");
		lblInsta.setIcon(iconInsta);
		lblInsta.setFont(new Font("Arial", Font.ITALIC, 24));
		lblInsta.setForeground(Color.black);
		lblInsta.setBounds(552, 280, 200, 50);
		panelAyuda.add(lblInsta);

		img = new ImageIcon(Inicio.class.getResource("/imagenes/twitter1.png"));
		image = img.getImage().getScaledInstance(39, 39, Image.SCALE_SMOOTH);
		Icon iconTw = new ImageIcon(image);

		JLabel lblTw = new JLabel("@__yanko_");
		lblTw.setIcon(iconTw);
		lblTw.setFont(new Font("Arial", Font.ITALIC, 24));
		lblTw.setForeground(Color.black);
		lblTw.setBounds(553, 330, 200, 50);
		panelAyuda.add(lblTw);

		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicio.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblInicio.setForeground(Color.BLACK);
		lblInicio.setBounds(140, 400, 1000, 40);
		panelAyuda.add(lblInicio);

		SimpleAttributeSet attrs = new SimpleAttributeSet();

		JTextPane txt1 = new JTextPane();
		txt1.setBackground(Color.WHITE);
		txt1.setEditable(false);
		txt1.setFocusable(false);
		txt1.setForeground(Color.BLACK);
		txt1.setFont(new Font("Arial", Font.PLAIN, 22));
		txt1.setBounds(140, 440, 1000, 200);
		panelAyuda.add(txt1);

		EditorTexto.textoNormal(attrs, txt1, "Para comenzar a jugar, ambos jugadores deben introducir sus respectivos "
				+ "nombres y seleccionar");
		EditorTexto.nuevaLinea(attrs, txt1);
		EditorTexto.textoNormal(attrs, txt1, "el color que deseen para su ficha.");
		EditorTexto.nuevaLinea(attrs, txt1);
		EditorTexto.nuevaLinea(attrs, txt1);
		EditorTexto.textoNormal(attrs, txt1, "NOTAS:");
		EditorTexto.nuevaLinea(attrs, txt1);
		EditorTexto.textoNormal(attrs, txt1, "- Los jugadores deben elegir colores diferentes.");
		EditorTexto.nuevaLinea(attrs, txt1);
		EditorTexto.textoNormal(attrs, txt1, "- El ");
		EditorTexto.textoNegrita(attrs, txt1, "Jugador 1 ");
		EditorTexto.textoNormal(attrs, txt1, "será el que empiece jugando.");
		EditorTexto.nuevaLinea(attrs, txt1);

		JLabel lblComoJugar = new JLabel("¿Cómo se juega?");
		lblComoJugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblComoJugar.setForeground(Color.BLACK);
		lblComoJugar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblComoJugar.setBounds(140, 680, 1000, 40);
		panelAyuda.add(lblComoJugar);

		JTextPane txt2 = new JTextPane();
		txt2.setForeground(Color.BLACK);
		txt2.setFont(new Font("Arial", Font.PLAIN, 22));
		txt2.setFocusable(false);
		txt2.setEditable(false);
		txt2.setBackground(Color.WHITE);
		txt2.setBounds(140, 730, 1000, 100);
		panelAyuda.add(txt2);

		EditorTexto.textoNormal(attrs, txt2, "El jugador debe hacer click sobre el dado para lanzarlo, una vez lanzado, su ficha "
				+ "se moverá tantas");
		EditorTexto.nuevaLinea(attrs, txt2);
		EditorTexto.textoNormal(attrs, txt2, "veces como indique el dado. Cuando su ficha haya terminado de moverse y ya se "
				+ "encuentre ubicada");
		EditorTexto.nuevaLinea(attrs, txt2);
		EditorTexto.textoNormal(attrs, txt2, "en la casilla correspondiente, el jugador deberá cumplir con el reto asignado.");
		EditorTexto.nuevaLinea(attrs, txt2);

		JLabel lblReglas = new JLabel("Reglas");
		lblReglas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReglas.setForeground(Color.BLACK);
		lblReglas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblReglas.setBounds(140, 870, 1000, 40);
		panelAyuda.add(lblReglas);

		JTextPane txt3 = new JTextPane();
		txt3.setForeground(Color.BLACK);
		txt3.setFont(new Font("Arial", Font.PLAIN, 22));
		txt3.setFocusable(false);
		txt3.setEditable(false);
		txt3.setBackground(Color.WHITE);
		txt3.setBounds(140, 920, 1000, 250);
		panelAyuda.add(txt3);

		EditorTexto.textoNormal(attrs, txt3, "- Ambos jugadores deben estar de acuerdo en jugar.");
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.textoNormal(attrs, txt3, "- Cuando lance el dado su ficha avanzará si el valor del dado es "
				+ "inferior a la cantidad de casillas que lo");
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.textoNormal(attrs, txt3, "separan de la meta.");
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.textoNormal(attrs, txt3, "- Cuando lance el dado su ficha retrocederá si el valor del dado es "
				+ "superior a la cantidad de casillas");
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.textoNormal(attrs, txt3, "que lo separan de la meta.");
		EditorTexto.nuevaLinea(attrs, txt3);
		EditorTexto.nuevaLinea(attrs, txt3);

		JLabel lblCasillas = new JLabel("Casillas");
		lblCasillas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasillas.setForeground(Color.BLACK);
		lblCasillas.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblCasillas.setBounds(140, 1180, 1000, 40);
		panelAyuda.add(lblCasillas);

		JTextPane txt4 = new JTextPane();
		txt4.setForeground(Color.BLACK);
		txt4.setFont(new Font("Arial", Font.PLAIN, 22));
		txt4.setFocusable(false);
		txt4.setEditable(false);
		txt4.setBackground(Color.WHITE);
		txt4.setBounds(140, 1240, 1000, 2700);
		panelAyuda.add(txt4);

		EditorTexto.textoNegrita(attrs, txt4, "Casilla 01:");
		EditorTexto.textoNormal(attrs, txt4, " Confiesa cuál es la parte del cuerpo de tu pareja que más te gusta.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 02:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que quitarte una prenda, la que tú quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 03:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que hacerle un masaje durante 30 segundo a tu pareja donde "
				+ "el/ella decida.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 04:");
		EditorTexto.textoNormal(attrs, txt4, " Tienen que besarse durante al menos 30 segundos pero no puede "
				+ "existir ningún otro ");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNormal(attrs, txt4, "contacto que no sea el de los labios.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 05:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que quitarle una prenda a tu pareja, la que tú quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 06:");
		EditorTexto.textoNormal(attrs, txt4, " Dale una nalgada a tu pareja.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 07:");
		EditorTexto.textoNormal(attrs, txt4, " Susúrrale algo hot a tu pareja.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 08:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que mostrarle la ropa interior que llevas puesta a tu pareja.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 09:");
		EditorTexto.textoNormal(attrs, txt4, " Confiesa alguna fantasía sexual.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 10:");
		EditorTexto.textoNormal(attrs, txt4, " Puedes tocar cualquier parte del cuerpo de tu pareja, tú eliges.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 11:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que quedarte en ropa interior para hacer 20 cuclillas, "
				+ "una vez terminada te vuelves");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNormal(attrs, txt4, "a vestir con la misma ropa que llevabas antes de este reto.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 12:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que quitarte una prenda, la que tú quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 13:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que hacerle un baile sexy a tu pareja durante 30 segundos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 14:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que besar a tu pareja donde el/ella te pida.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 15:");
		EditorTexto.textoNormal(attrs, txt4, " Tápale los ojos a tu pareja y puedes hacerle lo que quieras durante "
				+ "30 segundos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 16:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que lamer cualquier parte del cuerpo de tu pareja, la que tú "
				+ "quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 17:");
		EditorTexto.textoNormal(attrs, txt4, " Tu pareja tiene que hacerte un masaje de 30 segundos donde tú quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 18:");
		EditorTexto.textoNormal(attrs, txt4, " Tu ficha se moverá a través del puente.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 19:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que besar a tu pareja por todo su cuerpo.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 20:");
		EditorTexto.textoNormal(attrs, txt4, " Tu pareja tiene que hacerte un baile sexy durante 30 segundos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 21:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que besar y acariciar a tu pareja dulcemente.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 22:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que quitarle una prenda a tu pareja con la boca, la que tu "
				+ "quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 23:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que taparte los ojos y tu pareja podrá hacerte lo que quiera "
				+ "durante 30 segundos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 24:");
		EditorTexto.textoNormal(attrs, txt4, " Tu ficha se moverá a través de la escalera.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 25:");
		EditorTexto.textoNormal(attrs, txt4, " Descríbele a tu pareja una posición que te gustaría hacer con el/ella"
				+ "ahora mismo.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 26:");
		EditorTexto.textoNormal(attrs, txt4, " Tu pareja tiene que lamer tus pechos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 27:");
		EditorTexto.textoNormal(attrs, txt4, " Confiesa qué es lo que más te prende.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 28:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que morder la parte del cuerpo que más te guste de tu pareja.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 29:");
		EditorTexto.textoNormal(attrs, txt4, " Tienen que darse un beso con lengua durante al menos 30 segundos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 30:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que lamer una parte del cuerpo de tu pareja, la que el/ella "
				+ "quiera.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 31:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que quedarte en ropa interior.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 32:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que besar el cuello de tu pareja durante al menos 15 segundos.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 33:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que atar a tu pareja y puedes hacerle lo que quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 34:");
		EditorTexto.textoNormal(attrs, txt4, " Tu ficha se moverá a través del puente.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 35:");
		EditorTexto.textoNormal(attrs, txt4, " Toma la mano de tu pareja y demuéstrale cómo te gusta que te toque.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 36:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que meter tu mano por debajo de la ropa de tu pareja, donde "
				+ "tú quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 37:");
		EditorTexto.textoNormal(attrs, txt4, " Tienes que besar cualquier parte del cuerpo de tu pareja, la que "
				+ "tú quieras.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 38:");
		EditorTexto.textoNormal(attrs, txt4, " Tu ficha se moverá a través de la escalera.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 39:");
		EditorTexto.textoNormal(attrs, txt4, " Puedes escoger cualquier reto de las casillas anteriores y hacerlo.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.textoNegrita(attrs, txt4, "Casilla 40:");
		EditorTexto.textoNormal(attrs, txt4, " Puedes escoger cualquier premio y tu pareja tiene que ayudar a "
				+ "cumplirlo si fuese necesario.");
		EditorTexto.nuevaLinea(attrs, txt4);
		EditorTexto.nuevaLinea(attrs, txt4);

		JLabel lblMusica = new JLabel("Música");
		lblMusica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusica.setForeground(Color.BLACK);
		lblMusica.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		lblMusica.setBounds(140, 4000, 1000, 40);
		panelAyuda.add(lblMusica);

		JTextPane txt5 = new JTextPane();
		StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_CENTER);
		txt5.setParagraphAttributes(attrs, true);
		txt5.setForeground(Color.BLACK);
		txt5.setFont(new Font("Arial", Font.PLAIN, 22));
		txt5.setFocusable(false);
		txt5.setEditable(false);
		txt5.setBackground(Color.WHITE);
		txt5.setBounds(140, 4060, 1000, 570);
		panelAyuda.add(txt5);

		EditorTexto.textoCursiva(attrs, txt5, "Artic Monkeys - I Wanna Be Yours");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "B Miles - Salt");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Bishop Briggs - River");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Charlie Puth - Suffer");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Elvis Drew - Make Me Feel");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Hot Chocolate - You Sexy Thing");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Joe Cocker - You Can Leave Your Hat On");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Kali Uchis - Telepatía");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Marvin Gaye - Let's Get It On");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Marvin Gaye - Sexual Healing");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Rosenfeld - Do It For Me");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "The Weeknd - Call Out My Name");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "The Weeknd - Earned It");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Two Feet - Go Fuck Yourself");
		EditorTexto.nuevaLinea(attrs, txt5);
		EditorTexto.textoCursiva(attrs, txt5, "Two Feet - Love Is A Bitch");
		EditorTexto.nuevaLinea(attrs, txt5);

		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegresar.setBackground(Color.white);
				contentPane.remove(scrollPane);
				mostrandoAyuda = false;
				repaint();
				switch(numPanel){
				case 1:
					contentPane.add(panelInicio);
					break;
				case 2:
					contentPane.add(panelTablero);
					break;
				case 3:
					mostrarCasilla(numCasilla);
					break;
				case 4:
					ponerPanelFinal();
					break;
				}
			}
		});
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegresar.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegresar.setBackground(Color.white);
			}
		});
		btnRegresar.setModel(new MyButtonModel());
		btnRegresar.setForeground(Color.BLACK);
		btnRegresar.setBorder(new LineBorder(new Color(150, 0, 0), 4));
		btnRegresar.setFont(new Font("Arial", Font.BOLD, 30));
		btnRegresar.setBackground(Color.white);
		btnRegresar.setBounds(500, 4670, 280, 50);
		btnRegresar.setFocusable(false);
		panelAyuda.add(btnRegresar);
		
		contentPane.add(scrollPane);
	}

	/**
	 * Carga los sonidos del juego
	 */
	private void cargarSonidos(){
		sonidoPaso = Applet.newAudioClip(Inicio.class.getResource("/sonidos/paso.wav"));
		musicaFondo = new BasicPlayer();
		try {
			musicaFondo.open(Inicio.class.getResource("/sonidos/musica fondo.mp3"));
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
		reproduccion = new TimerTask() {
			@Override
			public void run() {
				if(sound){
					if(musicaFondo.getStatus() == BasicPlayer.STOPPED){
						try {
							musicaFondo.play();
						} catch (BasicPlayerException e) {
							e.printStackTrace();
						}
					}
					if(musicaCasilla != null){
						if(musicaCasilla.getStatus() == BasicPlayer.STOPPED){
							try {
								musicaCasilla.play();
							} catch (BasicPlayerException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
		contReproduccion = new Timer();
		contReproduccion.schedule(reproduccion, 0, 10);
	}

	/**
	 * Reproduce la cancion de la casilla que se muestre
	 * @param pos las posicion de la casilla
	 * @throws BasicPlayerException excepcion de la libreria
	 */
	private void reproducirMusica(int pos) throws BasicPlayerException{
		if(sound){
			switch(pos){
			case 1:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Arctic Monkeys - I Wanna Be Yours.mp3"));
				musicaCasilla.play();
				break;
			case 2:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Joe Cocker - You Can Leave Your Hat On.mp3"));
				musicaCasilla.play();
				break;
			case 3:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Marvin Gaye - Sexual Healing.mp3"));
				musicaCasilla.play();
				break;
			case 4:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Kali Uchis - telepatía.mp3"));
				musicaCasilla.play();
				break;
			case 5:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Joe Cocker - You Can Leave Your Hat On.mp3"));
				musicaCasilla.play();
				break;
			case 6:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Marvin Gaye - Let's Get It On.mp3"));
				musicaCasilla.play();
				break;
			case 7:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Two Feet - Love Is A Bitch.mp3"));
				musicaCasilla.play();
				break;
			case 8:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Hot Chocolate - You Sexy Thing.mp3"));
				musicaCasilla.play();
				break;
			case 9:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Arctic Monkeys - I Wanna Be Yours.mp3"));
				musicaCasilla.play();
				break;
			case 10:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Elvis Drew - Make Me Feel.mp3"));
				musicaCasilla.play();
				break;
			case 11:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Hot Chocolate - You Sexy Thing.mp3"));
				musicaCasilla.play();
				break;
			case 12:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Joe Cocker - You Can Leave Your Hat On.mp3"));
				musicaCasilla.play();
				break;
			case 13:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Earned It.mp3"));
				musicaCasilla.play();
				break;
			case 14:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Call Out My Name.mp3"));
				musicaCasilla.play();
				break;
			case 15:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Earned It.mp3"));
				musicaCasilla.play();
				break;
			case 16:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Charlie Puth - Suffer.mp3"));
				musicaCasilla.play();
				break;
			case 17:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Marvin Gaye - Sexual Healing.mp3"));
				musicaCasilla.play();
				break;
			case 19:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Bishop Briggs - River.mp3"));
				musicaCasilla.play();
				break;
			case 20:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Earned It.mp3"));
				musicaCasilla.play();
				break;
			case 21:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Call Out My Name.mp3"));
				musicaCasilla.play();
				break;
			case 22:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/B.Miles - Salt.mp3"));
				musicaCasilla.play();
				break;
			case 23:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Earned It.mp3"));
				musicaCasilla.play();
				break;
			case 25:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Rosenfeld - Do It For Me.mp3"));
				musicaCasilla.play();
				break;
			case 26:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Charlie Puth - Suffer.mp3"));
				musicaCasilla.play();
				break;
			case 27:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Arctic Monkeys - I Wanna Be Yours.mp3"));
				musicaCasilla.play();
				break;
			case 28:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Elvis Drew - Make Me Feel.mp3"));
				musicaCasilla.play();
				break;
			case 29:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Call Out My Name.mp3"));
				musicaCasilla.play();
				break;
			case 30:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Charlie Puth - Suffer.mp3"));
				musicaCasilla.play();
				break;
			case 31:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Hot Chocolate - You Sexy Thing.mp3"));
				musicaCasilla.play();
				break;
			case 32:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Call Out My Name.mp3"));
				musicaCasilla.play();
				break;
			case 33:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Earned It.mp3"));
				musicaCasilla.play();
				break;
			case 35:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Rosenfeld - Do It For Me.mp3"));
				musicaCasilla.play();
				break;
			case 36:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Elvis Drew - Make Me Feel.mp3"));
				musicaCasilla.play();
				break;
			case 37:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/The Weeknd - Call Out My Name.mp3"));
				musicaCasilla.play();
				break;
			case 39:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Two Feet - Go Fuck Yourself.mp3"));
				musicaCasilla.play();
				break;
			case 40:
				musicaFondo.pause();
				musicaCasilla = new BasicPlayer();
				musicaCasilla.open(Inicio.class.getResource("/sonidos/Two Feet - Go Fuck Yourself.mp3"));
				musicaCasilla.play();
				break;
			}
		}
	}

	/**
	 * Pone la imagen final del juego
	 */
	private void ponerPanelFinal(){
		panelFinal = new JPanel();
		panelFinal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panelFinal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.exit(0);
			}
		});
		panelFinal.setBackground(Color.black);
		panelFinal.setBounds(1, 27, 1278, 692);
		panelFinal.setLayout(null);

		JLabel lblLetrero = new JLabel();
		lblLetrero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblLetrero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.exit(0);
			}
		});
		lblLetrero.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/imagen final.png")));
		lblLetrero.setBounds(0, 0, 1278, 692);
		panelFinal.add(lblLetrero);

		contentPane.remove(panelCasilla);
		contentPane.add(panelFinal);
		repaint();
		numPanel = 4;
		lblLetrero.requestFocus();
	}
}
