public class Competitor {
    protected String name;
    private String surname;
    private int age;
    private String degree;
    private String bio;

    public Competitor(String name, String surname, int age, String degree, String bio) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.degree = degree;
        this.bio = bio;
    }

    private boolean containsGenZSlang() {
        return bio.contains("no cap");
    }

    private boolean isSpecialLength() {
        return (bio.length() == 42);
    }

    private boolean distinct(String str) {
        if (str.length() < 2) {
            return false
        }

        char first = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != first) {
                return true;
            }
        }

        return false;

    }

    private boolean isPalindrome(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return false;
        }

        String lower = str.replaceAll(" ", "");// remove spaces
        lower = lower.toLowerCase();
        if (!distinct(lower)) {
            return false;
        }
        double half = Math.ceil((lower.length() * 1.0) / 2.0);

        for (int i = 0; i < half; i++) {
            char front = lower.charAt(i);
            char back = lower.charAt(lower.length() - i - 1);

            if (front != back) {
                return false;
            }

        }
        return true;
    }

    private boolean containsPalindrome() {
        for (int i = 0; i < bio.length(); i++) {
            for (int j = i; j < bio.length(); j++) {
                String sub = bio.substring(i, j + 1);
                if (isPalindrome(bio)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean canAccept() {
        return (this.containsGenZSlang() || isSpecialLength() || containsPalindrome());

    }

    public int compete() {
        return -1;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", " + age + " (" + degree + ")";
    }

}
