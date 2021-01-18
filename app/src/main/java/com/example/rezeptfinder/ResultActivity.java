package com.example.rezeptfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Future;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Result string und double wird ausgelesen
        Bundle b = getIntent().getExtras();
        String resultat_string = b.getString("result_string");
        boolean vegiBoolean = b.getBoolean("vegi_bool");
        boolean vegaBoolean = b.getBoolean("vega_bool");
        boolean diabBoolean = b.getBoolean("diab_bool");
        boolean laktBoolean = b.getBoolean("lakto_bool");



        //Trying the FutureTask Code
        Future<String> future = null;
        try {
            future = new RecepieGetter().getIt(vegiBoolean, vegaBoolean, diabBoolean, laktBoolean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!future.isDone()) {
            System.out.println("Calculating...");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //End of that.





        /*
        RecepieGetter RG = new RecepieGetter();
        try {
            RG.getIt(vegiBoolean, vegaBoolean, diabBoolean, laktBoolean);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

            LinearLayout LL = new LinearLayout(this); //wenn nicht content, result_layout probiere
            setContentView(LL);
            LL.setOrientation(LL.VERTICAL);


            //Titel setzen
            TextView titleView = new TextView(this);
            titleView.setText("Kochapp");
            titleView.setTextSize(35);
            titleView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            titleView.setBackgroundColor(Color.rgb(177, 177, 177));
            titleView.setTextColor(Color.rgb(255, 255, 255));

            LL.addView(titleView);





/*

        ArrayList resultate = RG.getResultate();
        for (int counter = 0; counter < resultate.size(); counter++) {
            System.out.println(resultate.get(counter));
        }

        for( int i = 0; i < resultate.size(); i++ )
        {
            TextView textView = new TextView(this);

            textView.setText((CharSequence) resultate.get(i));
            LL.addView(textView);
        }
*/
        }

}
