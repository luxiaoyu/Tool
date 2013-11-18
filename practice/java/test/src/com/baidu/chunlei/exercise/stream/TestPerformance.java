package com.baidu.chunlei.exercise.stream;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-7
 * @version
 * @todo 
 */
public class TestPerformance {
	public final static int SIZE = 19999999;
	public final static int CUSTOM_BUFFER_SIZE_2 = 8192 * 2;
	public final static int CUSTOM_BUFFER_SIZE_4 = 8192 * 4;
	public final static int CUSTOM_BUFFER_SIZE_8 = 8192 * 8;

	public static void writeByteUseFileOutputStream(byte[] vals) throws IOException{
		long startTime = System.currentTimeMillis();
		
		FileOutputStream fout = new FileOutputStream("Test1.dat");
	    for (int i = 0; i < vals.length; i ++){
	    	fout.write(vals[i]);
	    }
	    fout.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeByteUseFileOutputStream use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeByteUseFileWriter(byte[] vals) throws IOException{
		long startTime = System.currentTimeMillis();
		
		FileWriter fw = new FileWriter("Test2.dat");
	    for (int i = 0; i < vals.length; i ++){
	    	fw.write(vals[i]);
	    }
	    fw.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeByteUseFileWriter use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeByteUseDefaultBufferedOutputStream(byte[] vals) throws IOException{
		long startTime = System.currentTimeMillis();
		
		FileOutputStream fout = new FileOutputStream("Test3.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fout);
	    for (int i = 0; i < vals.length; i ++){
	    	bos.write(vals[i]);
	    }
	    bos.flush();
	    bos.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeByteUseDefaultBufferedOutputStream use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeByteUseDefaultBufferedWriter(byte[] vals) throws IOException{
		long startTime = System.currentTimeMillis();
		
		FileWriter fw = new FileWriter("Test4.dat");
		BufferedWriter bw = new BufferedWriter(fw);
	    for (int i = 0; i < vals.length; i ++){
	    	bw.write(vals[i]);
	    }
	    bw.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeByteUseDefaultBufferedWriter use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeBytesUseDefaultBufferedOutputStream(byte[] vals) throws IOException{
		long startTime = System.currentTimeMillis();
		
		FileOutputStream fout = new FileOutputStream("Test5.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fout);
		int size = 8192;
		int scope = vals.length - size;
		int i;
	    for (i = 0; i < scope; i += size){
	    	bos.write(vals, i, size);
	    }
	    bos.write(vals, i, vals.length - i);
	    bos.flush();
	    bos.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeBytesUseDefaultBufferedOutputStream use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeBytesUseDefaultBufferedWriter(byte[] vals) throws IOException{
		char[] chars = new char[vals.length];
		for (int i = 0; i < vals.length; i++){
			chars[i] = (char)vals[i];
		}
		long startTime = System.currentTimeMillis();
		
		FileWriter fw = new FileWriter("Test6.dat");
		BufferedWriter bw = new BufferedWriter(fw);
		int size = 8192;
		int scope = vals.length - size;
		int i;
	    for (i = 0; i < scope; i += size){
	    	bw.write(chars, i, size);
	    }
	    bw.write(chars, i, vals.length - i);
	    bw.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeBytesUseDefaultBufferedWriter use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeBytesUseCustomBufferedOutputStream(byte[] vals, int size) throws IOException{
		long startTime = System.currentTimeMillis();
		
		FileOutputStream fout = new FileOutputStream("Test5.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fout, size);
		int scope = vals.length - size;
		int i;
	    for (i = 0; i < scope; i += size){
	    	bos.write(vals, i, size);
	    }
	    bos.write(vals, i, vals.length - i);
	    bos.flush();
	    bos.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeBytesUseCustomBufferedOutputStream use time: "+ (endTime - startTime) +"ms");
	}
	
	public static void writeBytesUseCustomBufferedWriter(byte[] vals, int size) throws IOException{
		char[] chars = new char[vals.length];
		for (int i = 0; i < vals.length; i++){
			chars[i] = (char)vals[i];
		}
		long startTime = System.currentTimeMillis();
		
		FileWriter fw = new FileWriter("Test6.dat");
		BufferedWriter bw = new BufferedWriter(fw, size);
		int scope = vals.length - size;
		int i;
	    for (i = 0; i < scope; i += size){
	    	bw.write(chars, i, size);
	    }
	    bw.write(chars, i, vals.length - i);
	    bw.close();
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("writeBytesUseCustomBufferedWriter use time: "+ (endTime - startTime) +"ms");
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		byte[] vals = new byte[SIZE];
		for (int i = 0; i < SIZE; i++){
			vals[i] = Integer.valueOf(i).byteValue();
		}
		
//		writeByteUseFileOutputStream(vals);
//		writeByteUseFileWriter(vals);
		writeByteUseDefaultBufferedOutputStream(vals);
		writeByteUseDefaultBufferedWriter(vals);
		writeBytesUseDefaultBufferedOutputStream(vals);
		writeBytesUseDefaultBufferedWriter(vals);
		writeBytesUseCustomBufferedOutputStream(vals, CUSTOM_BUFFER_SIZE_2);
		writeBytesUseCustomBufferedWriter(vals, CUSTOM_BUFFER_SIZE_2);
		writeBytesUseCustomBufferedOutputStream(vals, CUSTOM_BUFFER_SIZE_4);
		writeBytesUseCustomBufferedWriter(vals, CUSTOM_BUFFER_SIZE_4);
		writeBytesUseCustomBufferedOutputStream(vals, CUSTOM_BUFFER_SIZE_8);
		writeBytesUseCustomBufferedWriter(vals, CUSTOM_BUFFER_SIZE_8);
	}

}
