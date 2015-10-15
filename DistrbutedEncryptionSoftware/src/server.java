/*

	Distributed Encryption Software
	© Ben Freke 2015
	
*/


import java.rmi.Naming;	//Import naming classes to bind to rmiregistry

public class server {

   //calculatorserver constructor
   public server() {
     
     //Construct a new CalculatorImpl object and bind it to the local rmiregistry
     //N.b. it is possible to host multiple objects on a server by repeating the
     //following method. 

     try {
       	cipher c = new cipher_impl();
       	Naming.rebind("rmi://localhost/EncryptionService", c);
     } 
     catch (Exception e) {
       System.out.println("Server Error: " + e);
     }
   }

   public static void main(String args[]) {
     	//Create the new Calculator server
	new server();
   }
}