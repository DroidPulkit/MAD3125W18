package com.example.macstudent.thunder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        final Context context = this;
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(Exception e){
                    Log.e("Launcher","Thread wait Failed");
                }
                finally{
                    Intent loginIntent = new Intent(context, LoginActivity.class);
                    startActivity(loginIntent);

                }

            }
        };

        timer.start();

    }
}
