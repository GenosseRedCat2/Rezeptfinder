package com.example.rezeptfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;

public class RecepieGetter {

    private ArrayList<String> resultate = new ArrayList<String>();
    Activity context;
    private String resultat; // private = restricted access


    public void getIt(boolean vegiBoolean, boolean vegaBoolean, boolean diabBoolean, boolean laktBoolean ) {


        if (vegiBoolean) {
            System.out.println("Es ist vegetarisch!");

            //HTML Seite wird heruntergeladen
            //Wird aus Zeitgründen weggelassen.

            resultate.add("https://myfridgefood.com/recipes/entree-vegetarian/quiche-vegetarian/");
            resultate.add("https://myfridgefood.com/recipes/pasta-and-pizza/vegetarian-lasagna/");
            resultate.add("https://myfridgefood.com/recipes/soups/vegetarian-tortilla-soup/");
            resultate.add("https://myfridgefood.com/recipes/sandwiches-burgers/vegetarian-sloppy-joes/");
            resultate.add("https://myfridgefood.com/recipes/dips-and-sauces/vegetarian-onion-gravy/");
            resultate.add("https://myfridgefood.com/recipes/dessert/vegetarian-hot-dogs-lol/");


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
    // Getter
    public ArrayList<String> getResultate() {
        return resultate;
    }

    // Setter
    public void setResultate(ArrayList resultate) {
        this.resultate = resultate;
    }


}
