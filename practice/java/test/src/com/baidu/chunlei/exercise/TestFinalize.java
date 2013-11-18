package com.baidu.chunlei.exercise;
/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-6-9
 * @version
 * @todo 
 */

class MyObject{
	// ��¼TestFinalize������finalize��ʱ���ڻָ��ɴ���
	TestFinalize main;
	
	public MyObject(TestFinalize t){
		main = t;
	}
	
	protected void finalize(){
		// �ָ���ǰ��������ɴ�
		main.ref = this;
		// ���ڲ���finalizeֻ����һ��
		System.out.println("This is finalize");
	}
}

public class TestFinalize {
	public MyObject ref;
	
	public static void main(String[] args) throws InterruptedException {
		TestFinalize test = new TestFinalize();
		test.ref = new MyObject(test);
		// MyObject����Ϊ���ɴ����finalize����gc����
		test.ref = null;
		// ע�������������ǵ���
		System.gc();
		// ���ע�͵�sleep�򲻻��ӡ"MyObject is living"��˵������GC����finalize��ʱ���ǲ�ȷ���ģ�
		// ���ͨ�����ַ�ʽ�ͷ���ԴҲ�ǲ�ȷ����
		Thread.sleep(1000);
		if (test.ref != null) {
			System.out.println("MyObject is living");  
		}
	}

}
