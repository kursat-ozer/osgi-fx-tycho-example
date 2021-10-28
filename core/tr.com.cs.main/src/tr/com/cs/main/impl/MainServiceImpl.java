package tr.com.cs.main.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

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
}
