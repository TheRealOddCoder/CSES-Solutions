/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minimizingcoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author TheRealOddCoder
 */
public class MinimizingCoins {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line1[] = in.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int sum = Integer.parseInt(line1[1]);
        String line2[] = in.readLine().split(" ");
        
        // Solution in O(sum) space
        /*
        Vector<Integer> coins = new Vector<>();
        for(int i=0;i<n;++i)
            coins.add(Integer.parseInt(line2[i]));
        
        
        int dp[] = new int[sum+1];
        dp[0] = 0;
        for(int i=1;i<=sum;++i){
            dp[i] = sum+1;
            for(int c: coins){
                if(i-c>=0){
                    dp[i] = Math.min(dp[i],dp[i-c]+1);
                }
            }
        }
        
        System.out.println((dp[sum]>sum)? -1 : dp[sum]);
        */
        
        // Solution in O(n*sum) space complexity        
        int dp[][] = new int[n][sum+1];                //eg: coins= {1,2,3} sum=7 solution =3 ->{3+3+1}
        int coins[] = new int[n];                      // Initial dp table
        for(int i=0;i<n;++i)                           // sum --->  0   1   2   3   4   5   6   7   
            coins[i] = Integer.parseInt(line2[i]);     // coins 0 | 0   1   2   3   4   5   6   7
        Arrays.sort(coins);                            //   |   1 | 0   0   0   0   0   0   0   0
        for(int i=1;i<=sum;++i){                       //   v   2 | 0   0   0   0   0   0   0   0
            if(i % coins[0] == 0)                             
                dp[0][i] = i;
            else{                                      // first column is initialized to 0 because. when sum == 0,
                dp[0][i] = sum+1;                                        // you can't use any coin(Min. coin = 0)
            }                                          // first row is initialized to min. no of coin[0] required
                                                       // to make the given sum using onl coin[0]
        } 
        for(int i=1;i<n;++i){
            for(int j=0;j<=sum;++j){
                if(coins[i]<=j)
                    dp[i][j] = Math.min(dp[i][j-coins[i]]+1, dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        /*   Uncomment this to display final dp table  // coins = {1,2,3} sum=7 Solution = 3 ->{3+3+1}
        for(int i=0;i<n;++i){                          // final dp table
            for(int j=0;j<=sum;++j){                   //   sum --->     0   1   2   3   4   5   6   7
                System.out.print(dp[i][j]+" ");        // coins[1]   0 | 0   1   2   3   4   5   6   7
            }                                          //   |  [2]   1 | 0   1   1   2   2   3   3   4
            System.out.println("");                    //   v  [3]   2 | 0   1   1   1   2   2   2   3
        }                                              
        */
        System.out.println((dp[n-1][sum]>sum)? -1 : dp[n-1][sum]);
    }
    

}
