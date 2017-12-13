package bmu.in.bmuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;

public class faculty_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_info);

        ImageView email_brij = (ImageView) findViewById(R.id.email_brij);
        email_brij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"brijbihari.dubey@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_brij = (ImageView) findViewById(R.id.call_brij);
        call_brij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("9882464748");
            }
        });


        ImageView email_jaski = (ImageView) findViewById(R.id.email_jaski);
        email_jaski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"jaskiran.arora@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_jaski = (ImageView) findViewById(R.id.call_jaski);
        call_jaski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8572820603");
            }
        });


        ImageView email_rishi = (ImageView) findViewById(R.id.email_rishi);
        email_rishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"facility.engg@bml.edu.in"};

                String subject = "";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_rishi = (ImageView) findViewById(R.id.call_rishi);
        call_rishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8295200168");
            }
        });




        ImageView email_richa = (ImageView) findViewById(R.id.email_richa);
        email_richa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"richa.sharma@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_richa = (ImageView) findViewById(R.id.call_richa);
        call_richa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("9811382844");
            }
        });

        ImageView email_ziya = (ImageView) findViewById(R.id.email_ziya);
        email_ziya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"ziya.uddin@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_ziya = (ImageView) findViewById(R.id.call_ziya);
        call_ziya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("9990288377");
            }
        });

        ImageView email_kalluri = (ImageView) findViewById(R.id.email_kalluri);
        email_kalluri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"kalluri.vinayak@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_kalluri = (ImageView) findViewById(R.id.call_kalluri);
        call_kalluri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8826298844");
            }
        });

        ImageView email_swati = (ImageView) findViewById(R.id.email_swati);
        email_swati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"swati.jha@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_swati = (ImageView) findViewById(R.id.call_swati);
        call_swati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("9810751114");
            }
        });


        ImageView email_maheshwar = (ImageView) findViewById(R.id.email_maheshwar);
        email_maheshwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"maheshwar.dwivedy@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_maheshwar = (ImageView) findViewById(R.id.call_maheshwar);
        call_maheshwar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("9166692602");
            }
        });

        ImageView email_sohrab = (ImageView) findViewById(R.id.email_dip);
        email_sohrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"soharab.hossain@bml.edu.in"};

                String subject = " ";
                composeEmail(addresses, subject);

            }
        });

        ImageView call_sohrab = (ImageView) findViewById(R.id.call_dip);
        call_sohrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8376027586");
            }
        });

    }




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


    public void brijsir(View v)
    {
        Intent i = new Intent(faculty_info.this, brij.class);
        startActivity(i);
    }

    public void barman(View v)
    {
        Intent i = new Intent(faculty_info.this, barman.class);
        startActivity(i);
    }

    public void jaskiran(View v)
    {
        Intent i = new Intent(faculty_info.this, jaskiran.class);
        startActivity(i);
    }

    public void kalluri(View v)
    {
        Intent i = new Intent(faculty_info.this, kalluri.class);
        startActivity(i);
    }

    public void richa(View v)
    {
        Intent i = new Intent(faculty_info.this, richa.class);
        startActivity(i);
    }

    public void rishi(View v)
    {
        Intent i = new Intent(faculty_info.this, rishi.class);
        startActivity(i);
    }

    public void shorbh(View v)
    {
        Intent i = new Intent(faculty_info.this, shohrab.class);
        startActivity(i);
    }

    public void swati(View v)
    {
        Intent i = new Intent(faculty_info.this, swati.class);
        startActivity(i);
    }

    public void ziya(View v)
    {
        Intent i = new Intent(faculty_info.this, ziya.class);
        startActivity(i);
    }

    public void maheshwar(View v)
    {
        Intent i = new Intent(faculty_info.this, maheswar.class);
        startActivity(i);
    }

}
