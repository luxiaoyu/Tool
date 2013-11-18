public class CodeReview {
    private CodeReview instance = new CodeReview();

    public CodeReview() {
    }

    public String getSignal(int i) {
        StringBuffer ret = null;
        switch (i % 2) {
        case 0:
            ret = new StringBuffer('O');
            break;
        case 1:
            ret = new StringBuffer('J');
            break;
        default:
            ret = new StringBuffer();
            break;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        CodeReview cr = new CodeReview();
        long microSencondPerDay = 24 * 60 * 60 * 1000 * 1000;
        System.out.println(cr.getSignal(-1) + microSencondPerDay);
    }

}
