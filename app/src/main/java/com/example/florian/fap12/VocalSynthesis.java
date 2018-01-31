package com.example.florian.fap12;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by Florian on 29/01/2018.
 */

public class VocalSynthesis implements OnInitListener{

    private CharSequence Spitch; //Le texte a lire
    private String utteranceId; // ID quelconque pour la fonction speak
    private Integer Speak_Return;
    private Integer Stop_error;
    private Integer result;
    private boolean returnError=false;
    private boolean returnStopProgress=false;
    public TextToSpeech tts;


    //CONSTRUCTOR
    public VocalSynthesis() {
        Spitch = null;
        this.utteranceId = null;
        Speak_Return = 0;
        Stop_error = 0;
        this.tts = null;
    }




    //PLAY VOCAL. RETOURNE un code d'erreur de processing vocal
    public void play_vocal(boolean alternVar,Context context){
        //INIT
        if (!alternVar)
        {
            Spitch = "Text test for read  ";
            utteranceId="Premiere";
        } else
        {
            Spitch = "Banana banana on my dream";
            utteranceId="Banana";
        }


        //TextToSpeed INIT & CONFIGURATION
        tts = new TextToSpeech(context, this );
    }

    public Integer getSpeak_Return() {
        return Speak_Return;
    }
    public Integer getStop_error() {
        return Stop_error;
    }

    @Override
    public void onInit(int i) {
        {
            //Config & Language & Speed Rate
            //tts.setLanguage(Locale.UK);
            //SPEAK FUNCTION
            Log.i("onInit", "\n Initialisation du processing done \n");
            int k;
            for (k=0;k<2;k++)
            {
                Speak_Return = tts.speak(Spitch, tts.QUEUE_ADD, null, utteranceId);
            }

        }
    }

    public String getUtteranceId() {
        return utteranceId;
    }
}
