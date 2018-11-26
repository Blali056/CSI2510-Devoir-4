/*
 * Class name: DatabaseStandard.java
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

 import java.util.HashMap;
 import java.util.Set;

public class DatabaseStandard implements DatabaseInterface{
	
	//Variables
	private HashMap<String, String> hashMap;
	private final int NUMBER_OF_PASSWORDS = 10000;
	
	//Constructors
	public DatabaseStandard(){
		hashMap = new HashMap((NUMBER_OF_PASSWORDS+1)*4/3);
	}
	
	//Utility Methods
	public String save(String plainPassword, String encryptedPassword){
	 // Stores plainPassword and corresponding encryptedPassword in a map.
	 // if there was a value associated with this key, it is replaced, 
	 // and previous value returned; otherwise, null is returned
	 // The key is the encryptedPassword the value is the plainPassword
		
		String previousValue = "";
		
		if(hashMap.containsKey(encryptedPassword))
			previousValue = hashMap.get(encryptedPassword);
		
		hashMap.put(encryptedPassword, plainPassword);
		
		return previousValue;
	}

	public String decrypt(String encryptedPassword){ // returns plain password corresponding to encrypted password
		
		return hashMap.get(encryptedPassword);
	
	}
	
    public int size(){ // returns the number of password pairs stored in the database
		return hashMap.size();
	}
    public void printStatistics(){ // print statistics based on type of Database
		System.out.println("*** DatabaseStandard Statistics ***");
		System.out.println("Size is " + this.size() + " passwords.");
		System.out.println("Initial Number Of Indexes when Created: " + NUMBER_OF_PASSWORDS*4/3);	//*************** Indexes??
		System.out.println("*** End DatabaseStandard Statistics ***");
		
	}
	
	public Set<String> keySet(){ // returns the number of password pairs stored in the database
		return hashMap.keySet();
	}
	
	
}