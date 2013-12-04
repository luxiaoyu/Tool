package com.baidu.chunlei.exercise;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2013-12-4
 * @version
 * @todo
 */
public class IMEICreator {

    /** 
     * imei��15λ������ɣ� 
     * ǰ6λ(TAC)���ͺź�׼���룬�����ֻ����͡� 
     * ����2λ(FAC)�����װ��ţ�������ء� 
     * ��6λ(SNR)�Ǵ��ţ���������˳��š� 
     * ���1λ (SP)�Ǽ����롣  
     *  
     * ��������㣺 
     * (1).��ż��λ���ֱַ����2���ֱ�����λ����ʮλ��֮�� 
     * (2).������λ������ӣ��ټ�����һ����õ�ֵ 
     * (3).����ó�������λ��0��У��λΪ0������Ϊ10��ȥ��λ�� 
     *  
     * @author sonzer 
     *  
     */
    public static void main(String[] args) {
        String imeiString = "35566778898256";//ǰ14λ  
        char[] imeiChar = imeiString.toCharArray();
        int resultInt = 0;
        for (int i = 0; i < imeiChar.length; i++) {
            int a = Integer.parseInt(String.valueOf(imeiChar[i]));
            i++;
            final int temp = Integer.parseInt(String.valueOf(imeiChar[i])) * 2;
            final int b = temp < 10 ? temp : temp - 9;
            resultInt += a + b;
        }
        resultInt %= 10;
        resultInt = resultInt == 0 ? 0 : 10 - resultInt;
        System.out.println("imei:" + imeiString + resultInt);
    }

}
