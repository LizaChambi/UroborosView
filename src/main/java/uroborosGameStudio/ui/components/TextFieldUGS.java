package uroborosGameStudio.ui.components;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldUGS extends JTextField 
{
	private JTextField textField;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8048228004933668195L;

	public TextFieldUGS(String text, JPanel panel, int x, int y, int width, int height, int columns) 
	{
		textField = createSimpleTextField(text, panel, x, y, width, height);
		textField.setColumns(columns);
	}

	private JTextField createSimpleTextField(String text, JPanel panel, int x, int y, int width, int height) 
	{
		JTextField textField = new JTextField(text);
		textField.setBounds(x, y, width, height);
		panel.add(textField);
		return textField;
	}
	
	public JTextField getTextField()
	{
		return this.textField;
	}

}
