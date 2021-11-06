package com.xo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
     CheckBox musictheme;
     Button buttonmode;
    ImageView image1,image2;
    EditText username;
    TextView  errortext,text1;
    MediaPlayer background_theme ,btn_sound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   // BACKGROUND THEME
     background_theme = MediaPlayer.create(MainActivity.this,R.raw.xo_background_theme);
      btn_sound =MediaPlayer.create(MainActivity.this,R.raw.button_sound);


        musictheme =findViewById(R.id.music);
        buttonmode=findViewById(R.id.button1);
        image1 =findViewById(R.id.image1);
        image2 =findViewById(R.id.image2);
        username=findViewById(R.id.box1);
        errortext =findViewById(R.id.errortext);
        text1 =findViewById(R.id.text1);


        buttonmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String error = ("Please Enter Your Name");
                btn_sound.start();
                if (validusername(name)){
          //TODO : INTENT ACTIVITIES,
                    String user =username.getText().toString();
                    Intent intent=new Intent(MainActivity.this,page_2.class);
                         intent.putExtra("USERNAME",user);
                         startActivity(intent);


                }else {
                    errormsg(error);
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();
                }

            }
        });
//        musictheme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //TODO INCLUDE MUSIC ?
//                background_theme.start();
//
//            }
//        });

        musictheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(musictheme.isChecked()){
                    background_theme.start();
                }
                else{
                    background_theme.pause();
                }
            }
        });



    }
 private boolean validusername(String name ){
     return correctuser("^[A-Za-z]+$",name);
 }

    private boolean correctuser (String pattern,String input){

        Pattern r =Pattern.compile(pattern);   ///// CLASS SHOULD BE IN PASCAL NAME CONVENTION(Pattern)
        return r.matcher(input).matches();



    }
    private void errormsg(String error){
        errortext.setVisibility(View.VISIBLE);
        errortext.setText(error);
    }


}