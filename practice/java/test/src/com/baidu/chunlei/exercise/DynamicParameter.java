package com.baidu.chunlei.exercise;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-1-15
 * @version
 * @todo 
 */
public class DynamicParameter {
	static void sendAction(Object... args) {
		System.out.println("args.length:" + args.length);
		
		//action
		String action = (String)args[0];
		System.out.println(action);
		
		//timeout
		int timeout = (Integer)args[1];
		System.out.println(timeout);
		String [] data = (String [])args[2];
		for(String str:data){
			System.out.print(str + "  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		String _imgFilename = "123";
//		_imgFilename.substring(_imgFilename.lastIndexOf(File.separator));
		String[] data = {"0", "1", "2", "3", "4"};
		DynamicParameter.sendAction("1", 2, data);
	}
}
