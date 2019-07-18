package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class NumberWHAdapter implements KeyListener {

	private JButton okButton;
	private JLabel lblError;

	public NumberWHAdapter(JButton okButton, JLabel lblNumberError) {
		this.okButton = okButton;
		this.lblError = lblNumberError;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		char numString = e.getKeyChar();
		
		if (Character.isLetter(numString)  ) {
			changeStatus("Solo se ingresa numeros", false);
		} else {
			changeStatus("", true);
		}
	}
	
	private void changeStatus(String info, boolean enable) {
		lblError.setText(info);
		this.okButton.setEnabled(enable);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
