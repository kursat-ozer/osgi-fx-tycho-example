package tr.com.cs.main.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * MainService sınıfı için yazılan test sınıfıdır.
 * 
 * NOT: Test sınıflarının test ortamında koşulabilmesi için sınıf isminin sonu
 * "Test" olmalıdır. "Tests" gibi çoğul ya da farklı isimler testin görülmesini
 * engeller.
 * 
 * 
 * @author kursat.ozer
 *
 */
public class MainServiceTest {

	@Test
	void validationTrueTest() {
		assertTrue(true);
	}

	@Test
	void validationFalseTest() {
		assertFalse(false);
	}

}
