public class CodeReviewAnswer {
    /**
     * 会抛出java.lang.StackOverflowError错误。 其原因是实例变量的初始化操作将先于构造器的程序体而运行。
     * 正确写法：private static CodeReviewAnswer instance = new CodeReviewAnswer();
     */
    private CodeReviewAnswer instance = new CodeReviewAnswer();

    public CodeReviewAnswer() {
    }

    public String getSignal(int i) {
        StringBuffer ret = null;
        /**
         * 不要使用 i % 2 == 1 来判断是否是奇数，因为i为负奇数时不成立， 
         * 请使用 i % 2 != 0 来判断是否是奇数，或使用高效式(i & 1) != 0来判断。
         */
        switch (i % 2) {
        case 0:
            ret = new StringBuffer('O');
            break;
        case 1:
            /**
             * StringBuffer(char)构造函数，实质上运行时将字符型转换成了int型，
             * 这样将字符当作StringBuffer的初始容量了，而不是字符本身。 
             * 正确写法：ret = new StringBuffer("J");
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
         * 正确结果应为：86400000000 实际上为：500654080
         * 问题在于计算过程中溢出了。这个计算式完全是以int运算来执行的，并且只有在运算完成之后
         * ，其结果才被提升为long，而此时已经太迟：计算已经溢出。
         * 正确写法：long microSencond = 24L * 60 * 60 * 1000 * 1000;
         */
        long microSencondPerDay = 24 * 60 * 60 * 1000 * 1000;
        System.out.println(cr.getSignal(-1) + microSencondPerDay);
    }

}
