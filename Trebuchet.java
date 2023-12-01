import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Trebuchet{
   
   public static void main (String [] args) throws IOException{
      
      File input = new File ("input");
      Scanner reader = new Scanner(input);
      
      int total = 0;
      
      while (reader.hasNextLine()){
      
         String line = reader.nextLine();
         
         String firstNumber = "0";
         String secondNumber = "0";
         int firstNumIndex = Integer.MAX_VALUE;
         int secondNumIndex = Integer.MIN_VALUE;
         
         int i = 0;  
         boolean foundFirst = false;
         
         while (!foundFirst && i < line.length()){
            
            if (line.charAt(i) >= 48 && line.charAt(i) <= 57){
               
                  firstNumber = ""+ line.charAt(i);
                  secondNumber = firstNumber;
                  firstNumIndex = i;
                  foundFirst = true;               
            }
            i++;
                     
         }
         
         for (int x = i; x < line.length(); x++){
         
            if (line.charAt(x) >= 48 && line.charAt(x) <= 57){
               
                  secondNumber = ""+ line.charAt(x);
                  secondNumIndex = x;            
            }
      
         }
         
         String [] arr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
         
         for (int l = 0; l < arr.length; l++){
            
            if (line.indexOf(arr[l]) != -1 && line.indexOf(arr[l]) < firstNumIndex){
               firstNumber = 1+l+"";
               firstNumIndex = line.indexOf(arr[l]);
            }
         
         }
         
         for (int l = 0; l < arr.length; l++){
            
            if (line.indexOf(arr[l]) != -1 && line.indexOf(arr[l]) > secondNumIndex){
               secondNumber = 1+l+"";
               secondNumIndex = line.indexOf(arr[l]);
            }
         
         }
         
         System.out.println(firstNumber + secondNumber);
         total += Integer.parseInt(firstNumber + secondNumber);
               
      }
      System.out.println(total);
      
   }

}