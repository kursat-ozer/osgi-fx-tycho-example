package tr.com.cureshot.app.main.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import javafx.embed.swing.JFXPanel;

@Component
public class MainService {
	
	@Activate
	void activate() {
		new JFXPanel();
	}
}
