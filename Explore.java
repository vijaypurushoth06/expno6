//UsedCarException Class 
  
 public class UsedCarException extends Exception { 
   
   
     public UsedCarException( String vinNum) 
     { 
         super("Wrong info entered"); 
     } 
 } 
  
  
 //UsedCar Class 
  
 public class UsedCar { 
   
     private String vinNum; 
     private String make; 
     private int year; 
     private double mileage; 
     private double price; 
       
     public UsedCar( String vinNum, String make, int year, double mileage, double price ) throws UsedCarException 
     { 
         //throws exception if VIN is less that 4 digits long 
         if( vinNum.length() < 4 ){ 
             throw( new UsedCarException(vinNum));    
         } 
         else{ 
             this.getVinNum(); 
         } 
   
         //throws exception if make is not on approved list 
         if( make.equalsIgnoreCase("Ford") || make.equalsIgnoreCase("Honda") || make.equalsIgnoreCase("Toyota") || make.equalsIgnoreCase("Chrysler") || make.equalsIgnoreCase("Other"  )){ 
             throw( new UsedCarException(vinNum)); 
         } 
         else{ 
             this.getMake(); 
         } 
   
         //throws exception if year is not 1990-2014 
         if( year < 1989 || year > 2015 ){ 
             throw( new UsedCarException(vinNum)); 
         } 
         else{ 
             this.getYear(); 
         } 
           
         //throws exception if mileage is negative 
         if( mileage < 0 ){ 
             throw( new UsedCarException(vinNum)); 
         } 
         else{ 
             this.getMileage(); 
         } 
           
         // throws exception if price is a negative number 
         if( price < 0 ){ 
             throw( new UsedCarException(vinNum)); 
         } 
         else{ 
             this.getPrice(); 
         } 
     } 
      
     
    //ThrowUsedCarException (Main) Class 
     
     import java.util.Scanner; 
 import java.util.ArrayList; 
   
 public class ThrowUsedCarException { 
       
     public static void addCar( ArrayList<UsedCar> listOfCars) { 
         Scanner input = new Scanner(System.in); 
         String vinNum; 
         String make; 
         int year; 
         double mileage; 
         double price; 
         String answer; 
           
         do { 
             System.out.println("Enter VIN: "); 
             vinNum = input.next(); 
               
             System.out.println("Enter a Make: "); 
             make = input.next(); 
               
             System.out.println("Enter a year: "); 
             year = input.nextInt(); 
               
             System.out.println("Enter mileage: "); 
             mileage = input.nextDouble(); 
               
             System.out.println("Enter a price: "); 
             price = input.nextDouble(); 
               
             try { 
                 listOfCars.add(new UsedCar( vinNum, make, year, mileage, price)); 
                 System.out.println("Used Car added"); 
             } catch (UsedCarException e) { 
                 e.getMessage(); 
             } 
               
             System.out.println("Enter another car? (Yes/No) "); 
             answer = input.next(); 
                       
         } while(answer.equals("Yes")); 
           
         input.close(); 
     } 
       
     public static void main(String[] args) { 
   
         ArrayList<UsedCar> listOfCars = new ArrayList<UsedCar>(); 
         addCar(listOfCars); 
   
         System.out.println("List of Used Cars"); 
         for( UsedCar car : listOfCars ){ 
             System.out.println(car); 
         } 
     } 
   
 }
