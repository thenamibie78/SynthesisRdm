package com.example.florian.fap12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //VARIABLES
    protected Integer PRINCIPAL_NUMBER = 0;
    protected String CAST_STRING_PRINCIPAL_NUMBER="";
    protected Integer STATES_VALUE_MAIN; //Stats of vocal
    private int myId;
    private VocalSynthesis vocalSynthesis;

    //METHODES
    @Override
    protected void onCreate(Bundle savedInstanceState) {

                        // SET CONTENT
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_home);

                        //INSTANCE OF OTHER CLASS
                        final ResetActivity resetActivity = new ResetActivity();
                         vocalSynthesis = new VocalSynthesis();



                        //INTANCE OF DIFFERENTS TEXTVIEW
                        final TextView home_principal_textview = (TextView)findViewById(R.id.home_principal_textView);
                        final TextView home_number_textview = (TextView)findViewById(R.id.home_number_textView);

                       //INSTANCE OF DIFFERENTS BUTTON
                        final Button home_play_button = (Button)findViewById(R.id.home_play_button);
                        final Button home_reset_button = (Button)findViewById(R.id.home_reset_button);
                        final Button home_stop_button = (Button)findViewById(R.id.home_stop_button);
                        final Button home_pause_button = (Button)findViewById(R.id.home_pause_button);

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
                                        vocalSynthesis.play_vocal(getApplicationContext());
                                        print_states_vocal();
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
                                        print_states_vocal();
                                    }
                                }
                        );

                        //PAUSE
                        home_pause_button.setOnClickListener(
                                new Button.OnClickListener(){
                                    public void onClick(View v){
                                        STATES_VALUE_MAIN=vocalSynthesis.tts.stop();
                                        print_states_vocal();
                                    }
                                }
                        );


                        //STOP
                        home_stop_button.setOnClickListener(
                            new Button.OnClickListener(){
                                public void onClick(View v){
                                    vocalSynthesis.tts.shutdown();
                                    print_states_vocal();
                                }
                            }
                         );

    }

    //AFFICHER STATES OF VOCAL
    protected void print_states_vocal(){
        final TextView home_vocal_state = (TextView)findViewById(R.id.home_state_vocal);
        home_vocal_state.setText(" STATES : \n Speak error code : " + vocalSynthesis.getSpeak_Return() + "\n Stop statue : " + vocalSynthesis.getStop_error() + "\n tts.SUCCES : " + vocalSynthesis.tts.SUCCESS); //Parameter of speak'statue
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
