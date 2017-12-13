package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class sodexoMess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sodexo_mess);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void menuopen(View v)
    {
        Intent i = new Intent(sodexoMess.this, sodexomenu.class);
        startActivity(i);
    }
}
