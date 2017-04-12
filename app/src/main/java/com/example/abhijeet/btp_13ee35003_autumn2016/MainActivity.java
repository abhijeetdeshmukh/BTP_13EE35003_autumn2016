package com.example.abhijeet.btp_13ee35003_autumn2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting reference to the Central library button
        Button centralLibrary = (Button) findViewById(R.id.btn_central_library);
        // Defining click event listener for the button centralLibrary
        centralLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThingSpeakActivity.class);
                intent.putExtra("channelId", getResources().getInteger(R.integer.channel_id_central_library));
                // Use the Intent to start the HelloAndroid Activity
                startActivity(intent);
            }
        });

//        // Getting reference to the Dept. of EE button
//        Button ee = (Button) findViewById(R.id.btn_ee);
//        // Defining click event listener for the button ee
//        ee.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ThingSpeakActivity.class);
//                intent.putExtra("channelId", getResources().getInteger(R.integer.channel_id_ee));
//                // Use the Intent to start the HelloAndroid Activity
//                startActivity(intent);
//            }
//        });

        // Getting reference to the TSG button
        Button tsg = (Button) findViewById(R.id.btn_tsg);
        // Defining click event listener for the button tsg
        tsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open google Map
                Intent intent = new Intent(MainActivity.this, ThingSpeakActivity.class);
                intent.putExtra("channelId", getResources().getInteger(R.integer.channel_id_tsg));
                // Use the Intent to start the HelloAndroid Activity
                startActivity(intent);
            }
        });

        // Getting reference to the Nehru Musium button
        Button nehru = (Button) findViewById(R.id.btn_nehru_musium);
        // Defining click event listener for the button nehru
        nehru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open google Map
                Intent intent = new Intent(MainActivity.this, ThingSpeakActivity.class);
                intent.putExtra("channelId", getResources().getInteger(R.integer.channel_id_nehru_musium));
                // Use the Intent to start the HelloAndroid Activity
                startActivity(intent);
            }
        });

//        // Getting reference to the dummy channel button
//        Button dummy = (Button) findViewById(R.id.btn_dummy);
//        // Defining click event listener for the button dummy
//        dummy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open google Map
//                Intent intent = new Intent(MainActivity.this, ThingSpeakActivity.class);
//                intent.putExtra("channelId", getResources().getInteger(R.integer.channel_id_dummy));
//                // Use the Intent to start the ThingSpeakActivity Activity
//                startActivity(intent);
//            }
//        });

    }

}
