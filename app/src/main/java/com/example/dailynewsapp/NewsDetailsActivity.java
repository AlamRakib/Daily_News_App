package com.example.dailynewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewsDetailsActivity extends AppCompatActivity {

    ImageView imageView;

    TextView textView1, textView2;
    FloatingActionButton floatingActionButton;

    public static String TITLE = "";
    public static String DESCRIPTION = "";
    public static Bitmap MyBitmap = null;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_deatils);

        imageView = findViewById(R.id.imageCover);
        textView1 = findViewById(R.id.textViewTitleId);
        textView2 = findViewById(R.id.textViewDesId);
        floatingActionButton = findViewById(R.id.fabButton);

        textToSpeech = new TextToSpeech(NewsDetailsActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {


            }
        });


        textView1.setText(TITLE);
        textView2.setText(DESCRIPTION);

        if(MyBitmap!=null)
        {
            imageView.setImageBitmap(MyBitmap);
        }


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = textView2.getText().toString();
                if (floatingActionButton.isClickable()) {

                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);

                }
                else if(floatingActionButton.isClickable())
                {
                    textToSpeech.shutdown();
                }




            }
        });



    }
}