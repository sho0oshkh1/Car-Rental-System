import java.util.Scanner;
public class Car 
{
      // Attributes
   private String id;
   private int startKm;
   private int endKm;
   private double kmpl;
   private boolean rented;
   
   // Methods

   public Car(String ID, int STARTKM, int  ENDKM, double KMPL, boolean RENTED) {
       id = ID;
      startKm = STARTKM;
      endKm = ENDKM;
      kmpl = KMPL;
      rented = RENTED;
   }


   public double calculateLiters()
   {
      double liters = calculateDistance()/kmpl;  
      return liters;
   }
   
   public int calculateDistance()
   {
      int distance= (Math.abs(endKm-startKm)); // the absolute method is uesed to avoid un-natural numbers --> referring to the distance
      return distance;
   }
   
   public boolean moreEconomic(Car cc)
   {
      boolean betterEconomic = this.kmpl > cc.getKmpl();
      if(betterEconomic)
         return true;
      else 
         return false; 
      
   }
   
   public void displayInfo()
   {
      System.out.printf(" | %-15s | %10d | %10d | %5.2f | %-5s | %n", id, startKm, endKm, kmpl, ((rented)?"yes":"no"));
   }
   
   // setters and getters
        //ID
   public void setId(String carID)
   { 
      id= carID;
   }
   public String getId()
   {
      return id;
   }
       //startKm
   public void setStartKm(int sKm)
   { 
      startKm= sKm;  
   }
   public int getStartKm()
   {
      return startKm;
   }
       //endKm
   public void setEndKm(int eKm)
   { 
      endKm= eKm;  
   }
   public int getEndKm()
   {
      return endKm;
   }
       //kmpl
   public void setKmpl(double KMPL)
   { 
      kmpl= KMPL;  
   }
   public double getKmpl()
   {
      return kmpl;
   } 
       //rented
   public void setRented(boolean RENTED)
   { 
      rented= RENTED;  
   }
   public boolean isRented()
   {
      return rented;
   }


}