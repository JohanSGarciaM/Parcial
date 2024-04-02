package edu.escuelaing.mathservice;

import java.util.ArrayList;
public class Primes {
    


    public ArrayList<Integer> primos(Integer n){
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++){
            ArrayList<Integer> factos = factores(i);
            if(factos.size()==2){
                primes.add(i);
            }
        }
        return primes;
    }

    public ArrayList<Integer> factores(int n){
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
