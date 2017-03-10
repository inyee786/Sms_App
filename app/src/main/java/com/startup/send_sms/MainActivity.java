package com.startup.send_sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.csms);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMS();
            }
        });
    }



    protected void sendSMS() {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

            smsIntent.setData(Uri.parse("smsto:"));
            smsIntent.setType("vnd.android-dir/mms-sms");

    //set the contact number
            smsIntent.putExtra("address"  , new String ("01234"));
    //set text message to send
            smsIntent.putExtra("sms_body"  ,  "Your Location is " );

            try {
                startActivity(smsIntent);
                finish();
                Log.i("Finished sending SMS...", "");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainActivity.this,
                        "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
            }
           }







    }













//function to open the message

/*        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                /** Creating an intent to initiate view action */
//Intent intent = new Intent("android.intent.action.VIEW");

    /** creates an sms uri */
  //  Uri data = Uri.parse("sms:");

/** Setting sms uri to the intent */
//intent.setData(data);

        /** Initiates the SMS compose screen, because the activity contain ACTION_VIEW and sms uri */
        //startActivity(intent);
        //}
      //  };

        /** Getting a reference to the button "btn_compose" of the main.xml */
    //    Button btn_compose = (Button) findViewById(R.id.csms);

        /** Setting an onClick event listener */
  //      btn_compose.setOnClickListener(listener);

