package tr.com.cs.screen.b.impl;

import org.osgi.service.component.annotations.Component;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tr.com.cs.screen.b.IScreenB;

@Component(immediate = true)
public class ScreenBService implements IScreenB {

	@Override
	public Parent getScreen() {
		StackPane stackPane = new StackPane();
		VBox vBox = new VBox();
		vBox.getChildren().add(new Label("Satir 1"));
		vBox.getChildren().add(new Label("Satir 2"));
		vBox.getChildren().add(new Label("Satir 3"));
		vBox.getChildren().add(new Label("Satir 4"));
		stackPane.getChildren().add(vBox);
		return stackPane;
	}

}
