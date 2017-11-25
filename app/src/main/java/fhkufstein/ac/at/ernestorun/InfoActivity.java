package fhkufstein.ac.at.ernestorun;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    final int sdk = android.os.Build.VERSION.SDK_INT;
    public static final String EXTRA_MESSAGE = "fhkufstein.ac.at.ernestorun.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().hide();

        final ImageButton button1 = (ImageButton)findViewById(R.id.good);
        final ImageButton button2 = (ImageButton)findViewById(R.id.bad);
        final ImageButton button3 = (ImageButton)findViewById(R.id.end);

        TextView textView1 = (TextView)findViewById(R.id.textview1);

        textView1.setTextColor(Color.BLACK);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startIcons("good");
                Log.i("button", String.valueOf(button1.getId()));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIcons("bad");


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIcons("end");

            }
        });

    }


    public void startIcons(String icons){
        Intent intent = new Intent(this, IconsActivity.class);
        String icon = icons.toString();
        intent.putExtra(EXTRA_MESSAGE, icon);
        startActivity(intent);

    }

}
