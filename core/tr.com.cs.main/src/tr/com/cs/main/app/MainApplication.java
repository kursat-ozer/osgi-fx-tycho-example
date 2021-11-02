package tr.com.cs.main.app;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.osgi.util.AbstractJFXApplication;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import javafx.application.Application;
import javafx.stage.Stage;
import tr.com.cs.main.IMainService;

public class MainApplication extends AbstractJFXApplication {
//	protected void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
//		Scene s = new Scene(new Label("Hello World"));
//		primaryStage.setScene(s);
//		primaryStage.setWidth(300);
//		primaryStage.setHeight(400);
//		primaryStage.setTitle("Hello World");
//		primaryStage.show();
//	}

	private IMainService mainService;

	@Override
	protected void jfxStart(IApplicationContext applicationContext, Application jfxApplication, Stage primaryStage) {
		applicationContext.applicationRunning();

		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
		ServiceReference<?> serviceObject = bundleContext.getServiceReference(IMainService.class.getName());
		mainService = (IMainService) bundleContext.getService(serviceObject);

		mainService.initView(primaryStage);

	}

}
