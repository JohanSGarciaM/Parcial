package edu.escuelaing.mathservice;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.stream.Collectors;



public class MathService {
    
    public static void main(String... args){
        port(getPort());
        get("/factors", (req,res) -> {
            res.type("application/json");
            Integer number = Integer.parseInt(req.queryParams("value"));
            return getNums(number,"f");
        });
        get("/primes",(req,res)->{
            res.type("application/json");
            Integer number = Integer.parseInt(req.queryParams("value"));
            return getNums(number,"p");
        });
        
}

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }



    private static String getNums(Integer num, String op){
        String out = "";
        String operation = "";
        if(op == "f"){
            operation = "Factors";
            out = factores(num).stream().map(String::valueOf).collect(Collectors.joining(", "));
        }else{
            operation = "Primes";
            out = primos(num).stream().map(String::valueOf).collect(Collectors.joining(", "));
        }
        return "{\n" +
                " \"Operation\" : " + operation + ",\n" +
                " \"Input\" : " + num + ",\n" +
                " \"Output\" : " + out + "\n" +
                "}";

    }

    public static ArrayList<Integer> primos(Integer n){
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++){
            ArrayList<Integer> factos = factores(i);
            if(factos.size()==2){
                primes.add(i);
            }
        }
        return primes;
    }

    public static ArrayList<Integer> factores(Integer n){
        ArrayList<Integer> factores = new ArrayList<Integer>();

        for(int i = 1; i <= n/2; i++){
            if ((n%i)==0){
                factores.add(i);
            }
        }
        factores.add(n);
        return factores;
    }
    
}