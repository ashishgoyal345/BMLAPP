package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dcafeMess extends AppCompatActivity {

    Button sunday, monday,tuesday,wednesday,thursday,friday,saturday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcafe_mess);

        sunday=(Button)findViewById(R.id.sunday);
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sunmenu= new Intent(dcafeMess.this,SundayMenu.class);
                startActivity(sunmenu);
            }
        });
        monday=(Button)findViewById(R.id.monday);
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monmenu= new Intent(dcafeMess.this,MondayMenu.class);
                startActivity(monmenu);
            }
        });
        tuesday=(Button)findViewById(R.id.tuesday);
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tuesmenu = new Intent(dcafeMess.this, TuesdayMenu.class);
                startActivity(tuesmenu);
            }
        });
        wednesday=(Button)findViewById(R.id.wednesday);
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wedmenu = new Intent(dcafeMess.this,WednesdayMenu.class);
                startActivity(wedmenu);
            }
        });

        thursday=(Button)findViewById(R.id.thursday);
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thursmenu= new Intent(dcafeMess.this,ThursdayMenu.class);
                startActivity(thursmenu);
            }
        });
        friday=(Button)findViewById(R.id.friday);
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frimenu=new Intent(dcafeMess.this,FridayMenu.class);
                startActivity(frimenu);
            }
        });
        saturday=(Button)findViewById(R.id.saturday);
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent satmenu= new Intent(dcafeMess.this,SaturdayMenu.class);
                startActivity(satmenu);
            }
        });

    }
}


