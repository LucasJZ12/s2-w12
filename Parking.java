public class Parking {
  private int curbLength=5;//so it fits this number of cars if parked perfectly

  public Parking(){
    int numCars=park(curbLength);
    System.out.println(numCars);
    simulation(100);
  }
  
  //this counts the number of cars that will fit in the
  //curbLength if parked randomly
  //YOU -- WHAT IS THE BASE CASE? Recursive Case? 
  //HINT it is similar to the double recursive call we did in class
  public int park(double space){
    if(space<1) 
      return 0;
    else{
      double x = Math.random()*space;
      return park(x) + 1 + park(space - (x+1));
    }
  }

  public void simulation(int times){
    int totalCars=0;
    for(int x = 0; x < times; x++){
        int c = park(curbLength);
        System.out.println(c); //this should never be greater than curbLength - yes?
        totalCars+=c;
    }
    System.out.println("Average Number of Cars: " + totalCars*1.0/times);
  }
public static void main(String[] args) {
  Parking p = new Parking();
}
}