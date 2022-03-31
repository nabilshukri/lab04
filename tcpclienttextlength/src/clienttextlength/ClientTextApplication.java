package clienttextlength;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTextApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		
		//#1
		ClientTextLengthFrame clientTextLengthFrame=new ClientTextLengthFrame();
		clientTextLengthFrame.setVisible(true);
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		
		//#2
		clientTextLengthFrame.updateConnectionStatus(socket.isConnected());
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
				
		//#3
		String textLength= bufferedReader.readLine();
		clientTextLengthFrame.updateServerText(textLength);
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
