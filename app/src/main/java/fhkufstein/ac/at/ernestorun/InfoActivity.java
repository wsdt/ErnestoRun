package fhkufstein.ac.at.ernestorun;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class InfoActivity extends AppCompatActivity {

    final int sdk = android.os.Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().hide();

        final ImageButton button1 = (ImageButton)findViewById(R.id.good);
        final ImageButton button2 = (ImageButton)findViewById(R.id.bad);
        final ImageButton button3 = (ImageButton)findViewById(R.id.end);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonsInvisible(button1, button2, button3);
                Log.i("button", String.valueOf(button1.getId()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonsInvisible(button1, button2, button3);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeButtonsInvisible(button1, button2, button3);
                setItems(button3);
            }
        });

    }

    public void makeButtonsInvisible(ImageButton button1, ImageButton button2, ImageButton button3){

        button1.setVisibility(ImageButton.GONE);
        button2.setVisibility(ImageButton.GONE);
        button3.setVisibility(ImageButton.GONE);
    }

    public void setItems(ImageButton button){



    }


}
