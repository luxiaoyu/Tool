package com.baidu.chunlei.exercise.stream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-7
 * @version
 * @todo 
 */
public class TestDataOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataOutputStream dos;
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
			for (int i = 0; i < 10; i++){
				dos.writeInt(i);
			}
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
