package uroborosGameStudio.ui.componentListeners;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.team.uroboros.uroboros.engine.ui.Canvas;

import uroborosGameStudio.domain.GameObject;

public class BtnRemoveBehaviorActionListener extends AbstractEditionListener
{
	private JPanel mainPanel;
	private JTextArea textArea;

	public BtnRemoveBehaviorActionListener(JTextArea textArea, JTree treeScenes, Canvas canvas, JTable table, JPanel principalPanel) 
	{
		super(treeScenes, canvas, table);
		this.mainPanel = principalPanel;
		this.textArea = textArea;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		int fileSelected = getTable().getSelectedRow();
		if(fileSelected >= 0)
		{
			gameObject.removeBehaviorIndex(fileSelected);
		}
		else
		{
			JOptionPane.showMessageDialog(mainPanel,"No se ha seleccionado ningún comportamiento para eliminar.", "No se puedo eliminar", JOptionPane.INFORMATION_MESSAGE);
		}
		updateTable(gameObject);
		textArea.setText("");
	}

	@Override
	public void updateComponents() {
		// TODO Auto-generated method stub
		
	}
}
