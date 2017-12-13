package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class LibraryMan extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_man);


    }


    // to open EBSCO
    public void e1(View v)
    {
        Intent i = new Intent(LibraryMan.this, EBSCO.class);
        startActivity(i);
    }

    // to open  EMERALD
    public void e2(View v)
    {
        Intent i = new Intent(LibraryMan.this, Emerlad.class);
        startActivity(i);
    }

   // to open IEEE
    public void e3(View v)
    {
        Intent i = new Intent(LibraryMan.this, IEEE.class);
        startActivity(i);
    }

    // to open JGATE
    public void e4(View v)
    {
        Intent i = new Intent(LibraryMan.this, JGATE.class);
        startActivity(i);
    }

    // to open  PROQUEST
    public void e5(View v)
    {
        Intent i = new Intent(LibraryMan.this, PROQUEST.class);
        startActivity(i);
    }

    // to open SAGE
    public void e6(View v)
    {
        Intent i = new Intent(LibraryMan.this, SAGE.class);
        startActivity(i);
    }


    // to open more
    public void more(View v)
    {
        Intent i = new Intent(LibraryMan.this, BookDefine.class);
        startActivity(i);
    }

}
