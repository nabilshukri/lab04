package servertextlength;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTextApplication {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ServerTextGui frame = new ServerTextGui();
		frame.setVisible(true);
		
		

	}
	
	public void Continue(String textLength)throws IOException {
		// Launch the server frame
		ServerTextFrame serverFrame = new ServerTextFrame();
		serverFrame.setVisible(true);

		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		ServerSocket serverSocket = new ServerSocket(portNo);

		//WordCount wordCount = new WordCount();

		// Counter to keep track the number of requested connection
		int totalRequest = 0;

		// Server needs to be alive forever
		while (true) {

			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);


			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();


			//#1 Text Length
			//String textLength = wordCount.getTextLength();

			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());

			//#2
			outputStream.writeBytes(textLength);

			// Close the socket
			clientSocket.close();

			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + textLength);

			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );



		}
	}

}
