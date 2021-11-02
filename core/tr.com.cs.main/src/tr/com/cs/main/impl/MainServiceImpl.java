package tr.com.cs.main.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tr.com.cs.main.IMainService;

@Component(immediate = true)
public class MainServiceImpl implements IMainService {

	@Activate
	void activate() {
		System.out.println("MainServiceImpl.activate()");
	}

	@Deactivate
	void deactivate() {
		System.out.println("MainServiceImpl.deactivate()");
	}

	@Override
	public void initView(Stage primaryStage) {
		Scene s = new Scene(new Label("Hello World"));
		primaryStage.setScene(s);
		primaryStage.setWidth(300);
		primaryStage.setHeight(400);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}
}
