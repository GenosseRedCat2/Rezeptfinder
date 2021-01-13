/**
 * Diese App wurde von Jason Banyer programmiert.
 * Letzer Eintrag am 12.01.2021
 *
 * Diese Klasse ist die Hauptklasse und verwaltet die erste Appseite.
 * */
package com.example.rezeptfinder;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mainContext;
    private MainActivity mainActivity;

    private RelativeLayout mRelativeLayout;
    private ListView mainListView;
    private TextView mainTextView;
    private CheckBox vegiCheckbox;
    private CheckBox vegaCheckbox;
    private CheckBox diabCheckbox;
    private CheckBox laktCheckbox;
    private Button searchButton;

    private boolean vegiBoolean = false;
    private boolean vegaBoolean = false;
    private boolean diabBoolean = false;
    private boolean laktBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Get the application context
        mainContext = getApplicationContext();

        // Get the activity
        mainActivity = MainActivity.this;

        // Referenziert die XML Dateien
        mainListView = (ListView) findViewById(R.id.lv);
        mainTextView = (TextView) findViewById(R.id.tv);

        //Die CheckBoxen werden definiert nach Vegetarier Checkbox, Veganer Checkbox, Diabetes Checkbox und Laktose Checkbox.
        vegiCheckbox = (CheckBox) findViewById(R.id.checkBox);
        vegaCheckbox = (CheckBox) findViewById(R.id.checkBox2);
        diabCheckbox = (CheckBox) findViewById(R.id.checkBox3);
        laktCheckbox = (CheckBox) findViewById(R.id.checkBox4);
        searchButton = (Button) findViewById(R.id.button);


        // Initializing a new list of ingredients
        List<String> ingredients = Arrays.asList(
                "Ananas",
                "Äpfel",
                "Birnen",
                "Bananen",
                "Karotten",
                "Peperoni",
                "Chilli",
                "Fenkel",
                "Oliven",
                "Zwiebeln"
        );

        // Erstellt einen neuen ArrayAdapter.
        ArrayAdapter<String> adapter = new ArrayAdapter(
                mainActivity,
                android.R.layout.simple_list_item_multiple_choice,
                ingredients
        );

        // Setzt den Adapter auf die Hauptlistenview.
        mainListView.setAdapter(adapter);


        // Ein Listener für die einzelnen Zutaten.
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SparseBooleanArray clickedItemPositions = mainListView.getCheckedItemPositions();

                //Gibt dem Ausgabefeld einen Text
                mainTextView.setText("Ausgewählte Zutaten: ");

                for(int index=0;index<clickedItemPositions.size();index++){

                    // Holt die aktuelle Position der ausgewählten Zutat.
                    boolean checked = clickedItemPositions.valueAt(index);

                    if(checked){

                        // Definiert die aktuelle Position der ausgewählten Zutat.
                        int key = clickedItemPositions.keyAt(index);
                        String item = (String) mainListView.getItemAtPosition(key);

                        // Gibt ein "&" aus und eine Liste der aktuellen ausgewählten Zutaten.
                        mainTextView.setText(mainTextView.getText() + item + " & ");
                    }
                }
            }
        });
        //Listener ViewList zu Ende


        //Checkbox Vegetarischer Listener
        vegiCheckbox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (vegiBoolean == false) {
                    vegiBoolean = true;
                } else {
                    vegiBoolean = false;
                }
            }
        }
        );

        //Checkbox Veganer Listener
        vegaCheckbox.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (vegaBoolean == false) {
                        vegaBoolean = true;
                    } else {
                        vegaBoolean = false;
                    }
                }
            }
        );

        //Checkbox Diabetes Listener
        diabCheckbox.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (diabBoolean == false) {
                        diabBoolean = true;
                    } else {
                        diabBoolean = false;
                    }
                }
            }
        );

        //Checkbox Laktose Listener
        laktCheckbox.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if (laktBoolean == false) {
                        laktBoolean = true;
                    } else {
                        laktBoolean = false;
                    }
                }
            }
        );




        //Ein Listener wird auf den searchButton gepackt.
        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                RecepieGetter RG = new RecepieGetter();

                    RG.getIt(vegiBoolean, vegaBoolean, diabBoolean, laktBoolean);

            }


            });

    }
}