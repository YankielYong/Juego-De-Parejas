package util;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class EditorTexto {
	
	public static void textoNormal(SimpleAttributeSet attrs, JTextPane txt, String texto){
		StyleConstants.setFontSize(attrs, 22);
		StyleConstants.setBold(attrs, false);
		StyleConstants.setItalic(attrs, false);
		try {
			txt.getStyledDocument().insertString(txt.getStyledDocument().getLength(), texto, attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public static void textoCursiva(SimpleAttributeSet attrs, JTextPane txt, String texto){
		StyleConstants.setFontSize(attrs, 22);
		StyleConstants.setItalic(attrs, true);
		StyleConstants.setBold(attrs, true);
		try {
			txt.getStyledDocument().insertString(txt.getStyledDocument().getLength(), texto, attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public static void textoNegrita(SimpleAttributeSet attrs, JTextPane txt, String texto){
		StyleConstants.setFontSize(attrs, 22);
		StyleConstants.setItalic(attrs, false);
		StyleConstants.setBold(attrs, true);
		try {
			txt.getStyledDocument().insertString(txt.getStyledDocument().getLength(), texto, attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public static void nuevaLinea(SimpleAttributeSet attrs, JTextPane txt){
		StyleConstants.setFontSize(attrs, 28);
		try {
			txt.getStyledDocument().insertString(txt.getStyledDocument().getLength(),
					"\n", attrs);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
