package com.baidu.chunlei.exercise;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-9
 * @version
 * @todo 
 */

class MyObject{
	// 记录TestFinalize对象，在finalize中时用于恢复可达性
	TestFinalize main;
	
	public MyObject(TestFinalize t){
		main = t;
	}
	
	protected void finalize(){
		// 恢复当前对象，让其可达
		main.ref = this;
		// 用于测试finalize只运行一次
		System.out.println("This is finalize");
	}
}

public class TestFinalize {
	public MyObject ref;
	
	public static void main(String[] args) throws InterruptedException {
		TestFinalize test = new TestFinalize();
		test.ref = new MyObject(test);
		// MyObject对象为不可达对象，finalize将被gc调用
		test.ref = null;
		// 注意这里是请求不是调用
		System.gc();
		// 如果注释掉sleep则不会打印"MyObject is living"，说明由于GC调用finalize的时间是不确定的，
		// 因此通过这种方式释放资源也是不确定的
		Thread.sleep(1000);
		if (test.ref != null) {
			System.out.println("MyObject is living");  
		}
	}

}
