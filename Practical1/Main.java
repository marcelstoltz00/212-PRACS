public class Main {

    private static void testMark() {
        // tf test = new tf();
        TestMark tm = new TestMark(1, "22", 69);

        tf.startTestSuite("TestMark tests");

        tf.assertEquals(tm, "Test1:22(69.00)", "test if TM creates");
        tf.assertEquals(tm.next, null, "Check if next is null");
        tf.assertEquals(tm.studentNumber, "22", "studentnumber test");
        tf.assertEquals(tm.mark, 69.0, "mark");
        tf.assertEquals(tm.number, 1, "number");

        tf.printTestSummary();

    }

    private static void testGradebook() {
        // tf test = new tf();

        tf.startTestSuite("Gradebook Tests");
        tf.startTestSuite("Update mark tests");

        Gradebook g = new Gradebook();

        tf.assertNULL(g.marks, "test gradebook NULL");
        tf.assertEquals(g.toString(), "", "test to string method/empty ");
        g.updateMark(1, "A", 50);
        tf.assertEquals(g.toString(), "[1]Test1:A(50.00)", "test adding 1 mark ");
        // with new to string
        g.updateMark(1, "A", 100);// smaller test number works,different mark doent
        tf.assertEquals(g.toString(), "[2]Test1:A(100.00)->", "test adding 1 duplicate mark ");
        g.updateMark(2, "B", 71);
        tf.assertEquals(g.toString(), "[3]Test1:A(100.00)->", "test adding 1 mark ");
        g.updateMark(2, "B", 100);
        tf.assertEquals(g.toString(), "[4]Test1:A(100.00)->", "test adding 1 mark ");

        tf.startTestSuite("test removemark ");

        Gradebook gb = new Gradebook();

        gb.updateMark(1, "A", 90);
        gb.updateMark(1, "A", 99);
        gb.updateMark(2, "A", 2);
        gb.updateMark(2, "B", 22);
        gb.updateMark(1, "A", 90);
        gb.updateMark(1, "A", 99);
        gb.updateMark(2, "A", 2);
        gb.updateMark(2, "B", 22);
        // System.out.println(gb.gbtoString(gb.marks));
        gb.removeMark(1, "A");
        // System.out.println(gb.gbtoString(gb.marks));
        tf.assertEquals(gb.toString(), "[4]Test2:B(22.00)->", "remove 2");
        gb.removeMark(2, "A");
        tf.assertEquals(gb.toString(), "[2]Test2:B(22.00)->", "remove 1");
        gb.removeMark(2, "B");
        tf.assertFalse(null == gb.toString(), "NULL/should be false");

        tf.startTestSuite("test getmark");
        gb.updateMark(1, "B", 0);
        gb.updateMark(1, "A", 90);

        gb.updateMark(1, "B", 2);

        gb.updateMark(1, "A", 2);
        gb.updateMark(1, "B", 90);
        gb.updateMark(1, "A", 0);
        gb.updateMark(1, "A", 99);
        gb.updateMark(1, "B", 99);

        Double[] test = new Double[4];
        test[0] = 99.00;
        test[1] = 90.00;
        test[2] = 2.00;
        test[3] = 0.00;

        tf.assertEquals(gb.getMark(1, "A")[0], test[0], "test get mark1");
        tf.assertEquals(gb.getMark(1, "A")[1], test[1], "test get mark2");
        tf.assertEquals(gb.getMark(1, "A")[2], test[2], "test get mark3");
        tf.assertEquals(gb.getMark(1, "A")[3], test[3], "test get mark4");

        gb.removeMark(1, "A");
        gb.removeMark(1, "B");

        tf.startTestSuite("student particicpation");

        gb.updateMark(3, "A", 90);
        gb.updateMark(4, "A", 2);
        gb.updateMark(2, "A", 0);
        gb.updateMark(3, "A", 99);
        gb.updateMark(1, "A", 100);
        gb.updateMark(3, "A", 90);
        gb.updateMark(2, "A", 100);
        gb.updateMark(2, "A", 0);
        gb.updateMark(3, "A", 100);
        gb.updateMark(4, "A", 100);

        Integer[] tst = new Integer[4];
        tst[0] = 1;
        tst[1] = 2;
        tst[2] = 3;
        tst[3] = 4;

        tf.assertEquals(gb.studentParticipation("A")[0], tst[0], "first participation");
        tf.assertEquals(gb.studentParticipation("A")[1], tst[1], "first participation");
        tf.assertEquals(gb.studentParticipation("A")[2], tst[2], "first participation");
        tf.assertEquals(gb.studentParticipation("A")[3], tst[3], "first participation");

        tf.startTestSuite("student average");

        tf.assertEquals(gb.studentAverage("A"), 100.0, "testing average");

        tf.printTestSummary();

        // errors to fix : duplicate test numbers
        // : smaller test number

    }



    public static void main(String[] args) {
        // Gradebook g = new Gradebook();
        // g.updateMark(1, "u12345678", 90);
        // g.updateMark(1, "u87654321", 20);
        // g.updateMark(2, "u87654321", 30);
        // g.updateMark(2, "u12345678", 40);
        // System.out.println(g);

        testMark();
        testGradebook();
  

    }
}