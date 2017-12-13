package bmu.in.bmuapp;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.PendingIntent;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;

public class culinary_club extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinary_club);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DocumentView documentView = new DocumentView(this, DocumentView.PLAIN_TEXT);  // Support plain text
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        // Backend Work

        FloatingActionButton favorites_fab = (FloatingActionButton) findViewById(R.id.favorites_fab);
        favorites_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    notificaton();

                Toast.makeText(getApplicationContext(),"Culinary Club added to your Favourites",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), culinary_club.class);

            }
        });


        ImageView email1 = (ImageView) findViewById(R.id.email1shrutit);
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"shruti.sharma.14cse@bml.edu.in"};

                String subject = "Culinary Club";
                composeEmail(addresses, subject);

            }
        });

        ImageView call1 = (ImageView) findViewById(R.id.call1shruti);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("8198907907");
            }
        });


        // for tushar

        ImageView email2 = (ImageView) findViewById(R.id.email1tushar);
        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] addresses = {"tushar.bhatia.15cse@bml.edu.in"};

                String subject = "Culinary Club";
                composeEmail(addresses, subject);

            }
        });

        ImageView call2 = (ImageView) findViewById(R.id.call1tushar);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialPhoneNumber("9868522945");
            }
        });


    }


public void notificaton()
{
    //set intents and pending intents to call activity on click of "show activity" action button of notification
    Intent resultIntent = new Intent(this, MainActivity.class);
    resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
            | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    PendingIntent piResult = PendingIntent.getActivity(this,
            (int) Calendar.getInstance().getTimeInMillis(), resultIntent, 0);

//Assign inbox style notification
    NotificationCompat.InboxStyle inboxStyle =
            new NotificationCompat.InboxStyle();

    inboxStyle.setBigContentTitle("Upcoming Events");
    inboxStyle.addLine("1.Hooglathon");
    inboxStyle.addLine("2.Barbeque");
    inboxStyle.addLine("3.Pool Party");
    inboxStyle.addLine("4.Workshop At taj");
    inboxStyle.addLine("5.Sandwich Smackdown");
    inboxStyle.setSummaryText("+2 more");

    //build notification
    NotificationCompat.Builder mBuilder =
            (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.icon)
                    .setContentTitle("Culinary Club Added to your Fav.")
                    .setContentText("Swipe Down to see Events")
                    .setStyle(inboxStyle)
                    .addAction(R.mipmap.ic_launcher, "show activity", piResult);

    // Gets an instance of the NotificationManager service
    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    //to post your notification to the notification bar
    notificationManager.notify(0, mBuilder.build());

}

    private void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*//*");
        intent.setData(Uri.parse("mailto:"));     //only e-mail apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);


        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber ( String phoneNumber ) {
        Intent intent = new Intent ( Intent.ACTION_DIAL);
        intent . setData ( Uri. parse ( "tel:" + phoneNumber ));
        if ( intent . resolveActivity ( getPackageManager ()) != null) {
            startActivity ( intent );
        }

    }

    public void e1(View v)
    {
       /*
        final Dialog dialog = new Dialog(culinary_club.this);
        dialog.setContentView(R.layout.popup1_cc);
        dialog.setTitle("masterchef 2k17");
        Button btnmore = (Button) dialog.findViewById(R.id.more);
       Button btnback = (Button) dialog.findViewById(R.id.back);

        btnmore.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                  dialog.dismiss();
                    Intent main = new Intent(culinary_club.this, masterchef2k17.class);

                    startActivity(main);
            }
        });

       btnback.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(culinary_club.this,
                        "Back to Club", Toast.LENGTH_LONG)
                        .show();
                Intent main = new Intent(culinary_club.this, culinary_club.class);

                startActivity(main);
            }
        });

*/
        Intent i = new Intent(culinary_club.this, masterchef2k17.class);
        startActivity(i);
    }
}
