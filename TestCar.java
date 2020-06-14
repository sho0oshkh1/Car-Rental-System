import java.util.Scanner;
 
public class TestCar{
  
   public static Scanner keyboard = new Scanner (System.in);
   public static int numOfCars=0;
   private static Car rentalCars[]= new Car [100];
  
   public static void main(String[]args){
   
     
      rentalCars[numOfCars++] = new Car("Mazda", 12000 , 12500 , 15.7 , false);
      rentalCars[numOfCars++] = new Car("Honda", 10100  , 10500 , 16.0 , false);
      rentalCars[numOfCars++] = new Car("Mercedes", 5700, 6070  , 12.4 , false);
      rentalCars[numOfCars++] = new Car("Nissan", 13200 , 0 , 15.2 , true);
      rentalCars[numOfCars++] = new Car("BMW", 9800, 10200 , 12.1 , false);
      rentalCars[numOfCars++] = new Car("Fiat", 11400 , 11780 , 16.3 , false);
      rentalCars[numOfCars++] = new Car("Lexus", 4300 , 5000 , 14.7, false);
      rentalCars[numOfCars++] = new Car("Volvo", 8250 , 0 , 16.8  , true);
      rentalCars[numOfCars++] = new Car("Ferrari", 4300, 0 , 10.4  , true);
      rentalCars[numOfCars++] = new Car("Kia", 15100 , 15300 , 17.2  , false);
      
      
      
      System.out.println("which car has lower km standing BMW or Lexus? " + minimumKm(rentalCars[4], rentalCars[6]));
      System.out.println("which car travelled less during its last rental: BMW or Lexus? " + minimumDistance(rentalCars[4], rentalCars[6]));
      System.out.println("which car has lower km standing Volvo or Lexus? " + minimumKm(rentalCars[7], rentalCars[6]));
      System.out.println("which car travelled less during its last rental: Volvo or Lexus? " + minimumDistance(rentalCars[7], rentalCars[6]));
      
      int menu;
   
         
      do{
        
         System.out.println("CAR RENTAL SYSTEM\n" + "SELECT WICH NUMBER YOU WANT ROM THE MENU");
      
         System.out.println("1)Add a new car \n" + "2)Rent out a car\n" + "3)Accept a returned car\n" + "4)Display car info\n" + "5)Display company status\n" + "6)Exit");
         menu = keyboard.nextInt();
         keyboard.nextLine();
      
         switch (menu) {
         
            case 1:                                                  
               addCar();
               break;
            case 2:
               rentCar();
               break;
            case 3:
               returnCar();
               break;
            case 4:
               displayCarInfo();
               break;
            case 5:
               displayCompanyStatus();
               break;
            case 6:
               exit();
               break;
            default:
               System.out.println("Error:Invalid number");
         
         }
      } while(menu != 6);
   }


   public static String minimumKm(Car one, Car two){
   
      String id;
      int mkmCar1;
      int mkmCar2;
    
      if(one.isRented()) 
         mkmCar1 = one.getStartKm();
      
      else 
         mkmCar1 = one.getEndKm();
      
      if (two.isRented()) 
         mkmCar2 = two.getStartKm();
       
      else 
         mkmCar2 = two.getEndKm();
   
      if (mkmCar1 < mkmCar2) 
         id = one.getId();
       
      else 
         id = two.getId();
     
     
      return id;
   }
   
   
   
   public static String minimumDistance(Car one, Car two) {
   
      String id;
      if (one.isRented() || two.isRented()){
         return "Unidentified";
      }
   
      if (one.calculateDistance() < two.calculateDistance()) 
         
         return two.getId();
      
      
      else 
         return two.getId();
      
   
   
   }
   
   
   
   
   public static void addCar(){
   
      System.out.println("Enter the id for the car : ");
      String id = keyboard.nextLine();
      for (int i = 0; i < numOfCars; i++) {
         {
            if (id.equalsIgnoreCase(rentalCars[i].getId())) {
               System.out.println("This ID is aldeady there");
               return;
            }
         }
      }
      System.out.println("Enter fuel economy in(kmPl): ");
      double fuel = keyboard.nextDouble();
      rentalCars[numOfCars++] = new Car(id, 0, 0, fuel, false);
   
   }
   
   
   
   
   public static void rentCar() {
   
      System.out.println("Enter the ID of the car you want to rent: ");
      String id = keyboard.nextLine();
      boolean found = false;
      int i;
      for (i = 0; i < numOfCars; i++) {   
         {
            if (id.equalsIgnoreCase(rentalCars[i].getId())) {
               found = true;
               break;
            }
         }
      }
      if (!found) {
         System.out.println("invalid ID");
         return;
      } 
      else if (rentalCars[i].isRented()) {
         System.out.println("The car is rented");
         
         return;
      } 
      else {
         rentalCars[i].setStartKm(rentalCars[i].getEndKm());
         rentalCars[i].setEndKm(0);
         rentalCars[i].setRented(true);
         rentalCars[i].displayInfo();
         System.out.println("The car is ready for rental");
      }
   
   }
    
    
    
    
    
   public static void returnCar() {
   
      System.out.println("Enter the ID of the car you want to return: ");
   
      String id = keyboard.nextLine();
   
      boolean found = false;
      int i;
      for (i = 0; i < numOfCars; i++) {
         {
            if (id.equalsIgnoreCase(rentalCars[i].getId())) {
               found = true;
               break;
            }
         }
      }
      if (!found) {
         System.out.println("invalid ID");
         return;
      } 
      else 
      
         if (!rentalCars[i].isRented()) {
            System.out.println("the car is already available");
         
            return;
         } 
         
         else {
         
            System.out.println("Enter the end Km :");
            int endKm = keyboard.nextInt();          
            while (endKm < rentalCars[i].getStartKm()) {
            
               System.out.println("Re-enter the end Km");
               endKm =  keyboard.nextInt();
            }
         
            rentalCars[i].setEndKm(endKm);
            rentalCars[i].setRented(false);
         
         
            rentalCars[i].displayInfo();
         
            System.out.println("travelled distance: " + rentalCars[i].calculateDistance());
         
            System.out.printf("Fuel was consumed : %.2f%n", rentalCars[i].calculateLiters());
         
         }
   }
   
   
   
   
   
   
   
   
   
   
   public static void displayCarInfo() {
   
      System.out.println("Enter the ID of the car to display its information: ");
      String id = keyboard.nextLine();
      boolean found = false;
      int i;
      for (i = 0; i < numOfCars; i++) {
      
         if (id.equalsIgnoreCase(rentalCars[i].getId())) {
            found = true;
            break;
         }
      
      }
      if (!found) {
         System.out.println("invalid ID");
         return;
      
      } else {
         rentalCars[i].displayInfo();
      }
   
   }

   
   
   
   public static void displayCompanyStatus() {
   
      int rentedCars = 0;
      int availableCars = 0;
   
      for (int i = 0; i < numOfCars; i++) {
         if (rentalCars[i].isRented()) {
            rentedCars++;
         } else {
            availableCars++;
         }
      
      }
      System.out.printf("The number of cars in the company :%d ,Number of rented cars : %d ,Number of available cars : %d .%n", numOfCars, rentedCars, availableCars);
      System.out.printf("| %-15s | %12s | %12s |%11s| %-5s|%n", "Make (ID)", "start KM", "end KM", "(km/l)", "rented");
      for (int i = 0; i < numOfCars; i++) {
         rentalCars[i].displayInfo();
      }
   
      System.out.println("The ID of the best fuel economy car is :" + bestFuelEconomy());
   
   }
   
   
   
   
   private static String bestFuelEconomy() {
      int bestEconomy = 0;
   
      for (int i = 0; i < numOfCars; i++) {
         if (rentalCars[i].moreEconomic(rentalCars[bestEconomy])) {
            bestEconomy = i;
         }
      }
      return rentalCars[bestEconomy].getId();
   
   }

   
   
   
   public static void exit() {
   
      System.out.println("All info will be lost. Are you sure you want to exit? (Yes/No)");
      String answer = keyboard.next();
      if (answer.equalsIgnoreCase("yes")) {
         System.out.println("Thank you for using the car rental system ");
         System.exit(0);
      
      }
      return;
   
   }
  
  
}
