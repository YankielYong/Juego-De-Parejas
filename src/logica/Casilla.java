package logica;

import javax.swing.ImageIcon;

public class Casilla {
	
	private String mensaje;
	private ImageIcon imagenP;
	private ImageIcon imagenG;
	
	public Casilla(String mensaje, ImageIcon imagenP, ImageIcon imagenG) {
		this.mensaje = mensaje;
		this.imagenP = imagenP;
		this.imagenG = imagenG;
	}
	public Casilla(String mensaje){
		this.mensaje = mensaje;
		imagenP = null;
		imagenG = null;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ImageIcon getImagenP() {
		return imagenP;
	}
	public void setImagenP(ImageIcon imagenP) {
		this.imagenP = imagenP;
	}
	public ImageIcon getImagenG() {
		return imagenG;
	}
	public void setImagenG(ImageIcon imagenG) {
		this.imagenG = imagenG;
	}
	
	
}
