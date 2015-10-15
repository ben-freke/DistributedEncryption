/*

	Distributed Encryption Software
	© Ben Freke 2015
	
*/


public interface cipher 
          extends java.rmi.Remote {	
    

    // add takes two long values, adds them together and returns the resulting
    //  long value

	 public String encrypt(String message, String key)
        throws java.rmi.RemoteException;

}
