package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void student(View v)
    {
        Intent i = new Intent(WelcomeActivity.this, LoginStudent.class);
        startActivity(i); // to start the activity
        //finish(); // so that when we press back this screen will never come

    }

    public void staff(View v)
    {
        Intent i = new Intent(WelcomeActivity.this, LoginStaff.class);
        startActivity(i); // to start the activity
        //finish(); // so that when we press back this screen will never come

    }

    public void guest(View v)
    {
        Intent i = new Intent(WelcomeActivity.this, guestMain.class);
        startActivity(i); // to start the activity
        //finish(); // so that when we press back this screen will never come

    }
}

