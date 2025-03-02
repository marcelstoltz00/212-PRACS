public class tf{
    // ANSI color codes for terminal output
    private static final String ANSI_RED = "\u001b[31;1m";
    private static final String ANSI_GREEN = "\u001b[32;1m";
    private static final String ANSI_YELLOW = "\u001b[33;1m";
    private static final String ANSI_RESET = "\u001b[0m";

    // Test tracking variables
    private static int testsRun = 0;
    private static int testsPassed = 0;
    private static String currentTestSuite = "";

    /**
     * Start a new test suite
     * @param suiteName Name of the test suite
     */
    public static void startTestSuite(String suiteName) {
        currentTestSuite = suiteName;
        System.out.println("\n" + ANSI_YELLOW + "========== Starting Test Suite: " + suiteName + " ==========" + ANSI_RESET);
    }

    /**
     * Generic assertEquals method for comparing any two objects
     * @param actual The actual value
     * @param expected The expected value
     * @param testName Name/description of the test
     */
    public static <T> void assertEquals(T actual, T expected, String testName) {
        testsRun++;
        String testInfo = currentTestSuite.isEmpty() ? testName : currentTestSuite + " - " + testName;
        
        if (actual == expected || (actual != null && actual.equals(expected))) {
            testsPassed++;
            System.out.println(ANSI_GREEN + "✓ PASSED: " + testInfo + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "✗ FAILED: " + testInfo);
            System.out.println("  Expected: [" + expected + "]");
            System.out.println("  Actual:   [" + actual + "]" + ANSI_RESET);
        }
    }

    /**
     * Assert that a condition is true
     * @param condition The condition to test
     * @param testName Name/description of the test
     */
    public static void assertTrue(boolean condition, String testName) {
        assertEquals(condition, true, testName);
    }

    /**
     * Assert that a condition is false
     * @param condition The condition to test
     * @param testName Name/description of the test
     */
    public static void assertFalse(boolean condition, String testName) {
        assertEquals(condition, false, testName);
    }

    public static void assertNULL(Object actual, String testName) {
        testsRun++;
        String testInfo = currentTestSuite.isEmpty() ? testName : currentTestSuite + " - " + testName;
        
        if (actual == null) {
            testsPassed++;
            System.out.println(ANSI_GREEN + "✓ PASSED: " + testInfo + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "✗ FAILED: " + testInfo);
            System.out.println("  Expected: [null]");
            System.out.println("  Actual:   [" + actual + "]" + ANSI_RESET);
        }
    }

    /**
     * Print the final test summary
     */
    public static void printTestSummary() {
        System.out.println("\n" + ANSI_YELLOW + "========== TEST SUMMARY ==========" + ANSI_RESET);
        System.out.println("Total Tests Run: " + testsRun);
        System.out.println("Tests Passed: " + ANSI_GREEN + testsPassed + ANSI_RESET);
        System.out.println("Tests Failed: " + ANSI_RED + (testsRun - testsPassed) + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "================================" + ANSI_RESET + "\n");
    }
}