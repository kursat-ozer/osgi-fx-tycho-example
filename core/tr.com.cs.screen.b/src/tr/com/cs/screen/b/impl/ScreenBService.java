package tr.com.cs.screen.b.impl;

import java.util.Locale;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import tr.com.cs.screen.b.IScreenB;
import tr.com.cs.screen.b.translation.ScreenBTranslation;

@Component(immediate = true)
public class ScreenBService implements IScreenB {

	private ScreenBTranslation translation;

	@Activate
	void activate(BundleContext bundleContext) {
		System.out.println("ScreenBService.activate()");

		Bundle osgiFrameworkBundle = bundleContext.getBundles()[0];
		IEclipseContext serviceContext = EclipseContextFactory
				.getServiceContext(osgiFrameworkBundle.getBundleContext());

		ObjectProperty<Locale> localeProperty = new SimpleObjectProperty<>();
		localeProperty.set(Locale.ENGLISH);
		serviceContext.set("localeString", localeProperty);
		translation = ContextInjectionFactory.make(ScreenBTranslation.class, serviceContext);
	}

	@Override
	public Parent getScreen() {
		StackPane stackPane = new StackPane();
		VBox vBox = new VBox();

		addLabels(vBox);

		stackPane.getChildren().add(vBox);
		return stackPane;
	}

	private void addLabels(VBox vBox) {
		Label label1 = new Label("Satir 1");
		translation.register(label1.textProperty(), "screen.b.label.1");
		vBox.getChildren().add(label1);

		Label label2 = new Label("Satir 2");
		translation.register(label2.textProperty(), "screen.b.label.2");
		vBox.getChildren().add(label2);

		vBox.getChildren().add(new Label("Satir 3"));
		vBox.getChildren().add(new Label("Satir 4"));
	}

}
