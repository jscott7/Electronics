package com.jsco.robotarmcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import android.os.AsyncTask;

/**
 * Very Simple TCP Client for sending characters to a socket
 * The put is done on a background thread
 * 
 * @author Jonathan Scott
 *
 */
public class TcpClient extends AsyncTask<String, Object, Object> {

	private static String s_hostName = "192.168.0.12";
	private static int s_port = 5005;
	
	private static Socket s_socket = null;
	private static PrintWriter s_out = null;
		
	public static void close()
	{
		try {
			s_out.close();
			s_socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Put the first character of the first String onto the socket 
	 */
	@Override
	protected Void doInBackground(String... params) {
		try
		{
			char ch = params[0].charAt(0);
			if (s_socket == null)
			{
				s_socket = new Socket(s_hostName, s_port);
				s_out = new PrintWriter(s_socket.getOutputStream(), true);
			}
				
			s_out.println(ch);
		}
		catch(Exception ex)
		{
			
		}
		
		return null;
	}
}
