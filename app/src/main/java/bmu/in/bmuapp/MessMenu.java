package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MessMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void sodexo(View v)
    {
        Intent i = new Intent(MessMenu.this, dcafeMess.class);
        startActivity(i);
    }


    public void dcafe(View v)
    {
        Intent i = new Intent(MessMenu.this, dcafeMess.class);
        startActivity(i);
    }
}
