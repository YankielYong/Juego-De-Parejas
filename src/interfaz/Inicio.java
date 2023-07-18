package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	private JButton btnCerrar;
	private JButton btnMinimizar;
	private JLabel lblJ1;
	private JLabel lblJ2;
	private JTextField txtJ1;
	private JTextField txtJ2;
	private JButton btnIniciar;
	private JLabel lblTitulo;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

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

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		panelInferior.setBounds(1, 27, 1278, 692);
		panelInferior.setLayout(null);
		contentPane.add(panelInferior);

		lblJ1 = new JLabel("Jugador 1");
		lblJ1.setForeground(Color.BLACK);
		lblJ1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblJ1.setBounds(400, 220, 300, 50);
		panelInferior.add(lblJ1);

		lblJ2 = new JLabel("Jugador 2");
		lblJ2.setForeground(Color.BLACK);
		lblJ2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		lblJ2.setBounds(400, 380, 300, 50);
		panelInferior.add(lblJ2);

		lblTitulo = new JLabel();
		lblTitulo.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/titulo.png")));
		lblTitulo.setBounds(140, 40, 1000, 100);
		panelInferior.add(lblTitulo);

		txtJ1 = new JTextField();
		txtJ1.setFont(new Font("Arial", Font.PLAIN, 24));
		txtJ1.setForeground(Color.BLACK);
		txtJ1.setBorder(new LineBorder(new Color(200, 0, 0), 4, true));
		txtJ1.setBackground(Color.WHITE);
		txtJ1.setBounds(400, 270, 480, 50);
		panelInferior.add(txtJ1);

		txtJ2 = new JTextField();
		txtJ2.setFont(new Font("Arial", Font.PLAIN, 24));
		txtJ2.setForeground(Color.BLACK);
		txtJ2.setBorder(new LineBorder(new Color(200, 0, 0), 4, true));
		txtJ2.setBackground(Color.WHITE);
		txtJ2.setBounds(400, 430, 480, 50);
		panelInferior.add(txtJ2);

		btnIniciar = new JButton("Jugar");
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
		panelInferior.add(btnIniciar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/coraz dr.png")));
		label.setBounds(140, 254, 98, 98);
		panelInferior.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/labios 96.png")));
		label_1.setBounds(987, 474, 96, 96);
		panelInferior.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/emoji fuego 96.png")));
		label_2.setBounds(208, 474, 96, 96);
		panelInferior.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/emoji enamorado 96.png")));
		label_3.setBounds(1091, 270, 98, 98);
		panelInferior.add(label_3);
	}
}
