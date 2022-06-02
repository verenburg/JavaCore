package src.com.javarush.task.task15.task1522;

import com.sun.deploy.security.SelectableSecurityManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        reader.close();
        if (s.equals(Planet.SUN)) thePlanet = Sun.getInstans();
        else if (s.equals(Planet.EARTH)) thePlanet = Moon.getInstans();
        else if (s.equals(Planet.MOON)) thePlanet = Earth.getInstans();
        else thePlanet = null;
    }
}
