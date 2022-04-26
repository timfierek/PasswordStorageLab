package tf.passwordproject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PasswordStorageTest {

	private static PasswordStorage storage;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		storage = new PasswordStorage();
	}

	// Password must be 7-11 characters, have one non-six number, have no spaces
	// and must contain two capital vowels. 
	
	@Test
	void testDuplicatePasswords1() {
		storage.addPassword("pAsswOrd5");
		assertFalse(storage.addPassword("pAsswOrd5"));
	}
	@Test
	void testDuplicatePasswords2() {
		storage.addPassword("dUplicAte4");
		assertFalse(storage.addPassword("dUplicAte4"));
	}

	@Test
	void testPasswordLength1() {
		assertFalse(storage.addPassword("3hOrtE"));
	}
	
	@Test
	void testPasswordLength2() {
		assertFalse(storage.addPassword("WayTOOLongOfAPassw0rd"));
	}
	
	@Test
	void testPasswordLength3() {
		assertTrue(storage.addPassword("gOOdl3ngth"));
	}
	
	@Test
	void testPasswordNums1() {
		assertFalse(storage.addPassword("nONUmbers"));
	}
	
	@Test
	void testPasswordNums2() {
		assertTrue(storage.addPassword("hAsNUmber7"));
	}
	
	@Test
	void testPasswordNums3() {
		assertFalse(storage.addPassword("hAsNUmber6"));
	}
	
	@Test
	void testPasswordVowels1() {
		assertFalse(storage.addPassword("nocapsvow3l"));
	}
	
	@Test
	void testPasswordVowels2() {
		assertTrue(storage.addPassword("vOwElsC4ps"));
	}
	
	@Test
	void testPasswordSpaces1() {
		assertFalse(storage.addPassword(" wIthASp4cE"));
	}
	
	@Test
	void testPasswordSpaces2() {
		assertTrue(storage.addPassword("nOspAc3s"));
	}
	
	@Test
	void testSpecialPasswords1() {
		assertTrue(storage.addPassword("admin"));
	}
	
	@Test
	void testSpecialPasswords2() {
		assertFalse(storage.addPassword("admin"));
	}
	
	@Test
	void testSpecialPasswords3() {
		assertTrue(storage.addPassword("mod"));
	}
	
	@Test
	void testSpecialPasswords4() {
		assertFalse(storage.addPassword("mod"));
	}

}