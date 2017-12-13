package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class guestMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_main);
    }

    public void nearby(View v)
    {
        Intent i = new Intent(guestMain.this, NearestFaci.class);
        startActivity(i); // to start the activity
        //finish(); // so that when we press back this screen will never come
    }

    public void website(View v)
    {
        Intent i = new Intent(guestMain.this, guest.class);
        startActivity(i); // to start the activity
        //finish(); // so that when we press back this screen will never come
    }
}
