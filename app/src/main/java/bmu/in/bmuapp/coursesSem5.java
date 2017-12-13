package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class coursesSem5 extends AppCompatActivity {


    String getemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_sem5);

        getemail=getIntent().getExtras().getString("email");


        Button ub=(Button)findViewById(R.id.ub);
        Button snps=(Button)findViewById(R.id.snps);
        Button sco=(Button)findViewById(R.id.sco);
        Button cn=(Button)findViewById(R.id.cn);
        Button python=(Button)findViewById(R.id.python);
        Button ir=(Button)findViewById(R.id.information_retrieval);

        ub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int1= new Intent(coursesSem5.this,dgtl_img_pro.class);
                startActivity(int1);
            }

        });

        snps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int2= new Intent(coursesSem5.this,cloud_computing.class);
                startActivity(int2);
            }

        });

        sco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int3= new Intent(coursesSem5.this,innovation.class);
                startActivity(int3);
            }

        });

        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int4= new Intent(coursesSem5.this,internetofthings.class);
                startActivity(int4);
            }

        });

        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int5= new Intent(coursesSem5.this,microprocessor.class);
                startActivity(int5);
            }

        });

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int6= new Intent(coursesSem5.this,distributed_systems.class);
                startActivity(int6);
            }

        });

    }
}
