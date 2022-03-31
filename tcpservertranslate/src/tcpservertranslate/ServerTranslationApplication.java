package tcpservertranslate;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerTranslationApplication {


	public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		new ServerFrame().setVisible(true);
		
		

	}
	
	public void Continue(String output) throws IOException {
		
		
		ServerOriginalFrame serverFrame = new ServerOriginalFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current output back to the client
			outputStream.writeUTF(output);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + output);
			
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );		
			
		}
		
	}

}