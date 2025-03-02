public class ParkingHunter extends Competitor implements Cheerable, Comparable<ParkingHunter> {
    // a parkinghunter is a competitor
    private int distanceToClass;

    public ParkingHunter(String name, String surname, int age, String degree, String bio, String result) {
        super(name, surname, age, degree, bio);
        this.distanceToClass=Integer.parseInt(result.replaceAll("m", ""));

    }
    @Override
    public int compete(){

        return distanceToClass;
    }
  


    @Override
    public String toString() {

        return "Parking Spot Hunting("+distanceToClass+"): " +super.toString();
    }

    @Override
    public String cheer(){
        return "Go "+ this.name+", go! You're the best at Parking Spot Hunting!";
    }
    @Override
    public int compareTo(ParkingHunter o) {
        // TODO Auto-generated method stub



        if (this.distanceToClass < o.distanceToClass) {
            return -1;
        } else if (this.distanceToClass > o.distanceToClass) {
            return 1;
        } else {
            return 0;
        }
    }


}
