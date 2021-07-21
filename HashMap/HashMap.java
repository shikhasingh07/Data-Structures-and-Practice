import java.util.*;
import java.io.*;

public class Main {
 
  //pepcoding 
  public static void longestConsecutiveSquence(int[] arr , HashMap<Integer , Boolean> has ) {
    
    for (int val : arr){
        has.put(val , true);
    }
    
    for(int val : arr){
        if(has.containsKey(val-1)){
            has.put(val , false);
        }
    }
    int ml = 0 ;
    int msp = 0 ;
    for(int val : arr){
     if(has.get(val)== true){
      int tl = 1; 
      int ts = val; 
      while(has.containsKey(ts+tl)){
          tl++; 
      }
      if(tl > ml){
          ml = tl; 
          msp = ts; 
      }
    }    
    
    }
    
    for(int ti = 0 ; ti < ml ; ti++){
        System.out.println(msp+ti);
    }
    
  }
  public static void main(String[] args){
    
    int[] arr = {17 , 12, 5, 1, 2,10 , 2 , 13 , 7 , 11 , 8  , 9};
    HashMap<Integer,Boolean> has  = new HashMap<>();
    longestConsecutiveSquence(arr ,has);
  }

}
