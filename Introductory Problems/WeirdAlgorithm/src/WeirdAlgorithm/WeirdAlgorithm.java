/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WeirdAlgorithm;

import java.util.Scanner;

public class WeirdAlgorithm {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(n);
        while(n != 1){ // Self Explanatory
            if(n%2 == 0){
                n = n/2;
            }
            else{
                n*=3;
                n+=1;
            }
            System.out.println(n);
        }
        
    }
    
}
