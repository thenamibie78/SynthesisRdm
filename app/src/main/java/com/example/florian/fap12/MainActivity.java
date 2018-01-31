package com.example.florian.fap12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    //VARIABLES
    protected Integer PRINCIPAL_NUMBER = 0;
    protected String CAST_STRING_PRINCIPAL_NUMBER="";
    protected Integer STATES_VALUE_MAIN; //Stats of vocal
    private int myId;
    private VocalSynthesis vocalSynthesis;
    private ArrayList<VocalSynthesis> listMultiThread = new ArrayList<VocalSynthesis>();
    public boolean stopVocal=false;
    private Integer speakReturn = 0;
    private Integer indexList=0;
    private Integer indexList2=0;
    private boolean alternVal=false;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            print_states_vocal();
        }
    };

    //METHODES
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // SET CONTENT
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //INSTANCE OF OTHER CLASS
        final ResetActivity resetActivity = new ResetActivity();




        //INTANCE OF DIFFERENTS TEXTVIEW
        final TextView home_principal_textview = (TextView)findViewById(R.id.home_principal_textView);
        final TextView home_number_textview = (TextView)findViewById(R.id.home_number_textView);

       //INSTANCE OF DIFFERENTS BUTTON
        final android.support.design.widget.FloatingActionButton home_play_button = (android.support.design.widget.FloatingActionButton)findViewById(R.id.home_play_button);
        final Button home_reset_button = (Button)findViewById(R.id.home_reset_button);
        final android.support.design.widget.FloatingActionButton home_stop_button = (android.support.design.widget.FloatingActionButton)findViewById(R.id.home_stop_button);
        final android.support.design.widget.FloatingActionButton home_pause_button = (android.support.design.widget.FloatingActionButton)findViewById(R.id.home_pause_button);

        //ACTIONS
        //home_play_button.setText("Click here plzzzz for +1");

        //PLAY
        home_play_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //ACTION COMPTEUR
                        addition_number();
                        home_number_textview.setText(getCAST_STRING_PRINCIPAL_NUMBER());
                        //ACTION PLAY VOCAL
                        //play_vocal(getApplicationContext());
                        if (alternVal==true)
                        {
                            alternVal=false;
                        } else
                        {
                            alternVal=true;
                        }
                        playTask();
                    }
                }
        );

        //RESET
        home_reset_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        resetActivity.Reset();
                        home_number_textview.setText(Integer.toString(resetActivity.getRESET_NUMBER()));
                        setPRINCIPAL_NUMBER(resetActivity.getRESET_NUMBER());

                    }
                }
        );

        //PAUSE
        home_pause_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        for (VocalSynthesis vocalSynthesis : listMultiThread)
                        {
                            System.out.println("\n Index : " + vocalSynthesis.getUtteranceId());
                        }
                    }
                }
        );


        //STOP
        home_stop_button.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    //vocalSynthesis.tts.shutdown();

                }
            }
        );

     //   playTask();

    }


    protected void playTask(){
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                letsgo();
                //handler.sendEmptyMessage(0);
            }
        };

        //listMultiThread.add(vocalSynthesis);
        indexList2++;
        Thread vocalThread = new Thread(r);
        System.out.println("\n ID of present Thread " + vocalThread.getId());
        vocalThread.start();
    }

    protected void letsgo(){
        VocalSynthesis vocalSynthesis = new VocalSynthesis();
        vocalSynthesis.play_vocal(alternVal,getApplicationContext());
    }


    //AFFICHER STATES OF VOCAL
    protected void print_states_vocal(){
        final TextView home_vocal_state = (TextView)findViewById(R.id.home_state_vocal);
        home_vocal_state.setText(" STATES : \n Speak error code : " + vocalSynthesis.getSpeak_Return() + "\n Stop statue : " + vocalSynthesis.getStop_error() + "\n tts.SUCCES : " + vocalSynthesis.tts.SUCCESS + "\n Error during processing : " + speakReturn); //Parameter of speak'statue
    }


    //METHODE 2
    protected void addition_number(){
        //VARIABLE LOCAL
        Integer PRINCIPAL_NUMBER;
        //ACQUISION VARIABLE OF CLASS
        PRINCIPAL_NUMBER=getPRINCIPAL_NUMBER()+1;
        //RESET CONDITION
        //if (PRINCIPAL_NUMBER==10) PRINCIPAL_NUMBER=0;
        //SET VARIABLE OF CLASS
        setPRINCIPAL_NUMBER(PRINCIPAL_NUMBER);
    }


    //GETTER
    public Integer getPRINCIPAL_NUMBER(){
        return this.PRINCIPAL_NUMBER;
    }
    public String getCAST_STRING_PRINCIPAL_NUMBER(){
        this.CAST_STRING_PRINCIPAL_NUMBER=Integer.toString(getPRINCIPAL_NUMBER());
        return this.CAST_STRING_PRINCIPAL_NUMBER;
    }


    //SETTER
    public void setPRINCIPAL_NUMBER(Integer PRINCIPAL_NUMBER){
        this.PRINCIPAL_NUMBER=PRINCIPAL_NUMBER;
    }

    //SETTER
    public void setCAST_STRING_PRINCIPAL_NUMBER(String CAST_STRING_PRINCIPAL_NUMBER){
        this.CAST_STRING_PRINCIPAL_NUMBER=CAST_STRING_PRINCIPAL_NUMBER;
    }

}

