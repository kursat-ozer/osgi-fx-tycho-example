package tr.com.cs.screen.b.translation;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Named;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

public class ScreenBTranslation {

	private static final String RESOURCES = "/resources/language/ScreenB";

	@Inject
	@Named("localeString")
	private ObjectProperty<Locale> locale;

	public ScreenBTranslation() {
		super();
	}

	public String get(final String key, final Object... args) {
		ResourceBundle bundle = ResourceBundle.getBundle(RESOURCES, locale.get());
		return MessageFormat.format(bundle.getString(key), args);
	}

	private StringBinding createStringBinding(final String key, Object... args) {
		return Bindings.createStringBinding(() -> get(key, args), locale);
	}

	private StringBinding createStringBinding(Callable<String> func) {
		return Bindings.createStringBinding(func, locale);
	}

	public Label labelForValue(Callable<String> func) {
		Label label = new Label();
		label.textProperty().bind(createStringBinding(func));
		return label;
	}

	public void register(StringProperty stringProperty, String string) {
		stringProperty.bind(createStringBinding(string));
	}
}
