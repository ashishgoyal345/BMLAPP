package bmu.in.bmuapp;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.DialogInterface;

public class CSEBOOKS extends AppCompatActivity {

    Button btn , btn1 , btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csebooks);

        btn = (Button)findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click1();
            }
        });


        btn1 = (Button)findViewById(R.id.b2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click2();
            }
        });

        btn2 = (Button)findViewById(R.id.b3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click3();
            }
        });
    }

    public void click1()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("KRC- Library");
        builder.setMessage("Are you sure you want to issue the book?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                noticlick1();
            }
        })
                .setNegativeButton("cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You can issue any time",Toast.LENGTH_SHORT).show();

                    }
                });

        // Create the AlertDialog object and return it
        builder.create().show();


    }


    public void noticlick1()
    {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("KRC- LIBRARY")
                        .setContentText("Your Request for Introduction to Algorithm has been processed");
// Gets an instance of the NotificationManager service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//to post your notification to the notification bar
        notificationManager.notify(0, mBuilder.build());

        Toast.makeText(getApplicationContext(),"After confirmation You will be notify once again",Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), CSEBOOKS.class);
    }


    public void click2()
    {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("KRC- LIBRARY")
                        .setContentText("Your Request for C Programming has been processed");
// Gets an instance of the NotificationManager service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//to post your notification to the notification bar
        notificationManager.notify(0, mBuilder.build());

        Toast.makeText(getApplicationContext(),"After confirmation You will be notify once again",Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), CSEBOOKS.class);
    }


    public void click3()
    {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("KRC- LIBRARY")
                        .setContentText("Your Request for Art of Computer Programming has been processed");
// Gets an instance of the NotificationManager service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//to post your notification to the notification bar
        notificationManager.notify(0, mBuilder.build());

        Toast.makeText(getApplicationContext(),"After confirmation You will be notify once again",Toast.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), CSEBOOKS.class);
    }
}
