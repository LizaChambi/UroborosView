package uroborosGameStudio.ui.components;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream {

	private JTextArea ta;

	public TextAreaOutputStream(JTextArea ta) {
		this.ta = ta;
	}

	@Override
	public void write(int b) throws IOException {
		ta.append(String.valueOf((char) b));
		ta.setCaretPosition(ta.getDocument().getLength());
	}

}
