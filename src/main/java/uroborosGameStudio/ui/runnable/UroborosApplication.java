package uroborosGameStudio.ui.runnable;

import uroborosGameStudio.domain.appModel.MainWindowModel;
import uroborosGameStudio.ui.MainWindow;

public class UroborosApplication implements Runnable{

	public static void main(String[] args) {
		new UroborosApplication().run();;
	}

	public void run() {	
		new MainWindow().run();
	}
}
