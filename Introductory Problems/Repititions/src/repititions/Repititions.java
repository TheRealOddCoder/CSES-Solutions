/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repititions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
    
/**
 *
 * @author Vignesh
 */
public class Repititions {

    public static void main(String[] args) throws IOException {
        // BufferedReader for fast I/O
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int max_count = 0; // to look for biggest subarray
        int count = 1; // variable to count the size of current subarray of repiting chars
        for(int i=0;i<s.length() ;++i){
            count = 1;
            // This is not nested loop, the compexity is still O(1)
            while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){ // this loop runs till a repeating char is found consecutively
                count+=1;
                i+=1;                                     // loop counter is also incremented so that when non-repeating character is found,
                                                          // it can continue from that point, not from the beginning of the subarray
            }
            if(count>max_count) max_count = count; // if the current subarray size is large, it will bw the largest subarray of repeating chars
            // eg: [AGGTCCCA] in 1st iteration max_count = 2(char G) in next iteration max_count = 3 (char C)
        }
        
        System.out.println(max_count);
    }
    
}
