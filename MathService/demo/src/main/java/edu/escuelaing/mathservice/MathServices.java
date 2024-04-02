package edu.escuelaing.mathservice;

import static spark.Spark.*;

import java.util.ArrayList;

import com.google.gson.Gson;


public class MathServices {
    
    public static void main(String... args){
        port(getPort());
        get("/factors", (req,res) -> {
            String msg = req.queryParams("num");
            Integer num = Integer.parseInt(msg);
            return getNums(num);
        });
        
}

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String getNums(Integer num){
        try{
            Primes primes = new Primes();
            ArrayList<Integer> numprimos = primes.primos(100);
            for (Integer i : numprimos){
                System.out.println(i);
            }
            
            //Prepare Gson
            Gson json = new Gson();
            return json.toJson(primes);
        } catch (Exception e) {
            return "Connection Error";
        }


    }
    
}