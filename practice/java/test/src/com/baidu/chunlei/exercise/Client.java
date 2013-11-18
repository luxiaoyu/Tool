package com.baidu.chunlei.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public void writeToServer(String message){
		Socket socket = null;
		try{
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 48888);
			System.out.println("Sending: '" + message + "'");
			PrintWriter out = new PrintWriter(new BufferedWriter(new 
					OutputStreamWriter(socket.getOutputStream())), true);
			out.println(message);
		}catch (UnknownHostException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				if (socket != null){
					socket.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client().writeToServer("from client");
	}

}
