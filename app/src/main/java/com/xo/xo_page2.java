package com.xo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class xo_page2 extends AppCompatActivity implements View.OnClickListener {
Button resetbutton;
TextView player_one,player_two ,player1points ,player2points;
ImageView vs_image;
  private  Button[][] buttons =new Button[3][3];
private int roundcount;
private boolean firstturn =true;
private int player1pts;
private int player2pts;
    MediaPlayer btn_sound ,cheerup;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.twoplayer_gameplay);

    //MEDIAPLAYER
        btn_sound =MediaPlayer.create(xo_page2.this,R.raw.button_sound);
      cheerup=MediaPlayer.create(xo_page2.this,R.raw.cheer);


        resetbutton =findViewById(R.id.RESETBTN);
        vs_image = findViewById(R.id.IMAGE1);
        player1points =findViewById(R.id.id_3);
        player2points =findViewById(R.id.id_4);
        player_one=findViewById(R.id.id_1);
        player_two=findViewById(R.id.id_2);
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){     ///less than three only !!!!!!!
                String btn ="IMAGEBUTTON_"+i+j;
                int ID = getResources().getIdentifier(btn,"id",getPackageName());
                buttons[i][j]=findViewById(ID);
                buttons[i][j].setOnClickListener(this);
            }
        }

//        btn1 =findViewById(R.id.IMAGEBUTTON1);
//        btn2 =findViewById(R.id.IMAGEBUTTON2);
//        btn3 =findViewById(R.id.IMAGEBUTTON3);
//        btn4=findViewById(R.id.IMAGEBUTTON4);
//        btn5 =findViewById(R.id.IMAGEBUTTON5);
//        btn6 =findViewById(R.id.IMAGEBUTTON6);
//        btn7/  =findViewById(R.id.IMAGEBUTTON7);
//        btn8 =findViewById(R.id.IMAGEBUTTON8);
//        btn9 =findViewById(R.id.IMAGEBUTTON9);

       resetbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            //TODO RESET METHODALOGY
               btn_sound.start();
               resetall();
           }
       });


    }

    @Override
    public void onClick(View view) {// THIS FOR ,PLAYER WILL IDENTIFY whether field is occupy or not

        if(!((Button)view).getText().toString().equals("")){
            return ;/// RETURNS NOTHING

        }
        if (firstturn){   // DISPLAYING X
              ((Button) view).setText("x");
        }
        else{     // DISPLAYING O

            ((Button) view ).setText("o");

        }
        roundcount++;    //INCREAMENT THE NO. OF TURNS
        if(winning_logic()){
            if(firstturn){     // THIS FOR WHO WON THE MATCH
                player1wins();
            }else{
                player2wins();
            }
        }else if(roundcount==9){ //// THIS IS FOR DRAW
            draw();
        }else{
            firstturn=!(firstturn);   // THIS IS FOR CHANGE THE PLAYER'S TURNS
        }

    }
    //TODO WINNING LOGIC
    //TODO ENDING LOGIC
  public boolean winning_logic(){
        String box[][]=new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                box[i][j] =buttons[i][j].getText().toString();
            }
        }

       //row wise winning
        for(int i=0;i<3;i++){  //good
            if(box[i][0].equals(box[i][1])&&box[i][0].equals(box[i][2])&&
                    (!box[i][0].equals(""))){
                return true;

            }
        }




          // good
      //column wise winning

      for(int i=0;i<3;i++){
          if(box[0][i].equals(box[1][i])&&box[0][i].equals(box[2][i])&&
                  (!box[0][i].equals(""))){
              return true;

          }
      }


   // good
      // cross wise winning

      if(box[1][1].equals(box[2][0])&&box[1][1].equals(box[0][2])&&!box[1][1].equals("")){
          return true;
      }
      //cross wise winning


      if(box[1][1].equals(box[0][0])&&box[1][1].equals(box[2][2])&&!box[1][1].equals("")){
          return true;
      }
      return false;
  }



  //TODO DRAW METHODLOGY
    // TODO PLAYER ONE WINS METHODALOGY
    //TODO PLAYER TWO METHODALOGY
    //TODO DIPLAYING THE WINNING IMAGES

    public void player1wins(){
        player1pts++;
        Toast.makeText(xo_page2.this,"PLAYER ONE WIN",Toast.LENGTH_LONG).show();
        cheerup.start();
        winning_msg2();
        update_points();
        resetboard();
    }
    public void player2wins(){
        player2pts++;
        Toast.makeText(xo_page2.this,"PLAYER TWO WIN",Toast.LENGTH_LONG).show();
        cheerup.start();
        winning_msg1();
        update_points();
        resetboard();

    }

    public void draw(){
        Toast.makeText(xo_page2.this,"draw",Toast.LENGTH_SHORT).show();
        DRAW();
        resetboard();

    }
    public void update_points(){
        player1points.setText(""+player1pts);
        player2points.setText(""+player2pts);

    }
    public void resetboard(){
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                buttons[i][j].setText("");
            }
        }
        roundcount=0;
        firstturn=true;
    }
    protected void  resetall(){
        player1pts =0;
        player2pts=0;
        update_points();
        resetboard();

    }
    protected void winning_msg1(){
        ImageView img =new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.winning_image1);


        Toast toast =new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(img);
        toast.show();
    }
    protected void winning_msg2(){
        ImageView img =new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.winning_image2);


        Toast toast =new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(img);
        toast.show();
    }
    protected void DRAW(){
        ImageView img =new ImageView(getApplicationContext());
        img.setImageResource(R.drawable.draw);


        Toast toast =new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(img);
        toast.show();
    }


}













