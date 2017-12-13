package bmu.in.bmuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public static String getemail;
    public static String getenroll;
    public static String getid;
    public static String getname;
    public static String getyear;
    public static String getbranch;
    public static String getsemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getemail=getIntent().getExtras().getString("email");
        getenroll=getIntent().getExtras().getString("enroll");
        getid=getIntent().getExtras().getString("id");
        getname=getIntent().getExtras().getString("name");
        getyear=getIntent().getExtras().getString("year");
        getbranch=getIntent().getExtras().getString("branch");
        getsemester=getIntent().getExtras().getString("semester");




        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment_Student()).commit();









        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome " +getname, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        TextView t1 = (TextView)findViewById(R.id.navname);
        TextView t2 = (TextView)findViewById(R.id.navbranch);
        TextView t3 = (TextView)findViewById(R.id.navyear);
        TextView t4 = (TextView)findViewById(R.id.navemail);
      // CircleImageView i = (CircleImageView) findViewById(R.id.mainimage);



        t1.setText("" +getname);
        t2.setText("Btech " +getbranch);
        t3.setText("" +getyear +" Year");
        t4.setText("" +getemail);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_courses) {


            if (getsemester.equals("7"))
            {
                Intent i = new Intent(MainScreen.this, courses.class);
                i.putExtra("email", getemail );
                startActivity(i);
            }
            else if (getsemester.equals("5")) {
                Intent i = new Intent(MainScreen.this, coursesSem5.class);
                i.putExtra("email", getemail);
                startActivity(i);
            }
            // Handle the camera action
        } else if (id == R.id.lib_managment) {

            Intent i = new Intent(MainScreen.this, LibraryMan.class);
            startActivity(i);

        } else if (id == R.id.nav_helpdesk) {

            Intent i = new Intent(MainScreen.this, help_desk.class);
            startActivity(i);

        } else if (id == R.id.nav_clubs) {

            Intent i = new Intent(MainScreen.this, clubs.class);
            startActivity(i);

        }else if (id == R.id.mess) {

            Intent i = new Intent(MainScreen.this, MessMenu.class);
            startActivity(i);

        }

        else if (id == R.id.fac_info) {
            Intent i = new Intent(MainScreen.this, faculty_info.class);
            startActivity(i);

        } else if (id == R.id.nav_attandance) {
            Intent i = new Intent(MainScreen.this, AttendanceNishant.class);
            startActivity(i);

        }

        else if (id == R.id.nav_aboutus)
        {
            Intent i = new Intent(MainScreen.this, aboutus.class);
            startActivity(i);
        }

        else if (id == R.id.nav_send)
        {
            Intent i = new Intent(MainScreen.this, WelcomeActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
