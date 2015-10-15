/*

	Distributed Encryption Software
	© Ben Freke 2015
	
*/

// The implementation Class must implement the rmi interface (calculator)
// and be set as a Remote object on a server

public class cipher_impl
    extends java.rmi.server.UnicastRemoteObject
    implements cipher {

    // Implementations must have an explicit constructor
    // in order to declare the RemoteException exception

    public cipher_impl()
        throws java.rmi.RemoteException {
        super();
    }

   
    public String encrypt(String message, String key)
        throws java.rmi.RemoteException {
    	
    	char[] messageChars = message.toCharArray();
    	char[] keyChars = key.toCharArray();
    	
    	int n = message.length();
    	
    	int z = messageChars[n-1], y = keyChars[0], delta = 0x9E3779B9;
    	int mx, e, q = (int) Math.floor(6 + 52/n), sum = 0;
    	
    	//Encryption Begins
    	
    	

    	
    	char[] encryptedChars = new char[messageChars.length];
    	//48 to 122
    	int keyCount = 0;
		int tempASCII = 0;

    	for (int i = 0; i<messageChars.length; i++){

    		tempASCII = (int) messageChars[i] % (int) keyChars[keyCount];
    		encryptedChars[i] = (char) (tempASCII+48);
    		if (keyCount+1 == keyChars.length) keyCount = 0;
    		keyCount++;
    	}
    	
    	
    	
        return new String(encryptedChars);
    }
    
    public String decrypt(String message, String key)
            throws java.rmi.RemoteException {
        	
        	//Encryption Begins
        	
        	char[] encryptedChars = message.toCharArray();
        	char[] keyChars = key.toCharArray();

        	
        	char[] messageChars = new char[encryptedChars.length];
        	//48 to 122
        	int keyCount = 0;
    		int tempASCII = 0;

        	for (int i = 0; i<encryptedChars.length; i++){

        		tempASCII = (int) encryptedChars[i] + (int) keyChars[keyCount];
        		if (tempASCII > 122) tempASCII = (tempASCII - 122) + 48;
        		else if (tempASCII < 48) tempASCII = (48 - tempASCII) + 48;
        		encryptedChars[i] = (char) tempASCII;
        		if (keyCount+1 == keyChars.length) keyCount = 0;
        		keyCount++;
        	}
        	
        	
        	
            return new String(encryptedChars);
        }

   
   
}
