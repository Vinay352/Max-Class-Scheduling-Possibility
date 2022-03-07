/*
* OneDup.java
*
* Version:
*     $2$
*/

/**
 * CSCI-665
 *
 *  Aim: To compute the number of possible schedules in the 2 ways
 *      ( as mentioned in Question 5 of Algorithm Assignment 3 ).
 *
 *   Complexity of our Implementation: O( n )
 *
 *   @author: Omkar Morogiri,om5692
 *   @author: Vinay Jain,vj9898
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Schedules {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int n = Integer.parseInt( br.readLine() ); // take input

        // since our pattern repeats every 3 hours in the first case, therefore the number of
        // such instances (multiple of 3's)
        long x = Math.floorDiv( n, 3 );
        // System.out.println(x);


        // case 1
        long multi = 1; // multiplying factor
        if ( n == 0 ){
            multi = 0;
        }
        else{ // calculating for remainder hours
            if ( n % 3 == 1 ){
                multi = 2;
            }
            else if ( n % 3 == 2 ){
                multi = 5;
            }
//            else if ( n % 3 == 0 ){
//                multi = 13;
//            }
        }

        // answer for case 1
        long case1 = Long.parseLong( String.valueOf ( ( int ) Math.pow( 13, x ) * multi ) );
        System.out.println( case1 );


        // case 2
        long[] dp = new long[ (2 * n) + 1 ]; // dynamuc programming array to store previous values

        // base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // iterate from i = 3 to 2n+1
        for( int i = 3; i < (2 * n) + 1; i++ ){
            dp[ i ] = dp[ i - 1 ] + dp[ i - 2 ] + dp[ i - 3 ];
        }

        // print out the answer at the last index
        System.out.println( dp[ 2 * n ] );


    }
}
