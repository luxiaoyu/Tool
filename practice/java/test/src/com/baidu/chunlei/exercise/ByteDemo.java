package com.baidu.chunlei.exercise;

public class ByteDemo {

	public static void main(String[] args) {

		// �����Ƹ���������ֵ�Ĳ�����ʽ���
		System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

		System.out.println("����5ȡ����Ķ������ַ���Ϊ:" + Integer.toBinaryString(~5));

		System.out.println("����5ȡ�� �� 1�Ķ������ַ���Ϊ:"
				+ Integer.toBinaryString(~5 + 1));

		System.out.println("��5�Ķ������ַ���" + Integer.toBinaryString(-5));
		System.out.println("---------------------------------------");
		
		
		//java ~ ����������ÿ��������λ�������󷴣���1���0��0���1
		
		System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

		System.out.println("����5ȡ����Ķ������ַ���Ϊ:" + Integer.toBinaryString(~5));
		
		System.out.println("---------------------------------------");
		//java & ����������Ӧ�Ķ�����λ�����������������Ϊ1��Ϊ1�����������Ϊ0
		
		System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

		System.out.println("����4�Ķ������ַ���Ϊ:" + Integer.toBinaryString(4));
		
		System.out.println("5&4�Ķ������ַ���Ϊ��"+Integer.toBinaryString(4&5));
		
		System.out.println("---------------------------------------");
		
		//java | ����������Ӧ�Ķ�����λ���л������������Ϊ0��Ϊ0�����������Ϊ1
		
		
		System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

		System.out.println("����4�Ķ������ַ���Ϊ:" + Integer.toBinaryString(4));
		
		System.out.println("5|4�Ķ������ַ���Ϊ��"+Integer.toBinaryString(4|5));
		
		System.out.println("---------------------------------------");
		
		//java ^ ������ ����Ӧ������λֵ��ͬ����λΪ0 ����Ϊ1
		
		
		System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

		System.out.println("����4�Ķ������ַ���Ϊ:" + Integer.toBinaryString(4));
		
		System.out.println("5^4�Ķ������ַ���Ϊ��"+Integer.toBinaryString(5^4));
		
		System.out.println("---------------------------------------");
		
		//java << ������������ƶ����������0
		
		System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

	
		
		System.out.println("5<<4�Ķ������ַ���Ϊ��"+Integer.toBinaryString(5<<4));
		
		System.out.println("---------------------------------------");
		
		
		//java >> ������������ƶ����������0
		
				System.out.println("����5�Ķ������ַ���:" + Integer.toBinaryString(5));

			
				
				System.out.println("5>>4�Ķ������ַ���Ϊ��"+Integer.toBinaryString(5>>4));
				
				System.out.println("---------------------------------------");
		
		//Ӧ�õ�ʵ��
			
			System.out.println(" 5 ��2 = "+5*2);
			System.out.println(" 5 <<1 = "+ (5<<1));
			System.out.println("---------------------------------------");
			
			//�����ǽ��ֽ�תΪ���������Ǻ����ס�ֻ�Ƿ��ּ���Ľ�� 192+64 =256 ��һ���ֽڵĳ��� 
			System.out.println(" -64&0xFF = "+(-64&0xFF));
			System.out.println(" 0xFF ="+Integer.parseInt("FF",16));
			
			System.out.println("---------------------------------------");
			
			
			//�Ƚ����Ƿ����.0��ʾ��ȣ�����ֵ��ʾ�����
			
			System.out.println(" 1^1 �Ƚ��Ƿ���� �� "+(1^1));
			System.out.println(" 20 ^20 �Ƚ��Ƿ���� �� "+ (20 ^ 20));
			System.out.println("20 ^ 1 �Ƚ��Ƿ����:"+(20^1));
			
			System.out.println("0x65 ^ 0x65 �Ƚ��Ƿ����:"+(0x65^0x62));
			System.out.println("---------------------------------------");
			
			//�ж���ż
			for (int i = 0; i < 50; ++i){
				
				if((i&1) == 0){
					System.out.println("���ֵ�ż��:"+i);
				}
			}
			
			System.out.println("---------------------------------------");
			//����2��������ʹ����ʱ����
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
			
			//�任����
			//������ܴ�Ҿ���û�ã�������� a�ķ������ǲ���������ƾ������ˡ�
			System.out.println(" 7 �任���ź�:"+ (~7+1));
			System.out.println(" -7 �任���ź�:"+ (~-7+1));
			System.out.println("---------------------------------------");
			//�������ֵ
			System.out.println(" 7 �ľ���ֵ:"+ my_abs(7));
			System.out.println(" -7 �ľ���ֵ:"+ my_abs(-7));
			System.out.println("---------------------------------------");
			
			//  �ߵ�λ����
			
			System.out.println("34520�Ķ������ַ���Ϊ:"+Integer.toBinaryString(34520));
			System.out.println("34520>>8���ַ���:"+Integer.toBinaryString(34520>>8));
			
			System.out.println("34520<<8���ַ���:"+Integer.toBinaryString(34520<<8));
			//���� ����ǰ 8 ���8 ������Ҫ��ȡ�����򳬳�16λ��
			String str = Integer.toBinaryString( (34520>>8)|(34520<<8));
			System.out.println("34520�Ľ���λ��:"+str);
			System.out.println("34520�Ľ���λ�ò�ֻ����16λ:"+str.substring(str.length()-16,str.length()).trim());
			System.out.println("---------------------------------------");
			//����������
			
			System.out.println("34520�Ķ������ַ���Ϊ:"+Integer.toBinaryString(34520));
			a =34520;
			a = ((a & 0xAAAA) >> 1) | ((a & 0x5555) << 1);  
		    a = ((a & 0xCCCC) >> 2) | ((a & 0x3333) << 2);  
		    a = ((a & 0xF0F0) >> 4) | ((a & 0x0F0F) << 4);  
		    a = ((a & 0xFF00) >> 8) | ((a & 0x00FF) << 8);  
			
			System.out.println("34520�Ķ������ַ��������Ϊ:"+Integer.toBinaryString(a));
			System.out.println("---------------------------------------");
			//���������1�ĸ���
			
			System.out.println("34520�Ķ������ַ���Ϊ:"+Integer.toBinaryString(34520));
			a =34520;
			a = ((a & 0xAAAA) >> 1) + ((a & 0x5555) );  
		    a = ((a & 0xCCCC) >> 2) + ((a & 0x3333) );  
		    a = ((a & 0xF0F0) >> 4) + ((a & 0x0F0F) );  
		    a = ((a & 0xFF00) >> 8) + ((a & 0x00FF) );  
			
			System.out.println("34520�Ķ������ַ�����1�ĸ���Ϊ:"+a);
			System.out.println("---------------------------------------");
			
			
			
			
			
			
			//���������һ�����֣�ֻ����һ�ε�����
			int[] arr = {1, 347, 6, 9, 13, 65, 889, 712, 889, 347, 1, 9, 65, 13, 712};
			int lostNum = 0;
			for (int i = 0; i < 15; i++){
				lostNum ^= arr[i];
			}
			System.out.println("ȱʧ������Ϊ:"+lostNum);	


	}
	
	//�����ֵ�÷���
	private static int my_abs(int a){
		int i = a>>31;
			//return i==0? a:(~a+1);
			return (a^i)-i;
		
	}

}
