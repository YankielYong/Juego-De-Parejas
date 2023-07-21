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

import util.MyButtonModel;
import util.Validaciones;

import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import logica.Juego;
import logica.Jugador;

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
	private JButton btnIniciar;
	private JLabel lblCorazon;
	private JLabel lblLabios;
	private JLabel lblFuego;
	private JLabel lblEmoji;
	private String txt;
	private Jugador j1;
	private Jugador j2;
	/*
	 * Panel donde se mostrara el tablero
	 */
	private JPanel panelTablero;
	private JPanel panelDados;
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
	
	private Juego game;
	
	

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
		setTitle("Juego de Parejas");
		
		
		
		/*-----------------------------------*\
		|     Panel General Con Sus Datos     |
		\*-----------------------------------*/
		setResizable(false);
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
		txtJ1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				realizarAccion(1, e.getKeyCode());
				txt = txtJ1.getText();
				if(Validaciones.jugador(txt)){
					j1 = new Jugador(txt);
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
		txtJ2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				realizarAccion(2, e.getKeyCode());
				txt = txtJ2.getText();
				if(Validaciones.jugador(txt)){
					j2 = new Jugador(txt);
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

		btnIniciar = new JButton("Jugar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarPanelTablero(panelInicio);
				game = new Juego(j1, j2);
				inicializarCasillas();
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
		lblLabios.setBounds(987, 474, 96, 96);
		panelInicio.add(lblLabios);

		lblFuego = new JLabel("");
		lblFuego.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/emoji fuego 96.png")));
		lblFuego.setBounds(208, 474, 96, 96);
		panelInicio.add(lblFuego);

		lblEmoji = new JLabel("");
		lblEmoji.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/emoji enamorado 96.png")));
		lblEmoji.setBounds(1091, 270, 98, 98);
		panelInicio.add(lblEmoji);
		
		
		/*---------------------*\
		|     Panel Tablero     |
		\*---------------------*/
		panelTablero = new JPanel();
		panelTablero.setBackground(Color.WHITE);
		panelTablero.setBounds(1, 27, 1278, 692);
		panelTablero.setLayout(null);
		
		panelDados = new JPanel();
		panelDados.setBackground(Color.orange);
		panelDados.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDados.setBounds(1130, 15, 120, 100);
		panelDados.setLayout(null);
		panelTablero.add(panelDados);
		
		
		
		
	}

	/**m
	 * Coloca visualmente las casillas del tablero
	 */
	private void inicializarCasillas(){
		casilla00 = new JLabel("");
		casilla00.setBounds(30, 540, 140, 140);
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
		casilla01.setBounds(170, 590, 120, 90);
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
		casilla02.setBounds(290, 590, 120, 90);
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
		casilla03.setBounds(410, 590, 120, 90);
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
		casilla04.setBounds(530, 590, 120, 90);
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
		casilla05.setBounds(650, 590, 120, 90);
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
		casilla06.setBounds(770, 590, 120, 90);
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
		casilla07.setBounds(890, 590, 120, 90);
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
		casilla08.setBounds(1010, 590, 120, 90);
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
		casilla09.setBounds(1130, 590, 120, 90);
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
		casilla10.setBounds(1130, 500, 120, 90);
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
		casilla11.setBounds(1130, 410, 120, 90);
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
		casilla12.setBounds(1130, 320, 120, 90);
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
		casilla13.setBounds(1130, 230, 120, 90);
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
		casilla14.setBounds(1130,140, 120, 90);
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
		casilla15.setBounds(1010,140, 120, 90);
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
		casilla16.setBounds(890,140, 120, 90);
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
		casilla17.setBounds(890, 230, 120, 90);
		casilla17.setIcon(game.getCasillas().get(17).getImagenP());
		casilla17.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla17);
		
		casilla18 = new JLabel("");
		casilla18.setBounds(890, 320, 120, 90);
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
		casilla19.setBounds(890,410, 120, 90);
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
		casilla20.setBounds(770,410, 120, 90);
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
		casilla21.setBounds(650,410, 120, 90);
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
		casilla22.setBounds(530, 410, 120, 90);
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
		casilla23.setBounds(410, 410, 120, 90);
		casilla23.setIcon(game.getCasillas().get(23).getImagenP());
		casilla23.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla23);
		
		casilla24 = new JLabel("");
		casilla24.setBounds(290, 410, 120, 90);
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
		casilla25.setBounds(170, 410, 120, 90);
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
		casilla26.setBounds(50, 410, 120, 90);
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
		casilla27.setBounds(50, 320, 120, 90);
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
		casilla28.setBounds(50, 230, 120, 90);
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
		casilla29.setBounds(170, 230, 120, 90);
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
		casilla30.setBounds(290, 230, 120, 90);
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
		casilla31.setBounds(410, 230, 120, 90);
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
		casilla32.setBounds(530, 230, 120, 90);
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
		casilla33.setBounds(650, 230, 120, 90);
		casilla33.setIcon(game.getCasillas().get(33).getImagenP());
		casilla33.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla33);
		
		casilla34 = new JLabel("");
		casilla34.setBounds(650, 140, 120, 90);
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
		casilla35.setBounds(650, 50, 120, 90);
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
		casilla36.setBounds(530, 50, 120, 90);
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
		casilla37.setBounds(410, 50, 120, 90);
		casilla37.setIcon(game.getCasillas().get(37).getImagenP());
		casilla37.setBorder(new LineBorder(Color.black, 1));
		panelTablero.add(casilla37);
		
		casilla38 = new JLabel("");
		casilla38.setBounds(290, 50, 120, 90);
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
		casilla39.setBounds(170, 50, 120, 90);
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
		casilla40.setBounds(30, 30, 140, 140);
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
		contentPane.add(panelCasilla);
		
		casillaG = new JLabel("");
		casillaG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				llamarPanelTablero(panelCasilla);
			}
		});
		casillaG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				llamarPanelTablero(panelCasilla);
			}
		});
		casillaG.setBounds(0, 0, 1278, 692);
		casillaG.setIcon(game.getCasillas().get(pos).getImagenG());
		panelCasilla.add(casillaG);
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
					inicializarCasillas();
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
		if(j1 != null && j2 != null)
			btnIniciar.setEnabled(true);
		else
			btnIniciar.setEnabled(false);
	}
}
