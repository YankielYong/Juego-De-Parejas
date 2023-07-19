package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.MyButtonModel;

public class Tablero extends JFrame {

	private JPanel contentPane;
	private JPanel panelSuperior;
	private JButton btnCerrar;
	private JButton btnMinimizar;
	private int xMouse;
	private int yMouse;
	private JPanel panelTablero;
	private JPanel panelDados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero frame = new Tablero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tablero() {
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

		btnCerrar = new JButton("");
		btnCerrar.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/close.png")));
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
		
		panelTablero = new JPanel();
		panelTablero.setBackground(Color.WHITE);
		panelTablero.setBounds(1, 27, 1278, 692);
		panelTablero.setLayout(null);
		contentPane.add(panelTablero);
		
		panelDados = new JPanel();
		panelDados.setBackground(Color.orange);
		panelDados.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDados.setBounds(1130, 15, 120, 100);
		panelDados.setLayout(null);
		panelTablero.add(panelDados);
		
		JButton btnSalida = new JButton("Salida");
		btnSalida.setBackground(Color.RED);
		btnSalida.setBounds(30, 540, 140, 140);
		panelTablero.add(btnSalida);
		
		JButton button_5 = new JButton("01");
		button_5.setBackground(Color.BLUE);
		button_5.setBounds(170, 590, 120, 90);
		panelTablero.add(button_5);
		
		JButton button = new JButton("02");
		button.setBackground(Color.GREEN);
		button.setBounds(290, 590, 120, 90);
		panelTablero.add(button);
		
		JButton button_1 = new JButton("03");
		button_1.setBackground(Color.RED);
		button_1.setBounds(410, 590, 120, 90);
		panelTablero.add(button_1);
		
		JButton button_2 = new JButton("04");
		button_2.setBackground(Color.YELLOW);
		button_2.setBounds(530, 590, 120, 90);
		panelTablero.add(button_2);
		
		JButton button_3 = new JButton("05");
		button_3.setBackground(Color.CYAN);
		button_3.setBounds(650, 590, 120, 90);
		panelTablero.add(button_3);
		
		JButton button_6 = new JButton("06");
		button_6.setBackground(Color.PINK);
		button_6.setBounds(770, 590, 120, 90);
		panelTablero.add(button_6);
		
		JButton button_7 = new JButton("07");
		button_7.setBackground(Color.BLUE);
		button_7.setBounds(890, 590, 120, 90);
		panelTablero.add(button_7);
		
		JButton button_8 = new JButton("08");
		button_8.setBackground(Color.GREEN);
		button_8.setBounds(1010, 590, 120, 90);
		panelTablero.add(button_8);
		
		JButton button_9 = new JButton("09");
		button_9.setBackground(Color.RED);
		button_9.setBounds(1130, 590, 120, 90);
		panelTablero.add(button_9);
		
		JButton button_10 = new JButton("10");
		button_10.setBackground(Color.PINK);
		button_10.setBounds(1130, 500, 120, 90);
		panelTablero.add(button_10);
		
		JButton button_11 = new JButton("11");
		button_11.setBackground(Color.GREEN);
		button_11.setBounds(1130, 410, 120, 90);
		panelTablero.add(button_11);
		
		JButton button_12 = new JButton("12");
		button_12.setBackground(Color.BLUE);
		button_12.setBounds(1130, 320, 120, 90);
		panelTablero.add(button_12);
		
		JButton button_13 = new JButton("19");
		button_13.setBackground(Color.PINK);
		button_13.setBounds(890, 410, 120, 90);
		panelTablero.add(button_13);
		
		JButton button_14 = new JButton("20");
		button_14.setBackground(Color.CYAN);
		button_14.setBounds(770, 410, 120, 90);
		panelTablero.add(button_14);
		
		JButton button_15 = new JButton("23");
		button_15.setBackground(Color.GREEN);
		button_15.setBounds(410, 410, 120, 90);
		panelTablero.add(button_15);
		
		JButton button_16 = new JButton("21");
		button_16.setBackground(Color.YELLOW);
		button_16.setBounds(650, 410, 120, 90);
		panelTablero.add(button_16);
		
		JButton button_17 = new JButton("22");
		button_17.setBackground(Color.RED);
		button_17.setBounds(530, 410, 120, 90);
		panelTablero.add(button_17);
		
		JButton btnBajaLaEscalera_3 = new JButton("baja la escalera");
		btnBajaLaEscalera_3.setBackground(Color.BLUE);
		btnBajaLaEscalera_3.setBounds(290, 410, 120, 90);
		panelTablero.add(btnBajaLaEscalera_3);
		
		JButton button_19 = new JButton("26");
		button_19.setBackground(Color.YELLOW);
		button_19.setBounds(50, 410, 120, 90);
		panelTablero.add(button_19);
		
		JButton btnSubeLaEscalera = new JButton("25");
		btnSubeLaEscalera.setBackground(Color.CYAN);
		btnSubeLaEscalera.setBounds(170, 410, 120, 90);
		panelTablero.add(btnSubeLaEscalera);
		
		JButton button_21 = new JButton("13");
		button_21.setBackground(Color.PINK);
		button_21.setBounds(1130, 230, 120, 90);
		panelTablero.add(button_21);
		
		JButton button_22 = new JButton("17");
		button_22.setBackground(Color.YELLOW);
		button_22.setBounds(890, 230, 120, 90);
		panelTablero.add(button_22);
		
		JButton btnCruzaElPuente = new JButton("Cruza el puente");
		btnCruzaElPuente.setBackground(Color.CYAN);
		btnCruzaElPuente.setBounds(890, 320, 120, 90);
		panelTablero.add(btnCruzaElPuente);
		
		JButton button_24 = new JButton("16");
		button_24.setBackground(Color.RED);
		button_24.setBounds(890, 140, 120, 90);
		panelTablero.add(button_24);
		
		JButton button_25 = new JButton("27");
		button_25.setBackground(Color.PINK);
		button_25.setBounds(50, 320, 120, 90);
		panelTablero.add(button_25);
		
		JButton button_26 = new JButton("28");
		button_26.setBackground(Color.GREEN);
		button_26.setBounds(50, 230, 120, 90);
		panelTablero.add(button_26);
		
		JButton button_27 = new JButton("29");
		button_27.setBackground(Color.RED);
		button_27.setBounds(170, 230, 120, 90);
		panelTablero.add(button_27);
		
		JButton btnBajaLaEscalera_1 = new JButton("37");
		btnBajaLaEscalera_1.setBackground(Color.YELLOW);
		btnBajaLaEscalera_1.setBounds(410, 50, 120, 90);
		panelTablero.add(btnBajaLaEscalera_1);
		
		JButton button_29 = new JButton("36");
		button_29.setBackground(Color.CYAN);
		button_29.setBounds(530, 50, 120, 90);
		panelTablero.add(button_29);
		
		JButton btnBajaLaEscalera = new JButton("30");
		btnBajaLaEscalera.setBackground(Color.PINK);
		btnBajaLaEscalera.setBounds(290, 230, 120, 90);
		panelTablero.add(btnBajaLaEscalera);
		
		JButton btnCruzaElPuente_1 = new JButton("cruza el puente");
		btnCruzaElPuente_1.setBackground(Color.CYAN);
		btnCruzaElPuente_1.setBounds(650, 140, 120, 90);
		panelTablero.add(btnCruzaElPuente_1);
		
		JButton button_32 = new JButton("31");
		button_32.setBackground(Color.BLUE);
		button_32.setBounds(410, 230, 120, 90);
		panelTablero.add(button_32);
		
		JButton btnSubeLaEscalera_1 = new JButton("32");
		btnSubeLaEscalera_1.setBackground(Color.GREEN);
		btnSubeLaEscalera_1.setBounds(530, 230, 120, 90);
		panelTablero.add(btnSubeLaEscalera_1);
		
		JButton button_34 = new JButton("33");
		button_34.setBackground(Color.RED);
		button_34.setBounds(650, 230, 120, 90);
		panelTablero.add(button_34);
		
		JButton button_35 = new JButton("35");
		button_35.setBackground(Color.YELLOW);
		button_35.setBounds(650, 50, 120, 90);
		panelTablero.add(button_35);
		
		JButton button_36 = new JButton("14");
		button_36.setBackground(Color.CYAN);
		button_36.setBounds(1130, 140, 120, 90);
		panelTablero.add(button_36);
		
		JButton button_37 = new JButton("15");
		button_37.setBackground(Color.BLUE);
		button_37.setBounds(1010, 140, 120, 90);
		panelTablero.add(button_37);
		
		JButton btnEscogeTuPremio = new JButton("Escoge tu premio");
		btnEscogeTuPremio.setBackground(Color.RED);
		btnEscogeTuPremio.setBounds(30, 30, 140, 140);
		panelTablero.add(btnEscogeTuPremio);
		
		JButton btnBajaLaEscalera_2 = new JButton("baja la escalera");
		btnBajaLaEscalera_2.setBackground(Color.BLUE);
		btnBajaLaEscalera_2.setBounds(290, 50, 120, 90);
		panelTablero.add(btnBajaLaEscalera_2);
		
		JButton button_40 = new JButton("39");
		button_40.setBackground(Color.GREEN);
		button_40.setBounds(170, 50, 120, 90);
		panelTablero.add(button_40);
	}
}
