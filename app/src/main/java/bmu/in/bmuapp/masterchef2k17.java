package bmu.in.bmuapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class masterchef2k17 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterchef2k17);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    public void e4(View v)
    {
        Intent i = new Intent(masterchef2k17.this, cul_photoalbum.class);
        startActivity(i);
    }



}
