package org.weather;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.sun.net.httpserver.Headers;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("City name");
        Scanner in=new Scanner(System.in);
        String City="London";
        City=in.next();
        String Key="d925004b7ce15c9b68ab903c773a1165";
        String Url="https://api.openweathermap.org/data/2.5/weather?q="+City+"&appid="+Key;
        OkHttpClient client=new OkHttpClient();


        Request request=new Request.Builder().url(Url).build();
        BWeather weather=null;
        try {
            Response response = client.newCall(request).execute();
            String ansver = response.body().string();
            ObjectMapper objectMapper=new ObjectMapper();
            //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            weather=objectMapper.readValue(ansver,BWeather.class);
            BWeather weather1=new BWeather();



        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //double temp=(weather.main.temp-32)/1.8;
        double temp=Math.round(weather.main.temp-273.15);
        System.out.println("Temperature in "+City+" "+temp);
    }
    }




