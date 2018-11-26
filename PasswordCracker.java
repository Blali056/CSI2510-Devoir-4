/*
 * Class name: PasswordCracker.java
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

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class PasswordCracker{
	
	//Constructors
	public PasswordCracker(){
		
	}
	
	
	public void createDatabase(ArrayList<String> commonPasswords, DatabaseInterface database){
		
		for(String password : commonPasswords){
			
			//Flags for the applied rules
			boolean[] flags = new boolean[5];
			
			//save the word into the database
			try{
				database.save(password, Sha1.hash(password));
			
			
				//Capitalizes the first character of the password
				if(97 <= password.charAt(0) && password.charAt(0) <= 122){
					flags[0] = true;
				}
				
				//save the word increased with rule 2 into the database
				flags[1] = true;
			}catch(Exception e){
				
			}
			//check if the password contains a vowel (a, e, i)
			//and increases the password with rules 3, 4, 5.
			Scanner scan = new Scanner(password);
			for(char token : password.toCharArray()){
				
				switch(token){

					case 'a':	case 'A':	
					flags[2] = true;
											break;
					case 'e':	case 'E':	
					flags[3] = true;
											break;
					case 'i':	case 'I':	
					flags[4] = true;
											break;
					default:
						break;
				}
			}
			recursiveInc(password, flags, database);
		}
	}
	public String crackPassword(String encryptedPassword, DatabaseInterface database){
		
		for(String key : ((DatabaseStandard) database).keySet()){
			if(encryptedPassword.equals(key)){
				return database.decrypt(key);
			}
		}
		return "";
	}
	
	
	void recursiveInc(String password, boolean[] flags, DatabaseInterface database){
		recursiveInc(password, flags, database, 0, 5);
	}
	
	
	
	private int recursiveInc(String password, boolean[] flags, DatabaseInterface database, int i, int max){
		
		String newPass = "";
		if(max <= i || max == 0)
			return 0;
		if(flags[i]){
			newPass = PasswordCracker.ruleThePassword(password, i);
			try{
				if(!database.save(newPass, Sha1.hash(newPass)).equals(""))
					return 0;
			}catch(Exception e){}
		}
		if(i != max-1 )
			recursiveInc(password, flags, database, (i+1)%max, max);
		
		if(!newPass.equals(""))
			recursiveInc(newPass, flags, database, (i+1)%max, max-1);
		
		return 0;
		
	}

	//Rules Methods
	private static String ruleThePassword(String password, int i){
		String newPass = "";
		switch(i){
			
			case 0:
					newPass = password.substring(0, 1).toUpperCase() + password.substring(1);
					break;
			case 1:
					newPass = password + "2018";
					break;
			case 2:
					newPass = password.replace('a', '@').replace('A', '@');
					break;
			case 3:
					newPass = password.replace('e', '3').replace('E', '3');
					break;
			case 4:
					newPass = password.replace('i', '1').replace('I', '1');
					break;
			default:
					break;
		}
		return newPass;
	}
}