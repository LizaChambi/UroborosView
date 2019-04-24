package uroborosGameStudio.ui.runnable;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.MainWindow;

public class UroborosApplication implements Runnable{

	private MainWindowModel model = new MainWindowModel();
	
	public static void main(String[] args) {
		new UroborosApplication().run();;
	}

	public void run() {	
		new MainWindow(model).run();
	}
	
}
