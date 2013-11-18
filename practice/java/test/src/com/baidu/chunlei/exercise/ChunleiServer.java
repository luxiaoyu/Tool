package com.baidu.chunlei.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-27
 * @version
 * @todo 
 */
public class ChunleiServer {
	private static ChunleiServer mInstance = null;
	private final static int PHONE_PORT = 7777;
	private final static int PC_PORT = 7777;
	
	private ChunleiServer(){
//		adbForward();
		setup();
	}
	
	public static ChunleiServer getInstance(){
		if (null == mInstance){
			mInstance = new ChunleiServer();
		}
		return mInstance;
	}
	
	public boolean adbForward(){
		String adbForward = "adb ";
//		if(!deviceId.trim().equals("")){
//			adbForward += " -s "+deviceId;
//		}   
		adbForward += "forward tcp:"+PC_PORT+" tcp:"+PHONE_PORT;
		try {
			Runtime.getRuntime().exec(adbForward);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @return
	 */
	public boolean setup(){
		try {
			System.out.println("connecting.......");
			ServerSocket serverSocket = new ServerSocket(PC_PORT);
			// ���ϻ�ȡ��ͻ��˵����ӣ����������ͻ��˽������ӣ�
			while (true) {
				// ��ȡ��һ���ͻ��˵�����
				Socket client = serverSocket.accept();
				System.out.println("S: Receiving...");
				try {
					// ��ȡ��ĳ�������ϵĿͻ��˵�������
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					String clientConent = in.readLine();
					// ��ӡ������˽��յĿͻ��˵���Ϣ
					System.out.println("Client:  " + clientConent);
				} catch (Exception e) {
					System.out.println("Server Receive: Error");
					e.printStackTrace();
				} finally {
					client.close();
					System.out.println("Server Receive: Done.");
				}
			}
		} catch (Exception e) {
			System.out.println("S: Error");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChunleiServer.getInstance();
	}

}
