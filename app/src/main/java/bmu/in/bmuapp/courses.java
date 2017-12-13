package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class courses extends AppCompatActivity {


String getemail;
    @Override
    protected void onCreate(Bundle savedInstanceState){


        getemail=getIntent().getExtras().getString("email");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        Button dip=(Button)findViewById(R.id.button1);
        Button cc=(Button)findViewById(R.id.button2);
        Button ied=(Button)findViewById(R.id.button3);
        Button iot=(Button)findViewById(R.id.button4);
        Button mb=(Button)findViewById(R.id.button5);
        Button ds=(Button)findViewById(R.id.button6);

        dip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(courses.this,dgtl_img_pro.class);
                startActivity(int1);
            }

        });

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int2= new Intent(courses.this,cloud_computing.class);
                startActivity(int2);
            }

        });

        ied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int3= new Intent(courses.this,innovation.class);
                startActivity(int3);
            }

        });

        iot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int4= new Intent(courses.this,internetofthings.class);
                startActivity(int4);
            }

        });

        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int5= new Intent(courses.this,microprocessor.class);
                startActivity(int5);
            }

        });

        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int6= new Intent(courses.this,distributed_systems.class);
                startActivity(int6);
            }

        });


    }
}