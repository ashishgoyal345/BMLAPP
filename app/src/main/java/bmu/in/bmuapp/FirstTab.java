package bmu.in.bmuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;

import static android.content.Context.CAMERA_SERVICE;
import static bmu.in.bmuapp.MainScreen.getemail;
import static bmu.in.bmuapp.MainScreen.getenroll;
import static bmu.in.bmuapp.MainScreen.getid;


public class FirstTab extends Fragment {

    String  firstemail ;
    public String enroll;
    public String id , record , mess ,mentor , club , currclass , teacher , roomno , clubin;

    public FirstTab() {
       firstemail =  getemail;
        Log.i("email inside  : ", "" +getemail);
        enroll = getenroll;
        Log.i("enroll fetch  : ", "" +enroll);
        id = getid;
        Log.i("id fetch  : ", "" +id);
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final View contentView = inflater.inflate(R.layout.student_first, container, false);

       // enroll = " null value";

        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(""))

        //getArguments().getString("String");//String text



        Log.i("email inside  : ", "" +firstemail);



        final TextView tid3 =(TextView) contentView.findViewById(R.id.mr2);
        final TextView tid2 =(TextView) contentView.findViewById(R.id.mes1);
        final TextView tid4 =(TextView) contentView.findViewById(R.id.club1);
        final TextView tid6 =(TextView) contentView.findViewById(R.id.c2);
        final TextView tid5 =(TextView) contentView.findViewById(R.id.cr1);
        final TextView tid7 =(TextView) contentView.findViewById(R.id.dr11);

        //loadsearch2();


        Log.i("email 2 : ", ""+getemail);
        ApiInterface apiService1 =
                ApiClient.getClient().create(ApiInterface.class);



        Call<ArrayList<Search_GetSet>> call = apiService1.getSearch(id);
        Log.i("id s3 : ","" +id);

        call.enqueue(new Callback<ArrayList<Search_GetSet>>() {


            @Override

            public void onResponse(Call<ArrayList<Search_GetSet>> call, final retrofit2.Response<ArrayList<Search_GetSet>> response) {

                Log.i("enroll out : ","" +enroll);

                //setText(response.body().get(0).getStatus());

                //settext.response.body().get(0).getStatus();
                record=response.body().get(0).getStatus();
                mess=response.body().get(0).getMess();
                mentor=response.body().get(0).getMentor();
                club=response.body().get(0).getClub();
                currclass=response.body().get(0).getCurrclass();
                teacher=response.body().get(0).getTeacher();
                roomno=response.body().get(0).getRoomno();
                clubin=response.body().get(0).getClubin();






                TextView tid1 =(TextView) contentView.findViewById(R.id.q2);
                tid1.setText("" +record);


                tid2.setText("Mess Enrolled : " +mess);


                tid3.setText("" +mentor);

                Log.i("enroll inside  : ", "" +mentor);


                tid4.setText("" +club);


                tid5.setText("" +currclass);


                tid7.setText("by " +teacher);


                tid6.setText("Room no : " +roomno);



            }

            @Override
            public void onFailure(Call<ArrayList<Search_GetSet>>call, Throwable t) {

                Log.i("tag", t.toString());
            }
        });
        Log.i("name outside : ", "" +mentor);


        TextView tid =(TextView) contentView.findViewById(R.id.test1);
        tid.setText("Your Id No : " +enroll);


        //Enrollment Number Query




        TextView t =(TextView) contentView.findViewById(R.id.cr1);
        t.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), internetofthings.class);
                startActivity(i);
            }
        });

        //TextView t1 =(TextView) contentView.findViewById(R.id.mr2);
        tid3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                if (mentor == "Dr.Maheshwar Dwidey") {
                    Intent i = new Intent(getActivity(), maheswar.class);
                    startActivity(i);
                }

                else if (mentor == "Dr.Vinayak Kalluri") {
                    Intent i = new Intent(getActivity(), kalluri.class);
                    startActivity(i);
                }

                else if (mentor == "Richa Sharma") {
                    Intent i = new Intent(getActivity(), richa.class);
                    startActivity(i);
                }
            }
        });

       // TextView t2 =(TextView) contentView.findViewById(R.id.mes1);
        tid2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                if ( mess == "DCafe") {
                    Intent i = new Intent(getActivity(), dcafeMess.class);
                    startActivity(i);
                }
                else if ( mess == "LBF")
                {
                    Intent i = new Intent(getActivity(), sodexoMess.class);
                    startActivity(i);
                }
            }
        });

        TextView t3 =(TextView) contentView.findViewById(R.id.club1);
        t3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), culinary_club.class);
                startActivity(i);
            }
        });


         TextView t4 =(TextView) contentView.findViewById(R.id.near);
        t4.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), NearestFaci.class);
                startActivity(i);
            }
        });


        TextView t5 =(TextView) contentView.findViewById(R.id.complete_tt);
        t5.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), fulltimetable.class);
                startActivity(i);
            }
        });

        TextView t6 =(TextView) contentView.findViewById(R.id.paccl);
        t6.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), pacclub.class);
                startActivity(i);
            }
        });
        return  contentView;
    }



  /*  public void   loadsearch2()
    {
        Log.i("email 2 : ", ""+getemail);
        ApiInterface apiService1 =
                ApiClient.getClient().create(ApiInterface.class);



        Call<ArrayList<Search_GetSet>> call = apiService1.getSearch(id);
        Log.i("id s3 : ","" +id);

        call.enqueue(new Callback<ArrayList<Search_GetSet>>() {


            @Override

            public void onResponse(Call<ArrayList<Search_GetSet>> call, final retrofit2.Response<ArrayList<Search_GetSet>> response) {

                Log.i("enroll out : ","" +enroll);

                //setText(response.body().get(0).getStatus());

                //settext.response.body().get(0).getStatus();
                 record=response.body().get(0).getStatus();
                mess=response.body().get(0).getMess();
                mentor=response.body().get(0).getMentor();

               Log.i("enroll inside  : ", "" +mentor);



            }

            @Override
            public void onFailure(Call<ArrayList<Search_GetSet>>call, Throwable t) {

                Log.i("tag", t.toString());
            }
        });
        //Log.i("name outside : ", "" +notifName);

    }


*/


}