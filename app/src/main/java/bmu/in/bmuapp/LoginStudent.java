package bmu.in.bmuapp;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginStudent extends AppCompatActivity {

    Button btn;
    EditText e1, e2;
    String  email , passowrd , notifName ,name , getid ,enroll ,id , year , branch , semester;
    CheckBox mCbShowPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_student);

        e1 = (EditText) findViewById(R.id.user);
        e2 = (EditText) findViewById(R.id.Pass);
        Log.i("response 1","id entered");

        notifName = "default";

        mCbShowPwd = (CheckBox) findViewById(R.id.spas);

        mCbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

//        btn = (Button)findViewById(R.id.btnSingIn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                email=e1.getText().toString();
//                passowrd = e2.getText().toString();
//                Log.i("response 2","button entered");
//                LoadSearch();
//
//            }
//        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean crash(View v) {



        String s = e1.getText().toString();
        String s2 = e2.getText().toString();
        if (s.length() == 0) {
            e1.setError("Please Enter a username");
            return false;
        }
        if(s2.length()== 0)
        {
            e2.setError("Please enter the pasword");
            return false;
        }

        Click_Function();
        return true;

    }

    public void Click_Function()
    {
        email=e1.getText().toString();
                passowrd = e2.getText().toString();
                Log.i("response 2","button entered");
                LoadSearch();
    }

    public void  LoadSearch()
    {
        Log.i("response 3","json entered");
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Search_GetSet>> call = apiService.getSearch(email,passowrd );
        call.enqueue(new Callback<ArrayList<Search_GetSet>>() {

            @Override
            public void onResponse(Call<ArrayList<Search_GetSet>> call, final retrofit2.Response<ArrayList<Search_GetSet>> response) {

                //Log.i("response", response.body().get(0).getStatus());
                if(response.body().get(0).getStatus().equals("1"))
                {
                    Log.i("response 3","json entered");
                    notifName = response.body().get(0).getName();
                    enroll = response.body().get(0).getEnroll();
                    id = response.body().get(0).getId();
                    year = response.body().get(0).getYear();
                    branch = response.body().get(0).getBranch();
                    semester = response.body().get(0).getSemester();

                    clickme();
                    //Intent i = new Intent(LoginStudent.this , edit.class);
                    //i.putExtra("id", response.body().get(0).getId() );
                   // startActivity(i);
                }

                else
                {
                    pass();
                   // Intent i = new Intent(LoginStudent.this , WelcomeActivity.class);
                   // i.putExtra("id", response.body().get(0).getId() );
                     //startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Search_GetSet>>call, Throwable t) {

                Log.i("tag", t.toString());
            }
        });
    }

    public void clickme()
    {
        Log.i("email 1 : ", email);
        //loadsearch2();

        Log.i("name 1 : ",""+notifName);
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("Logged in as a Student")
                        .setContentText("Hello " +notifName);
// Gets an instance of the NotificationManager service
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

//to post your notification to the notification bar
        notificationManager.notify(0, mBuilder.build());

        Intent i = new Intent(LoginStudent.this, MainScreen.class);
        //Bundle bundle = new Bundle();
        //bundle.putString(getid, "id");
        i.putExtra("email", email );
        i.putExtra("enroll", enroll );
        i.putExtra("id", id );
        i.putExtra("name", notifName );
        i.putExtra("year", year );
        i.putExtra("branch", branch );
        i.putExtra("semester", semester );
        startActivity(i);
    }


  /*  public void  loadsearch2()
{
    Log.i("email 2 : ", email);
        ApiInterface apiService1 =
                ApiClient.getClient().create(ApiInterface.class);



        Call<ArrayList<Search_GetSet>> call = apiService1.getSearch(email);
    Log.i("email s3 : ","" +email);

        call.enqueue(new Callback<ArrayList<Search_GetSet>>() {


            @Override

            public void onResponse(Call<ArrayList<Search_GetSet>> call, final retrofit2.Response<ArrayList<Search_GetSet>> response) {

                Log.i("email 3 : ","" +email);

                notifName = response.body().get(0).getStatus();
                //notifName = response.body().get(0).getName().toString();
                getid = response.body().get(0).getId();
                Log.i("name : ", "" +notifName);
                Log.i("Id fetch : ", "" +getid);



            }

            @Override
            public void onFailure(Call<ArrayList<Search_GetSet>>call, Throwable t) {

                Log.i("tag", t.toString());
            }
        });
    Log.i("name outside : ", "" +notifName);

    }
    */


    public void pass() {
        final Dialog dialog = new Dialog(LoginStudent.this);
        dialog.setContentView(R.layout.incorrect_detail);
        dialog.setTitle("Login");

        Toast.makeText(this, "Try Again", Toast.LENGTH_LONG).show();
        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                dialog.dismiss();
                    Intent main = new Intent(LoginStudent.this, LoginStudent.class);

                    startActivity(main);

            }
        });

        dialog.show();
    }



}
