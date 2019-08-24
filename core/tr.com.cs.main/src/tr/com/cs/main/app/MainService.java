package tr.com.cs.main.app;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Application;

import org.eclipse.equinox.app.IApplicationContext;

import org.eclipse.fx.osgi.util.AbstractJFXApplication;

public class MainService extends AbstractJFXApplication {
	protected void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
		Scene s = new Scene(new Label("Hello World"));
		primaryStage.setScene(s);
		primaryStage.setWidth(300);
		primaryStage.setHeight(400);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}

}
