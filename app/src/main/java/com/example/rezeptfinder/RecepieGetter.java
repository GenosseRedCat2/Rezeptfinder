/**
 * Diese App wurde von Jason Banyer programmiert.
 * Letzer Eintrag am 18.01.2021
 *
 * Diese Klasse ist dafür zuständig die Rezepte zu holen und an den ResultActivity zu übergeben.
 * Aufgerufen wird diese Klasse als asynchrones Thread von ResultActivity.
 * */
package com.example.rezeptfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RecepieGetter{

    ArrayList<String> recipeHTMLCode = new ArrayList<>();
    ArrayList<String> entireHTMLCode = new ArrayList<>();
    ArrayList<String> recipeURLQuotes = new ArrayList<>();
    ArrayList<String> recipeURL = new ArrayList<>();
    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    private ArrayList resultate = new ArrayList<String>();
    public Future getIt(boolean vegiBoolean, boolean vegaBoolean, boolean diabBoolean, boolean laktBoolean ) throws IOException {
        return executor.submit(() -> {


            if (vegiBoolean) {
                System.out.println("Es ist vegetarisch!");

                //HTML Seite wird heruntergeladen


                // Dieser Teil verursacht Probleme, weil das Android nicht
                // mit dem Internet verbindet <-----


                //Der ?q= vegetarian Teil kann mit allem ersetzt werden.
                URL url = new URL("https://myfridgefood.com/Search?q=vegetarian");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(60000); // timing out in a minute

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
                String line;

                //----------->

                while ((line = reader.readLine()) != null) {

                    entireHTMLCode.add(line);
                }

                for (int i = 0; i < entireHTMLCode.size(); i++) {
                    if (entireHTMLCode.get(i).contains("href=\"/recipes/")) {


                        //Der Targetcode wird entfernt.
                        String master = entireHTMLCode.get(i);
                        String target = "<a target=\"blank\" href=";
                        String processed = master.replace(target, "");


                        //Der Stylecode wird entfernt
                        String target2 = "<a style=\"font-size: 20px; display:block; border-bottom:solid #ccc 1px; padding-bottom:5px; margin-bottom:10px; text-align:center;\" href=";
                        String processed2 = processed.replace(target2, "");


                        //Die URL Tags werden entfernt
                        String target3 = "\">";
                        String target4 = "</a>";
                        String processed3 = processed2.replace(target3, "");
                        String processed4 = processed3.replace(target4, "");

                        recipeHTMLCode.add(processed4);



                    }
                }
                // Die Anführungszeichen werden entfernt
                for (int i = 0; i < recipeHTMLCode.size(); i++) {
                    recipeURLQuotes.add(recipeHTMLCode.get(i).substring(0, recipeHTMLCode.get(i).lastIndexOf("/")));
                }
                //Alle doppelten Einträge werden entfernt
                for (int y = 1; y < recipeURLQuotes.size(); y++) {

                    if (recipeURLQuotes.contains(recipeURLQuotes.get(y))) {
                        recipeURL.add(recipeURLQuotes.remove(y));
                    }

                }
                // Nach Ingredients sortieren

                // Resultate werden nach ResultActivity gesendet.
                reader.close();
                writer.close();


                setResultate(recipeURL);
            }

            if (vegaBoolean) {
                System.out.println("Es ist vegan!");
                //HTML Seite wird heruntergeladen
                //Wird aus Zeitgründen weggelassen.
            }
            if (diabBoolean) {
                System.out.println("Es ist diabetes freundlich!");
                //HTML Seite wird heruntergeladen
                //Wird aus Zeitgründen weggelassen.
            }
            if (laktBoolean) {
                System.out.println("Es ist laktose freundlich!");
                //HTML Seite wird heruntergeladen
                //Wird aus Zeitgründen weggelassen.
            }
            return null;

            //Omnivore fehlt noch
        });
    }

    // Getter
    public ArrayList<String> getResultate () {
        return recipeURL;
    }

    // Setter
    public void setResultate (ArrayList recipeURL){
        this.recipeURL = recipeURL;
    }
}
