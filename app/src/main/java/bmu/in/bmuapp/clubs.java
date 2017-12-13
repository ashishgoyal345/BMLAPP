package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class clubs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void cul_club(View v)
    {
        Intent i = new Intent(clubs.this, culinary_club.class);
        startActivity(i);
    }

        public void pac_club(View v)
    {
        Intent i = new Intent(clubs.this, pacclub.class);
        startActivity(i);
    }


}
