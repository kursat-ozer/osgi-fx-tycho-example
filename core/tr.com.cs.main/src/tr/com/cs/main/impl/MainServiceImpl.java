package tr.com.cs.main.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tr.com.cs.main.IMainService;
import tr.com.cs.screen.b.IScreenB;

@Component(immediate = true)
public class MainServiceImpl implements IMainService {

	@Reference
	private IScreenB screenBService;

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
		Parent parent = screenBService.getScreen();

		Scene s = new Scene(parent);
		primaryStage.setScene(s);
		primaryStage.setWidth(300);
		primaryStage.setHeight(400);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}
}
