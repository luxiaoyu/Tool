public class CodeReviewAnswer {
    /**
     * ���׳�java.lang.StackOverflowError���� ��ԭ����ʵ�������ĳ�ʼ�����������ڹ������ĳ���������С�
     * ��ȷд����private static CodeReviewAnswer instance = new CodeReviewAnswer();
     */
    private CodeReviewAnswer instance = new CodeReviewAnswer();

    public CodeReviewAnswer() {
    }

    public String getSignal(int i) {
        StringBuffer ret = null;
        /**
         * ��Ҫʹ�� i % 2 == 1 ���ж��Ƿ�����������ΪiΪ������ʱ�������� 
         * ��ʹ�� i % 2 != 0 ���ж��Ƿ�����������ʹ�ø�Чʽ(i & 1) != 0���жϡ�
         */
        switch (i % 2) {
        case 0:
            ret = new StringBuffer('O');
            break;
        case 1:
            /**
             * StringBuffer(char)���캯����ʵ��������ʱ���ַ���ת������int�ͣ�
             * �������ַ�����StringBuffer�ĳ�ʼ�����ˣ��������ַ����� 
             * ��ȷд����ret = new StringBuffer("J");
             */
            ret = new StringBuffer('J');
            break;
        default:
            ret = new StringBuffer();
            break;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        CodeReviewAnswer cr = new CodeReviewAnswer();
        /**
         * ��ȷ���ӦΪ��86400000000 ʵ����Ϊ��500654080
         * �������ڼ������������ˡ��������ʽ��ȫ����int������ִ�еģ�����ֻ�����������֮��
         * �������ű�����Ϊlong������ʱ�Ѿ�̫�٣������Ѿ������
         * ��ȷд����long microSencond = 24L * 60 * 60 * 1000 * 1000;
         */
        long microSencondPerDay = 24 * 60 * 60 * 1000 * 1000;
        System.out.println(cr.getSignal(-1) + microSencondPerDay);
    }

}
