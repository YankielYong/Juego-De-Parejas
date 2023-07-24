package logica;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Casilla {
	
	public static Point CASILLA_00 = new Point(0, 0);
	
	private String mensaje;
	private Icon imagenP;
	private ImageIcon imagenG;
	private Rectangle bounds;
	private Point pJ1;
	private Point pJ2;
	
	public Casilla(String mensaje, Icon imagenP, ImageIcon imagenG) {
		this.mensaje = mensaje;
		this.imagenP = imagenP;
		this.imagenG = imagenG;
	}
	public Casilla(String mensaje){
		this.mensaje = mensaje;
		imagenP = null;
		imagenG = null;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	public Point getpJ1() {
		return pJ1;
	}
	public void setpJ1(Point pJ1) {
		this.pJ1 = pJ1;
	}
	public Point getpJ2() {
		return pJ2;
	}
	public void setpJ2(Point pJ2) {
		this.pJ2 = pJ2;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Icon getImagenP() {
		return imagenP;
	}
	public void setImagenP(Icon imagenP) {
		this.imagenP = imagenP;
	}
	public ImageIcon getImagenG() {
		return imagenG;
	}
	public void setImagenG(ImageIcon imagenG) {
		this.imagenG = imagenG;
	}
	
	
}
