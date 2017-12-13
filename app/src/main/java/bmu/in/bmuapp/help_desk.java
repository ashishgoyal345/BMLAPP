package bmu.in.bmuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;

public class help_desk extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_desk);


        ImageView email_technical = (ImageView) findViewById(R.id.email_technical);
        email_technical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"facility.engg@bml.edu.in"};

                String subject = "Require Technical Support";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_tech = (ImageView) findViewById(R.id.call_technical);
        call_tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8572820603");
            }
        });

        ImageView email_housekeep = (ImageView) findViewById(R.id.email_cleaning);
        email_housekeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"facility.hk@bml.edu.in"};

                String subject = "Need room cleaning service";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_housekeep = (ImageView) findViewById(R.id.call_cleaning);
        call_housekeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8572820604");
            }
        });


        ImageView email_exec1 = (ImageView) findViewById(R.id.email_exec1);
        email_exec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"Helpdesk@bml.edu.in"};

                String subject = "support from executive";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_exec1 = (ImageView) findViewById(R.id.call_exec1);
        call_exec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8572820605");
            }
        });
        ImageView email_exec2 = (ImageView) findViewById(R.id.email_exec2);
        email_exec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"Helpdesk@bml.edu.in"};

                String subject = "support from executive";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_exec2 = (ImageView) findViewById(R.id.call_exec2);
        call_exec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8572820606");
            }
        });}


    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*//*");
        intent.setData(Uri.parse("mailto:Helpdesk@bml.edu.in"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);


        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void dialPhoneNumber ( String phoneNumber ) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    }
