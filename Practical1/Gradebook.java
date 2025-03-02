public class Gradebook {
    public TestMark marks;// null if there are no marks

    public Gradebook() {
        marks = null;// no marks
    }

    @Override
    public String toString() {

        if (marks != null) {
            return "[" + count(marks) + "]" + marks.toString();

        } else
            return "";

    }

    public static int count(TestMark tm) {

        if (tm == null) {

            return 0;
        } else {

            return 1 + count(tm.next);

        }

    }

    public void updateMark(int number, String studentNumber, double mark) {
        // sort by test number first
        // sort smaller test number,earlier in the gradebook
        // then sort by marks
        // sort higher test mark,earlier in the gradebook

        this.marks = updateMark(number, studentNumber, mark, marks);

        // if (marks == null) {

        // if (mark < 0) {

        // return;
        // }

        // marks = new TestMark(number, studentNumber, mark);
        // return;// working

        // } else {// not head

        // TestMark insert = new TestMark(number, studentNumber, mark);// working

        // helperUpdate(marks, insert, null);

        // }

        // if both are the same,put it in the back(duplicates are allowed)

    }

    public TestMark updateMark(int number, String studentNumber, double mark, TestMark head) {
        if (mark < 0)
            return head;// if it doesnt exist why bother?
        TestMark tm = new TestMark(number, studentNumber, mark);
        return updateHelper(head, tm);
    }

    private TestMark updateHelper(TestMark cur, TestMark tm) {
        if (cur == null)
            return tm;// base case

        if (tm.number < cur.number) {// check test number,if less then we can continue by adding it in front
            tm.next = cur;
            return tm;
        }

        if (tm.number == cur.number) {// if its the same check mark,then we add before or after
            if (tm.mark > cur.mark) {
                tm.next = cur;
                return tm;
            }
            cur.next = updateHelper(cur.next, tm);
            return cur;
        }

        cur.next = updateHelper(cur.next, tm);
        return cur;
    }

    public void removeMark(int number, String studentNumber) {
        marks = removeMarkRecursive(marks, number, studentNumber);
    }

    private TestMark removeMarkRecursive(TestMark tm, int number, String studentNumber) {

        if (tm == null) {
            return null;
        }

        // work backwards technically,try going back all the way before removing
        // ensures that we dont have any floating pointers (not that java needs it
        // compared to c++)
        tm.next = removeMarkRecursive(tm.next, number, studentNumber);

        if (tm.number == number && tm.studentNumber.equals(studentNumber)) {
            return tm.next;
        }

        return tm;
    }

    private static Double[] sort(Double[] marks, int i, int n, boolean descending) {// sort descending order
        if (n == 1)
            return marks;
        if (descending) {
            if (i < n - 1) {
                if (marks[i] < marks[i + 1]) {
                    Double copy = marks[i];
                    marks[i] = marks[i + 1];
                    marks[i + 1] = copy;
                }

                sort(marks, i + 1, n, descending);
            } else {

                sort(marks, 0, n - 1, descending);
            }
            return marks;
        } else {
            if (i > n - 1) {
                if (marks[i] < marks[i + 1]) {
                    Double copy = marks[i];
                    marks[i] = marks[i + 1];
                    marks[i + 1] = copy;
                }

                sort(marks, i + 1, n, descending);
            } else {

                sort(marks, 0, n - 1, descending);
            }
            return marks;

        }
    }

    private Double[] collect(Double[] array, int number, String studentNumber, TestMark markssss, int count) {// sort
                                                                                                              // descedning
        // order

        if (markssss == null) {

            return array;
        } else {

            if (markssss.studentNumber == studentNumber && markssss.number == number) {
                array[count] = markssss.mark;
                count++;

            }

            return collect(array, number, studentNumber, markssss.next, count);

        }

    }

    private int collect(Integer[] array, String studentNumber, TestMark markssss, int count, int prevTest) {// sort
        // descedning
        // order

        if (markssss == null) {

            return count;
        } else {

            if (markssss.studentNumber.equals(studentNumber) && markssss.number != prevTest) {
                array[count] = markssss.number;
                count++;
                return collect(array, studentNumber, markssss.next, count, markssss.number);

            }

            return collect(array, studentNumber, markssss.next, count, markssss.number);

        }

    }

    private static Integer count(int counting, int number, String studentNumber, TestMark marks) {
        if (marks == null) {

            return counting;
        } else {
            if (marks.studentNumber == studentNumber && marks.number == number) {
                counting += 1;

                return count(counting, number, studentNumber, marks.next);

            } else {

                return count(counting, number, studentNumber, marks.next);

            }

        }

    }

    private static Integer count(int counting, String studentNumber, TestMark marks) {
        if (marks == null) {

            return counting;
        } else {
            if (marks.studentNumber == studentNumber) {
                counting += 1;

                return count(counting, studentNumber, marks.next);

            } else {

                return count(counting, studentNumber, marks.next);

            }

        }

    }

    public Double[] getMark(int number, String studentNumber) {
        // retrieve
        // count first
        int count = count(0, number, studentNumber, marks);
        Double[] markss = new Double[count];

        collect(markss, number, studentNumber, marks, 0);

        // sort
        return sort(markss, 0, count, true);

    }

    public Integer[] studentParticipation(String studentNumber) {

        int count = count(0, studentNumber, marks);
        Integer[] markss = new Integer[count];
        collect(markss, studentNumber, marks, 0, -1);

        return markss;

    }

    private Integer[] avgHelper(TestMark markssss, String studentnumber, int total, int count, int prevTest) {
        if (markssss == null) {

            return new Integer[] { total, count };

        }

        if (markssss.studentNumber.equals(studentnumber) && markssss.number != prevTest) {

            total += markssss.mark;
            count++;
            return avgHelper(markssss.next, studentnumber, total, count, markssss.number);

        }

        return avgHelper(markssss.next, studentnumber, total, count, prevTest);

    }

    public double studentAverage(String studentNumber) {

        Integer[] avg = avgHelper(marks, studentNumber, 0, 0, -1);
        double average = avg[0] / avg[1];
        // best mark

        // function for finding all tests

        // sort first
        // then run recursively
        // taking only top,until it changes

        // put it in arrays

        return average;

        // }
    }
}