package com.baidu.chunlei.exercise;

public class ByteDemo {

	public static void main(String[] args) {

		// 二进制负数以它正值的补码形式表达
		System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

		System.out.println("整数5取反后的二进制字符串为:" + Integer.toBinaryString(~5));

		System.out.println("整数5取反 加 1的二进制字符串为:"
				+ Integer.toBinaryString(~5 + 1));

		System.out.println("负5的二进制字符串" + Integer.toBinaryString(-5));
		System.out.println("---------------------------------------");
		
		
		//java ~ 操作符，对每个二进制位的内容求反，即1变成0，0变成1
		
		System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

		System.out.println("整数5取反后的二进制字符串为:" + Integer.toBinaryString(~5));
		
		System.out.println("---------------------------------------");
		//java & 操作符，对应的二进制位进行与操作，两个都为1才为1，其他情况均为0
		
		System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

		System.out.println("整数4的二进制字符串为:" + Integer.toBinaryString(4));
		
		System.out.println("5&4的二进制字符串为："+Integer.toBinaryString(4&5));
		
		System.out.println("---------------------------------------");
		
		//java | 操作符，对应的二进制位进行或操作，两个都为0才为0，其他情况均为1
		
		
		System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

		System.out.println("整数4的二进制字符串为:" + Integer.toBinaryString(4));
		
		System.out.println("5|4的二进制字符串为："+Integer.toBinaryString(4|5));
		
		System.out.println("---------------------------------------");
		
		//java ^ 操作符 当对应二进制位值相同，该位为0 否则为1
		
		
		System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

		System.out.println("整数4的二进制字符串为:" + Integer.toBinaryString(4));
		
		System.out.println("5^4的二进制字符串为："+Integer.toBinaryString(5^4));
		
		System.out.println("---------------------------------------");
		
		//java << 操作符，左边移动，右面填充0
		
		System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

	
		
		System.out.println("5<<4的二进制字符串为："+Integer.toBinaryString(5<<4));
		
		System.out.println("---------------------------------------");
		
		
		//java >> 操作符，左边移动，右面填充0
		
				System.out.println("整数5的二进制字符串:" + Integer.toBinaryString(5));

			
				
				System.out.println("5>>4的二进制字符串为："+Integer.toBinaryString(5>>4));
				
				System.out.println("---------------------------------------");
		
		//应用的实例
			
			System.out.println(" 5 ×2 = "+5*2);
			System.out.println(" 5 <<1 = "+ (5<<1));
			System.out.println("---------------------------------------");
			
			//这里是将字节转为整数，不是很明白。只是发现计算的结果 192+64 =256 是一个字节的长度 
			System.out.println(" -64&0xFF = "+(-64&0xFF));
			System.out.println(" 0xFF ="+Integer.parseInt("FF",16));
			
			System.out.println("---------------------------------------");
			
			
			//比较数是否相等.0表示相等，其他值表示不相等
			
			System.out.println(" 1^1 比较是否相等 ： "+(1^1));
			System.out.println(" 20 ^20 比较是否相等 ： "+ (20 ^ 20));
			System.out.println("20 ^ 1 比较是否相等:"+(20^1));
			
			System.out.println("0x65 ^ 0x65 比较是否相等:"+(0x65^0x62));
			System.out.println("---------------------------------------");
			
			//判断奇偶
			for (int i = 0; i < 50; ++i){
				
				if((i&1) == 0){
					System.out.println("发现的偶数:"+i);
				}
			}
			
			System.out.println("---------------------------------------");
			//交换2个数，不使用临时变量
			int a =3;
			int b =4;
			
			if(a != b){
				a ^= b;  
		        b ^= a;  
		        a ^= b; 
			}
			System.out.println("a ="+a);
			System.out.println("b = "+b);
			System.out.println("---------------------------------------");
			
			//变换符号
			//这里可能大家觉得没用，但是如果 a的符号我们不清楚，估计就有用了。
			System.out.println(" 7 变换符号后:"+ (~7+1));
			System.out.println(" -7 变换符号后:"+ (~-7+1));
			System.out.println("---------------------------------------");
			//计算绝对值
			System.out.println(" 7 的绝对值:"+ my_abs(7));
			System.out.println(" -7 的绝对值:"+ my_abs(-7));
			System.out.println("---------------------------------------");
			
			//  高低位交换
			
			System.out.println("34520的二进制字符串为:"+Integer.toBinaryString(34520));
			System.out.println("34520>>8的字符串:"+Integer.toBinaryString(34520>>8));
			
			System.out.println("34520<<8的字符串:"+Integer.toBinaryString(34520<<8));
			//交换 它的前 8 与后8 这里需要截取。否则超出16位。
			String str = Integer.toBinaryString( (34520>>8)|(34520<<8));
			System.out.println("34520的交换位置:"+str);
			System.out.println("34520的交换位置并只保留16位:"+str.substring(str.length()-16,str.length()).trim());
			System.out.println("---------------------------------------");
			//二进制逆序
			
			System.out.println("34520的二进制字符串为:"+Integer.toBinaryString(34520));
			a =34520;
			a = ((a & 0xAAAA) >> 1) | ((a & 0x5555) << 1);  
		    a = ((a & 0xCCCC) >> 2) | ((a & 0x3333) << 2);  
		    a = ((a & 0xF0F0) >> 4) | ((a & 0x0F0F) << 4);  
		    a = ((a & 0xFF00) >> 8) | ((a & 0x00FF) << 8);  
			
			System.out.println("34520的二进制字符串逆序后为:"+Integer.toBinaryString(a));
			System.out.println("---------------------------------------");
			//计算二进制1的个数
			
			System.out.println("34520的二进制字符串为:"+Integer.toBinaryString(34520));
			a =34520;
			a = ((a & 0xAAAA) >> 1) + ((a & 0x5555) );  
		    a = ((a & 0xCCCC) >> 2) + ((a & 0x3333) );  
		    a = ((a & 0xF0F0) >> 4) + ((a & 0x0F0F) );  
		    a = ((a & 0xFF00) >> 8) + ((a & 0x00FF) );  
			
			System.out.println("34520的二进制字符串中1的个数为:"+a);
			System.out.println("---------------------------------------");
			
			
			
			
			
			
			//查出单独的一个数字，只出现一次的数字
			int[] arr = {1, 347, 6, 9, 13, 65, 889, 712, 889, 347, 1, 9, 65, 13, 712};
			int lostNum = 0;
			for (int i = 0; i < 15; i++){
				lostNum ^= arr[i];
			}
			System.out.println("缺失的数字为:"+lostNum);	


	}
	
	//求绝对值得方法
	private static int my_abs(int a){
		int i = a>>31;
			//return i==0? a:(~a+1);
			return (a^i)-i;
		
	}

}
