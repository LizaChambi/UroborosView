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
	private JTable table;

	public BtnRemoveBehaviorActionListener(JTextArea textArea, JTree treeScenes, Canvas canvas, JTable table, JPanel principalPanel) 
	{
		super(treeScenes, canvas);
		this.mainPanel = principalPanel;
		this.textArea = textArea;
		this.table = table;
	}

	@Override
	public void updeteComponent(DefaultMutableTreeNode selectedNode, GameObject gameObject) {
	}

	@Override
	public void updateComponents(GameObject gameObject) 
	{
		int fileSelected = this.table.getSelectedRow();
		if(fileSelected >= 0)
		{
			gameObject.removeBehaviorIndex(fileSelected);
		}
		else
		{
			JOptionPane.showMessageDialog(mainPanel,"No se ha seleccionado ningún comportamiento para eliminar.", "No se puedo eliminar", JOptionPane.INFORMATION_MESSAGE);
		}
		updateTableBehavior(table, gameObject);
		textArea.setText("");
	}

	@Override
	public void updateComponents() {
	}
}
