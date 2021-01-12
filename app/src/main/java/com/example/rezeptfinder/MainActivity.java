package com.example.rezeptfinder;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mainContext;
    private MainActivity mainActivity;

    private RelativeLayout mRelativeLayout;
    private ListView mainListView;
    private TextView mainTextView;


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

        // Initializing a new list
        List<String> ingredients = Arrays.asList(
                "Alder",
                "Basswood",
                "Birch",
                "Buckeye",
                "Cedar",
                "Cherry",
                "Chestnut",
                "Hawthorn",
                "Cypress",
                "Honeylocust"
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
    }
}