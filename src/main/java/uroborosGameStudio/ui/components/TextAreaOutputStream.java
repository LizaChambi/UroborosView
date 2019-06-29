package uroborosGameStudio.ui.components;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream {

	private JTextArea textArea;

	public TextAreaOutputStream(JTextArea ta) {
		this.textArea = ta;
		
		PrintStream printStream = new PrintStream(this);
		System.setOut(printStream);
		System.setErr(printStream);
	}
	
	@Override
	public void write(int b) throws IOException {
		textArea.append(String.valueOf((char) b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

}
