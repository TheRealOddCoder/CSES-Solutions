/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coincombinations2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author TheRealOddCoder
 */
public class CoinCombinations2 {

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = input.nextInt();
        int coins[] = new int[n+1];
        for(int i=0;i<n;++i){
            coins[i] = input.nextInt();
        }
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for (int c=0;c<n;c++)
            for (int i = 1; i <= sum; i++)
                if (coins[c] <= i) dp[i] = (dp[i] + dp[i - coins[c]]) % 1000000007;
        System.out.println(dp[sum]);
        
    }

}
