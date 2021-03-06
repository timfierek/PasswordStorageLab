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
	void testContainsPassword1() {
		storage.addPassword("pAsswOrd5");
		assertTrue(storage.hasPassword("pAsswOrd5"));
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
	void testContainsPassword2() {
		storage.addPassword("gOOdl3ngth");		
		assertTrue(storage.hasPassword("gOOdl3ngth"));
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
	void testContainsPassword3() {
		storage.addPassword("hAsNUmber7");	
		assertTrue(storage.hasPassword("hAsNUmber7"));
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
	void testContainsPassword4() {
		storage.addPassword("vOwElsC4ps");
		assertTrue(storage.hasPassword("vOwElsC4ps"));
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
	void testContainsPassword5() {
		storage.addPassword(" wIthASp4cE");
		assertFalse(storage.hasPassword(" wIthASp4cE"));
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
	void testContainsPassword6() {
		storage.addPassword("admin");
		assertTrue(storage.hasPassword("admin"));
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
