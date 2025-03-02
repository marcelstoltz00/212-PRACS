public class TextbookLifter extends Competitor implements Cheerable, Comparable<TextbookLifter> {

    private int[] normalBooks;
    private int[] outdatedBooks;

    public TextbookLifter(String name, String surname, int age, String degree, String bio, String result) {
        super(name, surname, age, degree, bio);
        String[] normalBooksStr = new String[0];
        String[] outdatedBooksStr = new String[0];
        String[] initial = result.split("\\$");
        if (result.length() == 1){
        normalBooks = new int[0];
        outdatedBooks= new int[0];

            return;}

        if (result.charAt(0) == '$') {

            outdatedBooksStr = (initial[1].split(","));

        } else {

            if (result.charAt(result.length() - 1) == '$') {
                normalBooksStr = (initial[0].split(","));
            } else {
                normalBooksStr = (initial[0].split(","));
                outdatedBooksStr = (initial[1].split(","));

            }

        }

        this.normalBooks = new int[normalBooksStr.length];
        this.outdatedBooks = new int[outdatedBooksStr.length];

        for (int i = 0; i < normalBooksStr.length; i++) {

            normalBooks[i] = Integer.parseInt(normalBooksStr[i].replace("kg", ""));

        }

        for (int i = 0; i < outdatedBooksStr.length; i++) {

            outdatedBooks[i] = Integer.parseInt(outdatedBooksStr[i].replace("kg", ""));

        }

    }

    @Override
    public int compete() {
        int tw = 0;
        for (int i : normalBooks) {

            tw += i;

        }

        for (int i : outdatedBooks) {

            tw += 2 * i;

        }

        return tw;
    }

    @Override
    public String toString() {
        return "Textbook Weightlifting("+compete()+"): " +super.toString();
    }

    @Override
    public String cheer(){
        return "Go "+ this.name+", go! You're the best at Textbook Weightlifting!";
    }

    @Override
    public int compareTo(TextbookLifter o) {
        
       
        if (this.compete() < o.compete()) {
            return -1;
        } else if (this.compete() > o.compete()) {
            return 1;
        } else {
            return 0;
        }
    }


    

}
