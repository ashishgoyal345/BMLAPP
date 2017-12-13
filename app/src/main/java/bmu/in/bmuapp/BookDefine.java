package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BookDefine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_define);
    }

    public void cse(View v)
    {
        Intent i = new Intent(BookDefine.this, CSEBOOKS.class);
        startActivity(i);
    }
}
