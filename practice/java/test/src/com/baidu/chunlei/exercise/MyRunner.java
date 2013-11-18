package com.baidu.chunlei.exercise;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2011-5-19
 * @version
 * @todo 
 */
public class MyRunner {
	private static MyRunner _instance = null;
	private boolean setUpHasRun = false;
	private boolean tearDownHasRun = false;
	
	private MyRunner(){
		
	}
	
	public static MyRunner getInstance(){
		if(_instance == null){
			_instance = new MyRunner();
			return _instance;
		}
		return _instance;
	}
	
	public void setUpOnlyOnce(SetUp setup){
		if (!tearDownHasRun){
			tearDownHasRun = true;
			setup.setUp();
		}
	}
	
	public void tearDownOnlyOnce(TearDown teardown){
		if (!setUpHasRun){
			setUpHasRun = true;
			teardown.tearDown();
		}
	}
	
    public interface SetUp {
        void  setUp(); 
    } 
    
    public interface TearDown {
        void  tearDown(); 
    } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunner.getInstance().setUpOnlyOnce(new MyRunner.SetUp(){
			public void setUp(){
				System.out.println("Set up!");
			}
		});
		
		MyRunner.getInstance().tearDownOnlyOnce(new MyRunner.TearDown(){
			public void tearDown(){
				System.out.println("tearDown!");
			}
		});
		
		MyRunner.getInstance().setUpOnlyOnce(new MyRunner.SetUp(){
			public void setUp(){
				System.out.println("Set up again!");
			}
		});
		
		MyRunner.getInstance().tearDownOnlyOnce(new MyRunner.TearDown(){
			public void tearDown(){
				System.out.println("tearDown again!");
			}
		});
	}

}
