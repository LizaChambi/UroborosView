package uroborosGameStudio.ui.componentListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uroborosGameStudio.domain.appModel.MainWindowModel;

public class NumberWHAdapter implements KeyListener {

	private JTextField textFieldH;
	private JButton okButton;
	private MainWindowModel model;
	private JLabel lblError;
	private JTextField textFieldW;

	public NumberWHAdapter(JTextField textFieldWidth, JTextField textFieldHeight, JButton okButton, MainWindowModel model, JLabel lblNumberError) {
		this.textFieldW = textFieldWidth;
		this.textFieldH = textFieldHeight;
		this.okButton = okButton;
		this.model = model;
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
//		int space = KeyEvent.VK_SPACE; disable
//		int bkSpace = KeyEvent.VK_BACK_SPACE; ignore
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
