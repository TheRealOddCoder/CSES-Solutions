/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coincombinations1;

import java.util.Scanner;

/**
 *
 * @author TheRealOddCoder
 */
public class CoinCombinations1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int c[] = new int[n];
        int dp[] = new int[x+1];
        int mod = 1000000007;
        for(int i=0;i<n;i++)
            c[i] = input.nextInt();
        dp[0]=1;
        for(int sum=1;sum<=x;sum++){
            for(int i=0;i<n ;i++){
                    if(c[i] <= sum)
                        dp[sum] =dp[sum] + dp[sum-c[i]];
                    dp[sum] = (dp[sum] >= mod) ? (dp[sum]-mod) : dp[sum];
            }
        }
        System.out.println(dp[x]);
        
    }

}
