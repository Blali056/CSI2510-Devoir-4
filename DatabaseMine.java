/*
 * Class name: DatabaseMine.java
 * Version: 1.0
 *
 * Description: This class cracks passwords.
 *
 * Created on 23/11/2018
 * Last modified on 23/11/2018
 *
 * @Author names:	Brian Laliberté
 * 
 */


public class DatabaseMine implements DatabaseInterface{
	
	public String save(String plainPassword, String encryptedPassword){
	 // Stores plainPassword and corresponding encryptedPassword in a map.
	 // if there was a value associated with this key, it is replaced, 
	 // and previous value returned; otherwise, null is returned
	 // The key is the encryptedPassword the value is the plainPassword
		return " ";
	}
	public String decrypt(String encryptedPassword){
	// returns plain password corresponding to encrypted password
		return " ";
	}
    public int size(){// returns the number of password pairs stored in the database
		return 1;
	}
    public void printStatistics(){// print statistics based on type of Database

	}
	
}