/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package missingnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MissingNumber {
    
    public static void main(String[] args) throws IOException {
        
        // BufferedReader for fast I/O
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] tokens = in.readLine().split(" ");
        
        // HashSet is used so that searching for missing number will take O(1)
        //HashMap can also be used
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < n-1; i++) { // the input contains 1 to n-1 numbers
            map.add(Integer.parseInt(tokens[i]));
        }
        for(int i=1;i<=n;i++){
            if(!map.contains(i)){ // Print the number if it is not in the set
                System.out.println(i);
            }
        }
    }
    
}
