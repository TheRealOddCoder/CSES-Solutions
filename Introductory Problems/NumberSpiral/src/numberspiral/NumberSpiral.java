/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numberspiral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author TheRealOddCoder
 */
public class NumberSpiral {

    public static void main(String[] args) throws IOException {
        
        //BufferedReader for fast I/O
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        long x,y; // x -> row and y -> column
        for(int i=0;i<t;++i){
            String[] num = input.readLine().split(" ");
            x = Long.parseLong(num[0]);
            y = Long.parseLong(num[1]);
            long answer = 0;
            if(x > y){                               
                if(x%2 == 0) answer = (x*x)-(y-1);  // (row)^2-(column-1)
                else answer = (x-1)*(x-1)+y;      // (row-1)^2 + column
            }
            else if(x < y){
                if(y%2 == 0) answer = (y-1)*(y-1)+x;  // (column-1)^2 + row
                else answer = (y*y)-(x-1);            // (column)^2 - (row-1)
            }
            else{                       
                answer = (x*x)-(x-1); // if row == column
            }
            System.out.println(answer);
        }
    }

}
