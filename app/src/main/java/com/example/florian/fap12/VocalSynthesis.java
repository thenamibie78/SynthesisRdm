package com.example.florian.fap12;


import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by Florian on 29/01/2018.
 */

public class VocalSynthesis extends AppCompatActivity implements OnInitListener{

    private CharSequence Spitch; //Le texte a lire
    private String utteranceId; // ID quelconque pour la fonction speak
    private Integer Speak_Return;
    private Integer Stop_error;
    private Integer result;
    public TextToSpeech tts;
    private TextToSpeech.OnInitListener tts_Listener;

    //CONSTRUCTOR
    public VocalSynthesis() {
        Spitch = null;
        this.utteranceId = null;
        Speak_Return = 0;
        Stop_error = 0;
        this.tts = null;
    }


    //PLAY VOCAL
    public void play_vocal(Context context){
        //INIT
        Spitch = "Text test test test for read  ";
        utteranceId="First";

            //TextToSpeed INIT & CONFIGURATION
            tts = new TextToSpeech(context, ??? ); //Je ne comprend pas le 2ème paramètre
            //SPEAK FUNCTION
            Speak_Return = tts.speak(Spitch, tts.QUEUE_ADD, null, utteranceId);
    }

    public Integer getSpeak_Return() {
        return Speak_Return;
    }
    public Integer getStop_error() {
        return Stop_error;
    }

    //CETTE FONCTION onInit EST APPARU TOUTE SEULE!!
    @Override
    public void onInit(int i) {
        {
            //Config & Language & Speed Rate
            if (i== tts.SUCCESS) tts.setLanguage(Locale.UK);
        }
    }
}
