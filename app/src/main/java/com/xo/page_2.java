package com.xo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class page_2  extends AppCompatActivity {
    ImageView computer_domain;
    TextView update_msg,com_name,choices,welcome_txt;
    Button DUALS,SINGLE_PLAYER;
    MediaPlayer  btn_sound;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_2);

        // using the properties of media player
         btn_sound=MediaPlayer.create(page_2.this,R.raw.button_sound);

        computer_domain =findViewById(R.id.domain);
        update_msg =findViewById(R.id.message);
        com_name =findViewById(R.id.text3);
        choices=findViewById(R.id.text4);
        welcome_txt=findViewById(R.id.text2);
        DUALS=findViewById(R.id.duals);
        SINGLE_PLAYER=findViewById(R.id.single_player);


        // INTENT TO GET DATA
        final Intent intent=getIntent();
        final String username =intent.getStringExtra("USERNAME");
          welcome_txt .setText("welcome"+" "+username);






          computer_domain.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                Intent intent2 = new Intent(page_2.this,ai.class);
                    startActivity(intent2);
              }
          });




        DUALS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn_sound.start();

        //TODO INTENT TO GO NEXT PAGE
                Intent intent1=new Intent(page_2.this,xo_page2.class);
                startActivity(intent1);


            }
        });

        SINGLE_PLAYER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_sound.start();
              String message ="Update Will Come Soon !!!!!!";
              update(message);
              //todo add sounds

            }
        });


    }

    protected void update(String msg){
        update_msg.setVisibility(View.VISIBLE);
         update_msg.setText(msg);




    }



}
