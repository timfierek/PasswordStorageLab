package tf.passwordproject;

import java.util.ArrayList;

/**
 * PasswordStorage is a simple object class that stores and adds passwords to an
 * instance based arraylist
 * 
 * @author Tim Fierek
 *
 */
public class PasswordStorage {

	private ArrayList<String> passwords;
	
	/**
	 * 	Simple constructor for initializing password storage
	 */
	public PasswordStorage(){
		passwords = new ArrayList<String>();
	}
	
	/**
	 * adds passwords to passwords ArrayList depending on certain constraints
	 * 
	 * @param password String to be added as password
	 * @return true if operation was successful, false otherwise
	 */
	public boolean addPassword(String password){
		boolean duplicate = passwords.contains(password);
		
		if(password.equals("admin") || password.equals("mod")) {
			if(duplicate) {
				return false;
			}
			passwords.add(password);
			return true;
		}
		
		boolean correctLength = (password.length() > 7 && password.length() < 12);
		boolean containsNum = hasNum(password);
		boolean containsVowels = hasVowels(password);
		boolean spaces = password.contains(" ");
		
		if(!duplicate && correctLength && containsNum && containsVowels && !spaces) {
			passwords.add(password);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks a string for the occurrence of a number 0-9 excluding 6
	 * 
	 * @param s String to be evaluated
	 * @return true if a non 6 number is contained in s, false otherwise
	 */
	public static boolean hasNum(String s) {
		for(int i = 0; i < 10; i++) {
			if(s.contains("" + i) && i != 6){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks a string for the occurrence of at least 2 capital vowels
	 * 
	 * @param s String to be evaluated
	 * @return true if there are two capital vowels, false otherwise
	 */
	public static boolean hasVowels(String s) {
		int count = 0;
		
		for(char c : s.toCharArray()) {
			if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
				count++;
				if(count == 2) {
					return true;
				}
			}
		}
		
		return false;
	}
}
