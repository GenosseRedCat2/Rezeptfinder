package com.example.rezeptfinder;

import android.os.StrictMode;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class RecepieGetter {
    public void getIt(boolean vegiBoolean, boolean vegaBoolean, boolean diabBoolean, boolean laktBoolean ) {


        if (vegiBoolean) {
            System.out.println("Es ist vegetarisch!");

            //HTML Seite wird heruntergeladen
            //Wird aus Zeitgründen weggelassen.
        }

        if (vegaBoolean){
            System.out.println("Es ist vegan!");
            //HTML Seite wird heruntergeladen
            //Wird aus Zeitgründen weggelassen.
        }
        if (diabBoolean){
            System.out.println("Es ist diabetes freundlich!");
            //HTML Seite wird heruntergeladen
            //Wird aus Zeitgründen weggelassen.
        }
        if (laktBoolean){
            System.out.println("Es ist laktose freundlich!");
            //HTML Seite wird heruntergeladen
            //Wird aus Zeitgründen weggelassen.
        }
    }
}
