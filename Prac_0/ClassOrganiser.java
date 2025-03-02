public class ClassOrganiser extends Competitor implements Cheerable, Comparable<ClassOrganiser> {

    private String[] earlyLectures;
    private String[] fridayLectures;

    public ClassOrganiser(String name, String surname, int age, String degree, String bio, String result) {
        super(name, surname, age, degree, bio);

        String[] EL = new String[0];
        String[] FL = new String[0];
        String[] initial = result.split("\\$");
        if (result.length() == 1) {
            earlyLectures = new String[0];
            fridayLectures = new String[0];

            return;
        }

        if (result.charAt(0) == '$') {

            FL = (initial[1].split(","));

        } else {

            if (result.charAt(result.length() - 1) == '$') {
                EL = (initial[0].split(","));
            } else {
                EL = (initial[0].split(","));
                FL = (initial[1].split(","));

            }

        }

        this.earlyLectures = new String[EL.length];
        this.fridayLectures = new String[FL.length];

        for (int i = 0; i < EL.length; i+) {

            earlyLectures[i] = EL[i];

        }

        for (int i = 0; i < FL.length; i++) {

            fridayLectures[i] = FL[i];

        }

    }

    @Override
    public int compete() {
        int tw = 0;
        for (String i : earlyLectures) {

            tw += 1;

        }

        for (String j : fridayLectures) {

            tw += 1;

        }

        for (String i : earlyLectures) {

            for (String j : fridayLectures) {

                if (i == j) {
                    tw += 1;
                }

            }

        }

        return tw;
    }

    @Override
    public String toString() {
        return "Class Registration Roulette("+compete()+"): " +super.toString();
    }

    @Override
    public String cheer(){
        return "Go "+ this.name+", go! You're the best at Class Registration Roulette!";
    }

    @Override
    public int compareTo(ClassOrganiser o) {
        // TODO Auto-generated method stub

        if (this.compete() < o.compete()) {
            return -1;
        } else if (this.compete() > o.compete()) {
            return 1;
        } else {
            return 0;
        }

    }
}
