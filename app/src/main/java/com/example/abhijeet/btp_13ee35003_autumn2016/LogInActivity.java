package com.example.abhijeet.btp_13ee35003_autumn2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    /**
     * This method is called when the Log In button is clicked.
     */
    public void logIn(View view) {
        //get the username
        EditText username = (EditText) findViewById(R.id.username_field);

        //get the password
        EditText password = (EditText) findViewById(R.id.password_field);

        if ( checkPassword(username.getText(), password.getText() ) ) {

            // Create an explicit Intent for starting the MainActivity
            Intent helloAndroidIntent = new Intent(LogInActivity.this, MainActivity.class);
            // Use the Intent to start the HelloAndroid Activity
            startActivity(helloAndroidIntent);
        } else {
            //Show an error message as toast
            Toast.makeText(this, "Entered wrong username/passwored.\nTry again", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Checks username & password correctness
     *
     * @param username provided by user
     * @param password entered by user
     *
     * @return true if username & password is correct otherwise returns false.
     */
    private boolean checkPassword( Editable username, Editable password) {
        // Just pretending to extract text and check password
        String userName="13ee35003";
        String passWord="pass";
        if(username.toString().equals(userName) && password.toString().equals(passWord))
            return true;
        else
            return false;
    }

    /**
     * This method is called when public LogIn button is clicked
     */
    public void publicLogIn(View view) {
        // Create an explicit Intent for starting the HelloAndroid Activity
        Intent helloAndroidIntent = new Intent(LogInActivity.this, MapsActivity.class);
        // Use the Intent to start the HelloAndroid Activity
        startActivity(helloAndroidIntent);

    }
}
