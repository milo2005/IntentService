package com.example.estacionvl_tc_014.intentservice.services;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;


public class ContadorService extends IntentService {

    public static final String ACTION_1="accion 1";
    public static final String ACTION_2="accion 2";
    public static final String ACTION_3="accion 3";

    public ContadorService() {
        super("ContadorService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(intent.getAction().equals(ACTION_1)){
            action1();
        }else if(intent.getAction().equals(ACTION_2)){
            action2();
        }else{
            action3();
        }
    }

    private void action3() {

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Servicio Contador")
                .setContentText("Contando ...")
                .setSmallIcon(android.R.drawable.ic_media_play)
                .build();

        startForeground(101,notification);

        for(int i = 0;i<15;i++){
            try {
                Thread.sleep(1000);
                Log.i("ContadorServicio", "Segundos:"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopForeground(true);

    }

    private void action2() {
        Log.i("ContadorServicio","Entro en Accion 2");
    }

    private void action1() {
        Log.i("ContadorServicio","Entro en Accion 1");
    }


}
