package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;

import util.EditorTexto;
import util.MyButtonModel;

public class Aviso extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private JPanel panelSuperior;
	private int xMouse;
	private int yMouse;
	private JPanel panelInferior;
	private JButton btnSalir;
	private JButton btnJugar;
	private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	private JTextPane txtMensaje;
	private JLabel tipo;
	private JLabel imagen;
	private boolean continuar;

	public Aviso(JFrame p) {
		super(p, true);
		
		setResizable(false);
		setUndecorated(true);
		setBounds(pantalla.width/2-235, pantalla.height/2-70, 470, 140);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

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
		panelSuperior.setBounds(1, 1, 468, 26);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);

		panelInferior = new JPanel();
		panelInferior.setBackground(Color.WHITE);
		panelInferior.setBounds(1, 27, 468, 112);
		panelInferior.setLayout(null);
		contentPane.add(panelInferior);
		
		tipo = new JLabel("Aviso");
		tipo.setFont(new Font("Arial", Font.PLAIN, 18));
		tipo.setForeground(Color.BLACK);
		tipo.setBounds(8, 0, 150, 26);
		panelSuperior.add(tipo);
		
		imagen = new JLabel("");
		imagen.setBounds(10, 10, 50, 50);
		imagen.setIcon(new ImageIcon(Aviso.class.getResource("/imagenes/icono advertencia 50.png")));
		panelInferior.add(imagen);
		
		txtMensaje = new JTextPane();
		txtMensaje.setBackground(Color.white);
		txtMensaje.setEditable(false);
		txtMensaje.setFont(new Font("Arial", Font.BOLD, 16));
		txtMensaje.setBounds(65, 15, 390, 40);
		panelInferior.add(txtMensaje);
		
		SimpleAttributeSet attrs = new SimpleAttributeSet();
		EditorTexto.textoAviso(attrs, txtMensaje, "Su pantalla tiene una resolución de "+pantalla.width+
				"x"+pantalla.height+". Se recomienda jugar con una resolución de 1280x720");
		
		btnSalir = new JButton("Salir");
		btnSalir.setModel(new MyButtonModel());
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continuar = false;
				dispose();
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setBorder(new LineBorder(Color.black, 3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setBorder(null);
			}
		});
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setBorder(null);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSalir.setBackground(new Color(200, 0, 0));
		btnSalir.setBounds(220, 70, 100, 30);
		btnSalir.setFocusable(false);
		panelInferior.add(btnSalir);
		
		btnJugar = new JButton("Jugar así");
		btnJugar.setModel(new MyButtonModel());
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				continuar = true;
				dispose();
			}
		});
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnJugar.setBorder(new LineBorder(Color.black, 3));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnJugar.setBorder(null);
			}
		});
		btnJugar.setForeground(Color.BLACK);
		btnJugar.setBorder(null);
		btnJugar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnJugar.setBackground(new Color(200, 0, 0));
		btnJugar.setBounds(340, 70, 100, 30);
		btnJugar.setFocusable(false);
		panelInferior.add(btnJugar);
	}
	
	public boolean continuar(){
		return continuar;
	}

}
