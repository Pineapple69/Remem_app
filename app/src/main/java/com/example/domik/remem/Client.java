package com.example.domik.remem;
import android.util.Log;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/**
 *
 * @author juraj
 *
 */
public class Client {

	private String serverMessage;
	public static  String SERVERIP = "10.0.2.2"; //IP address of localhost using in android

	public static final int SERVERPORT = 2004;   // Port number using by server
	private boolean mRun = false;
	ClientAnswersToServer answersToServersMessages = new ClientAnswersToServer(this);
	ObjectOutputStream out;
	ObjectInputStream in;

	/**
	 * Constructor of the class.
	 */
	public Client(){
	}

	/**
	 * main run method for all communication with server including sending and receive messages
	 */
	public void run() {

		mRun = true;

		try {
			// here is IP address putting
			InetAddress serverAddr = InetAddress.getByName(SERVERIP);
			Log.e("serverAddr", serverAddr.toString());
			Log.e("TCP Client", "C: Connecting...");

			// create a socket to make the connection with the server
			Socket socket = new Socket(serverAddr, SERVERPORT);
			Log.e("TCP Server IP", SERVERIP);
			try {
				out = new ObjectOutputStream(socket.getOutputStream());
				out.flush();
				in = new ObjectInputStream(socket.getInputStream());

				Log.e("TCP Client", "C: Sent.");

				Log.e("TCP Client", "C: Done.");
		/*endless loop for receiving and sending messages with server*/
		while (mRun) {
					serverMessage = (String)in.readObject();//read message from server

					if (serverMessage != null) {
						if(serverMessage.equals("1.Welcome"))
							sendMessage("~SignMeIn;test@mail.sk;test");
						/*call method with new class where are all answers to masseges from server and basic functions*/
						answersToServersMessages.Answers(serverMessage);

					}
					serverMessage = null;
				}
				Log.e("RESPONSE FROM SERVER", "S: Received Message: '" + serverMessage + "'");
			} catch (Exception e) {
				Log.e("TCP", "S: Error", e);
			} finally {
				/* the socket must be closed.*/
				socket.close();
			}
		} catch (Exception e) {
			Log.e("TCP", "C: Error", e);
		}

	}

	/**
	 * method for sending message using output Stream object
	 * @param message
     */
	public void sendMessage(String message) {

		try {
			out.writeObject(message);
			out.flush();
			System.out.println("Server sending >"+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * method for change value to endless loop in method run
	 */
	public void stopClient() {

		mRun = false;
	}




/*
	public interface OnMessageReceived {
		public void messageReceived(String message);
	}*/
}