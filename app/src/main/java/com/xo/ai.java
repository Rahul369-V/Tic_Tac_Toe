package com.xo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ai extends AppCompatActivity {

    ImageView AI;
    TextView PROFILE,PROFILE1;
    Button btn1;
    MediaPlayer btn_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ai);
        AI =findViewById(R.id.AI_DOMAIN);
        PROFILE =findViewById(R.id.PROFILE);
        PROFILE1 =findViewById(R.id.id5);
        btn1 =findViewById(R.id.BTN);
  // mediaplayer
        btn_sound=MediaPlayer.create(ai.this,R.raw.button_sound);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sound.start();

                Intent intent=new Intent(ai.this,page_2.class);
                startActivity(intent);
            }
        });


    }

}
