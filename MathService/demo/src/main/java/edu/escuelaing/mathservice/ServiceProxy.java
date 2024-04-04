package edu.escuelaing.mathservice;

import static spark.Spark.*;
public class ServiceProxy {
    
    public static void main (String[] args){
        port(getPort());
        staticFiles.location("/public");
        Round.setURLS(args);
        get("/primes",(req,res) ->{
            res.type("application/json");
            return Round.distribution("p", Integer.parseInt(req.queryParams("value")));
        });
        get("/factors",(req,res)->{
            res.type("application/json");
            return Round.distribution("f",Integer.parseInt(req.queryParams("value")));
        });
    }


    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
