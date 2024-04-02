package edu.escuelaing.mathservice;

import static spark.Spark.*;

import java.util.ArrayList;


public class MathServices {
    
    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        Primes primes = new Primes();
        ArrayList<Integer> numprimos = primes.primos(100);
        for (Integer i : numprimos){
            System.out.println(i);
        }
}

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}