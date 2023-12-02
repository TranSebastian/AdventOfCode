import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

class CubeConundrum{
   
   public static void main (String [] args) throws IOException{
      
      File input = new File ("input");
      Scanner reader = new Scanner(input);
      
      int totalID = 0;
      int ID = 1;
      
      while (reader.hasNextLine()){

         //split the line
         String temp = reader.nextLine();
         String line = temp.substring(temp.indexOf(":")+2);
         String [] subsets = line.split("; ");
  
         int i = 0;
         String [] colors = {" green", " blue", " red"};
         int [] colorsLimits = {0, 0, 0};
         
         System.out.println("game " + ID);
         
         //go through the subsets
         while( i < subsets.length ){
            
            
            //split it AGAIN
            String [] fuckOff = subsets[i].split(", ");
            System.out.println(Arrays.toString(fuckOff));
     
            for (int z = 0; z < fuckOff.length; z++){
            
               // go through colors to see if theres a match
               for (int x = 0; x < colors.length; x++){
            
                  if ( fuckOff[z].indexOf(colors[x]) != -1){                  
                     
                     String word = fuckOff[z].substring(0, fuckOff[z].indexOf(colors[x]));
                     int omg = Integer.parseInt(word);
                     
                     System.out.print(omg +"\t");
                     
                     if(omg > colorsLimits[x]){
                        
                        //update parrallel array
                        colorsLimits[x] = omg;
                        
                     
                     }
                                               
                  }
            
               }
               
            }
            System.out.println(Arrays.toString(colorsLimits));
      
            i++;
         
         } 
         
         int var = colorsLimits[0];
         
         for (int q = 1; q < colorsLimits.length; q ++){
         
            var *= colorsLimits[q];
         
         }        
         
         totalID += var; 
         ID++;
      
      }
      System.out.println(totalID);
      
   }

}