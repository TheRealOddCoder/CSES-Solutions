/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package increasingarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreasingArray {

    
    public static void main(String[] args) throws IOException {
        
        // BufferedReader for fast I/O
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] num = in.readLine().split(" ");
        long t1,t2;
        long count = 0; // To keep track of the modifications made, when num[i]>num[i+1]
        for(int i=1;i<n;i++){
            t1 = Long.parseLong(num[i]);
            t2 = Long.parseLong(num[i-1]);
            if(t1 < t2){
                count = count+ Math.abs(t1-t2); // num = [3 1 4 3 4] Here t1 = 1 and t2 = 3                                                 
                                               // Since t1<t2, we need to make t1==t2, and add the difference to count
                
                num[i] = num[i-1];  // The modification made should be reflected in successive element
                                    // after first iteration, num = [3 3 4 3 4].
            }
        }
        // final array after modifications made, num = [3 3 4 4 4] ; Here, count = 3
        System.out.println(count);
    }
    
}
