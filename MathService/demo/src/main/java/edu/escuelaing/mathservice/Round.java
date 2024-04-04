package edu.escuelaing.mathservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Round {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static List<String> URLS = new ArrayList<>();
    private static int instance = 0;
    public static String distribution(String op,Integer num)throws IOException{
        
        URL obj = new URL(URLS.get(instance) + op + "?value"+num);  
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        changeInstance();
        return response.toString();
    }
    public static void setURLS ( String[] args){
        for(String url : args){
            URLS.add("http://"+url+"/");
        }
    }
    private static void changeInstance(){
        if(instance == 0){
            instance = 1;
        }else{
            instance = 0;
        }
    }

    
}
