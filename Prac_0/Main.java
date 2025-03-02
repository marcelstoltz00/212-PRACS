public class Main {

     public static void main(String[] args) {
          // Create instance of class to test
          Task1And2 tester = new Task1And2();

          // Start GenZ Slang test suite
          tf.startTestSuite("GenZ Slang Tests");
          tf.assertEquals(tester.containsGenZSlang("no cap"), true, "Check for 'no cap'");
          tf.assertEquals(tester.containsGenZSlang("fr fr"), true, "Check for 'fr fr'");
          tf.assertEquals(tester.containsGenZSlang("hello"), false, "Non-slang word test");

          // Start Palindrome test suite
          tf.startTestSuite("Palindrome Tests");
          tf.assertEquals(tester.containsPalindrome("race car"), true, "Valid palindrome");
          tf.assertEquals(tester.containsPalindrome("hello"), false, "Non-palindrome");

          // Print test summary
          tf.printTestSummary();

          testOrderedList();

     }private static void testOrderedList() {

     tf.startTestSuite("Node Tests");
     Node<Integer> n = new Node<Integer>(5);
     Node<Integer> n2 = new Node<Integer>(3);
     n.next = n2;
     tf.assertEquals(n.data, 5, "check data of frist node");
     tf.assertEquals(n.next, n2, "check if next is working");

     Node<Integer> n3= new Node<Integer>(14);
     tf.assertNULL(n3.data, "check if data is null");


     OrderedList<Integer> list = new OrderedList<>();
     list.insert(5);
     list.insert(3);
     list.insert(7);
     list.insert(1);
     list.insert(9);
     list.insert(2);          
     list.insert(6);
     list.insert(8);
     list.insert(4);

     tf.startTestSuite("OrderedList Tests");
     tf.assertEquals(list.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9", "Check order of list");
     tf.assertEquals(list.head.data, 1, "Check head of list");
     tf.assertEquals(list.head.next.next.next.data, 4, "Check fourth element of list");
     tf.assertEquals(list.head.next.next.next.next.next.data, 6, "Check sixth element of list");
     tf.assertEquals(list.head.next.next.next.next.next.next.next.next.data, 9,
               "Check last element of list");
     tf.assertEquals(list.head.next.next.next.next.next.next.next.next.next, null, "Check end of list");

     tf.printTestSummary();

};

}

