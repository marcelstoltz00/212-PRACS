public class TestMark {
    public int number;// test number for specific mark
    public String studentNumber;// student number for this specific mark
    public double mark;// the actual mark the student achieved for this test

    public TestMark next;

    public TestMark(int number, String studentNumber, double mark) {

        this.number = number;
        this.studentNumber = studentNumber;
        this.mark = mark;

    }

    @Override
    public String toString() {

        // Two decimal digits
        // result = String.format("%.2f", myNumber);
        // System.out.println(result);

        String str = "Test" + number + ":" + studentNumber + "(" + String.format("%.2f", mark) + ")";

        if (next!=null){

            str+="->";
            str+=next.toString();
        }




        return str;

    }

}
