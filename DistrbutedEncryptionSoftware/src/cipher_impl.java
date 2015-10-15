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
        return message;
    }

   
   
}
