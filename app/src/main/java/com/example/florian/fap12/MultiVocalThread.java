package com.example.florian.fap12;

/**
 * Created by Florian on 31/01/2018.
 */

public class MultiVocalThread extends Thread {

    boolean ok= false;

    public MultiVocalThread(boolean ok) {
        ok=ok;
    }


    @Override
    public void run() {
        //Execute l'action après le .start
        VocalSynthesis vocalSynthesis= new VocalSynthesis();
        for (int i=0;i<5;i++)
        {
            //vocalSynthesis.play_vocal(MainActivity.getApplicationContext());
        }


        super.run();
    }

    MultiVocalThread p = new MultiVocalThread(true);
    //p.start();


}


