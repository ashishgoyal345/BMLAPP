package bmu.in.bmuapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class AttendanceNishant extends AppCompatActivity {
    private ProgressDialog pDialog;

    HashMap<String, String> attendanceHashMap;        //new

    // JSON Node names
    private static final String TAG_ATTENDANCE = "attendance";  //TAG_SATURDAY = "saturdaymenu"

    private static final String TAG_AI_SESSIONS_COMP = "AI_SESSIONS_COMP";   //   TAG_DRY_CEREAL = "DRY_CEREAL"
    private static final String TAG_AI_PRESENT = "AI_PRESENT";     //   TAG_DRINK_ONE = "DRINK_ONE"
    private static final String TAG_AI_ABSENT = "AI_ABSENT";       //   TAG_DRINK_TWO = "DRINK_TWO"
    private static final String TAG_AI_LATE = "AI_LATE";           //   TAG_MAIN = "MAIN"
    private static final String TAG_AI_EXCUSED = "AI_EXCUSED";     //   TAG_ACCOMPANIMENT = "ACCOMPANIMENT"
    private static final String TAG_AI_ATT_GRADE = "AI_ATT_GRADE";  //   TAG_B_BREAD = "B_BREAD"
    private static final String TAG_AI_GRADE = "AI_GRADE";           //   TAG_L_SALAD = "L_SALAD"
    private static final String TAG_AI_GRADE_WITH_EXCUSED = "AI_GRADE_WITH_EXCUSED"; //TAG_L_RICE = "L_RICE"

    private static final String TAG_CG_SESSIONS_COMP = "CG_SESSIONS_COMP";               //TAG_L_DAL = "L_DAL"
    private static final String TAG_CG_PRESENT = "CG_PRESENT";         //TAG_L_PANEER = "L_PANEER";
    private static final String TAG_CG_ABSENT = "CG_ABSENT";             //TAG_L_SEMI = "L_SEMI"
    private static final String TAG_CG_LATE = "CG_LATE";           //TAG_L_GRAVY = "L_GRAVY"
    private static final String TAG_CG_EXCUSED = "CG_EXCUSED";        //TAG_L_DESSERT = "L_DESSERT"
    private static final String TAG_CG_ATT_GRADE = "CG_ATT_GRADE";            //TAG_L_BREAD = "L_BREAD"
    private static final String TAG_CG_GRADE = "CG_GRADE";               //TAG_L_CURD = "L_CURD
    private static final String TAG_CG_GRADE_WITH_EXCUSED = "CG_GRADE_WITH_EXCUSED";  //TAG_SNACKS = "SNACKS"

    private static final String TAG_CC_SESSIONS_COMP = "CC_SESSIONS_COMP";                 //TAG_DRINK = "DRINK"
    private static final String TAG_CC_PRESENT = "CC_PRESENT";              //TAG_D_SALAD = "D_SALAD"
    private static final String TAG_CC_ABSENT = "CC_ABSENT";               //TAG_D_RICE = "D_RICE"
    private static final String TAG_CC_LATE = "CC_LATE";                 // TAG_D_DAL = "D_DAL"
    private static final String TAG_CC_EXCUSED = "CC_EXCUSED";           //TAG_D_PANEER = "D_PANEER"
    private static final String TAG_CC_ATT_GRADE = "CC_ATT_GRADE";               //TAG_D_SEMI = "D_SEMI"
    private static final String TAG_CC_GRADE = "CC_GRADE";               //TAG_D_GRAVY = "D_GRAVY"
    private static final String TAG_CC_GRADE_WITH_EXCUSED = "CC_GRADE_WITH_EXCUSED"; //TAG_D_DESSERT = "D_DESSERT"


    private static final String TAG_GC_SESSIONS_COMP = "GC_SESSIONS_COMP";                 //TAG_D_BREAD = "D_BREAD"
    private static final String TAG_GC_PRESENT = "GC_PRESENT";                  //TAG_D_CURD = "D_CURD"
    private static final String TAG_GC_ABSENT = "GC_ABSENT";
    private static final String TAG_GC_LATE = "GC_LATE";
    private static final String TAG_GC_EXCUSED = "GC_EXCUSED";
    private static final String TAG_GC_ATT_GRADE = "GC_ATT_GRADE";
    private static final String TAG_GC_GRADE = "GC_GRADE";
    private static final String TAG_GC_GRADE_WITH_EXCUSED = "GC_GRADE_WITH_EXCUSED";

    private static final String TAG_PCS_SESSIONS_COMP = "PCS_SESSIONS_COMP";
    private static final String TAG_PCS_PRESENT = "PCS_PRESENT";
    private static final String TAG_PCS_ABSENT = "PCS_ABSENT";
    private static final String TAG_PCS_LATE = "PCS_LATE";
    private static final String TAG_PCS_EXCUSED = "PCS_EXCUSED";
    private static final String TAG_PCS_ATT_GRADE = "PCS_ATT_GRADE";
    private static final String TAG_PCS_GRADE = "PCS_GRADE";
    private static final String TAG_PCS_GRADE_WITH_EXCUSED = "PCS_GRADE_WITH_EXCUSED";

    private static final String TAG_NDT_SESSIONS_COMP = "NDT_SESSIONS_COMP";
    private static final String TAG_NDT_PRESENT = "NDT_PRESENT";
    private static final String TAG_NDT_ABSENT = "NDT_ABSENT";
    private static final String TAG_NDT_LATE = "NDT_LATE";
    private static final String TAG_NDT_EXCUSED = "NDT_EXCUSED";
    private static final String TAG_NDT_ATT_GRADE = "NDT_ATT_GRADE";
    private static final String TAG_NDT_GRADE = "NDT_GRADE";
    private static final String TAG_NDT_GRADE_WITH_EXCUSED = "NDT_GRADE_WITH_EXCUSED";

    // contacts JSONArray
    JSONArray attendance = null;

    TextView aisessions,aipresent,aiabsent,ailate,aiexcused,aiattgrade,aigrade,aigradeexcuse,
            cgsessions,cgpresent,cgabsent,cglate,cgexcused,cgattgrade,cggrade,cggradeexcuse,
            ccsessions,ccpresent,ccabsent,cclate,ccexcused,ccattgrade,ccgrade,ccgradeexcuse,
            gcsessions,gcpresent,gcabsent,gclate,gcexcused,gcattgrade,gcgrade,gcgradeexcuse,
            pcssessions,pcspresent,pcsabsent,pcslate,pcsexcused,pcsattgrade,pcsgrade,pcsgradeexcuse,
            ndtsessions,ndtpresent,ndtabsent,ndtlate,ndtexcused,ndtattgrade,ndtgrade,ndtgradeexcuse;               //new


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);


        new GetContacts().execute();

        aisessions =(TextView)findViewById(R.id.AI_SESSIONS_COMP);
        aipresent =(TextView)findViewById(R.id.AI_PRESENT);
        aiabsent =(TextView)findViewById(R.id.AI_ABSENT);
        ailate =(TextView)findViewById(R.id.AI_LATE);
        aiexcused =(TextView)findViewById(R.id.AI_EXCUSED);
        aiattgrade =(TextView)findViewById(R.id.AI_ATT_GRADE);
        aigrade =(TextView)findViewById(R.id.AI_GRADE);
        aigradeexcuse =(TextView)findViewById(R.id.AI_GRADE_WITH_EXCUSED);

        cgsessions =(TextView)findViewById(R.id.CG_SESSIONS_COMP);
        cgpresent =(TextView)findViewById(R.id.CG_PRESENT);
        cgabsent =(TextView)findViewById(R.id.CG_ABSENT);
        cglate =(TextView)findViewById(R.id.CG_LATE);
        cgexcused =(TextView)findViewById(R.id.CG_EXCUSED);
        cgattgrade =(TextView)findViewById(R.id.CG_ATT_GRADE);
        cggrade =(TextView)findViewById(R.id.CG_GRADE);
        cggradeexcuse =(TextView)findViewById(R.id.CG_GRADE_WITH_EXCUSED);

        ccsessions =(TextView)findViewById(R.id.CC_SESSIONS_COMP);
        ccpresent =(TextView)findViewById(R.id.CC_PRESENT);
        ccabsent =(TextView)findViewById(R.id.CC_ABSENT);
        cclate =(TextView)findViewById(R.id.CC_LATE);
        ccexcused =(TextView)findViewById(R.id.CC_EXCUSED);
        ccattgrade =(TextView)findViewById(R.id.CC_ATT_GRADE);
        ccgrade =(TextView)findViewById(R.id.CC_GRADE);
        ccgradeexcuse =(TextView)findViewById(R.id.CC_GRADE_WITH_EXCUSED);

        gcsessions =(TextView)findViewById(R.id.GC_SESSIONS_COMP);
        gcpresent =(TextView)findViewById(R.id.GC_PRESENT);
        gcabsent =(TextView)findViewById(R.id.GC_ABSENT);
        gclate =(TextView)findViewById(R.id.GC_LATE);
        gcexcused =(TextView)findViewById(R.id.GC_EXCUSED);
        gcattgrade =(TextView)findViewById(R.id.GC_ATT_GRADE);
        gcgrade =(TextView)findViewById(R.id.GC_GRADE);
        gcgradeexcuse =(TextView)findViewById(R.id.GC_GRADE_WITH_EXCUSED);

        pcssessions =(TextView)findViewById(R.id.PCS_SESSIONS_COMP);
        pcspresent =(TextView)findViewById(R.id.PCS_PRESENT);
        pcsabsent =(TextView)findViewById(R.id.PCS_ABSENT);
        pcslate =(TextView)findViewById(R.id.PCS_LATE);
        pcsexcused =(TextView)findViewById(R.id.PCS_EXCUSED);
        pcsattgrade =(TextView)findViewById(R.id.PCS_ATT_GRADE);
        pcsgrade =(TextView)findViewById(R.id.PCS_GRADE);
        pcsgradeexcuse =(TextView)findViewById(R.id.PCS_GRADE_WITH_EXCUSED);

        ndtsessions =(TextView)findViewById(R.id.NDT_SESSIONS_COMP);
        ndtpresent =(TextView)findViewById(R.id.NDT_PRESENT);
        ndtabsent =(TextView)findViewById(R.id.NDT_ABSENT);
        ndtlate =(TextView)findViewById(R.id.NDT_LATE);
        ndtexcused =(TextView)findViewById(R.id.NDT_EXCUSED);
        ndtattgrade =(TextView)findViewById(R.id.NDT_ATT_GRADE);
        ndtgrade =(TextView)findViewById(R.id.NDT_GRADE);
        ndtgradeexcuse =(TextView)findViewById(R.id.NDT_GRADE_WITH_EXCUSED);

    }


    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(AttendanceNishant.this);
            pDialog.setMessage("Fetching your attendance...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Boolean doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String url = "http://attendance-nishant-7thsem.getsandbox.com/attendance_sem_seven";
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    attendance = jsonObj.getJSONArray(TAG_ATTENDANCE);

                    attendanceHashMap = new HashMap<String, String>();
                    // looping through All
                    for (int i = 0; i < attendance.length(); i++) {
                        JSONObject c = attendance.getJSONObject(i);


                        String AI_SESSIONS_COMP = c.optString(TAG_AI_SESSIONS_COMP,"");
                        String AI_PRESENT = c.optString(TAG_AI_PRESENT,"");
                        String AI_ABSENT = c.optString(TAG_AI_ABSENT,"");
                        String AI_LATE = c.optString(TAG_AI_LATE,"");
                        String AI_EXCUSED = c.optString(TAG_AI_EXCUSED,"");
                        String AI_ATT_GRADE = c.optString(TAG_AI_ATT_GRADE,"");
                        String AI_GRADE = c.optString(TAG_AI_GRADE,"");
                        String AI_GRADE_WITH_EXCUSED = c.optString(TAG_AI_GRADE_WITH_EXCUSED,"");

                        String CG_SESSIONS_COMP = c.optString(TAG_CG_SESSIONS_COMP,"");
                        String CG_PRESENT = c.optString(TAG_CG_PRESENT,"");
                        String CG_ABSENT = c.optString(TAG_CG_ABSENT,"");
                        String CG_LATE = c.optString(TAG_CG_LATE,"");
                        String CG_EXCUSED = c.optString(TAG_CG_EXCUSED,"");
                        String CG_ATT_GRADE = c.optString(TAG_CG_ATT_GRADE,"");
                        String CG_GRADE = c.optString(TAG_CG_GRADE,"");
                        String CG_GRADE_WITH_EXCUSED = c.optString(TAG_CG_GRADE_WITH_EXCUSED,"");


                        String CC_SESSIONS_COMP = c.optString(TAG_CC_SESSIONS_COMP,"");
                        String CC_PRESENT = c.optString(TAG_CC_PRESENT,"");
                        String CC_ABSENT = c.optString(TAG_CC_ABSENT,"");
                        String CC_LATE = c.optString(TAG_CC_LATE,"");
                        String CC_EXCUSED = c.optString(TAG_CC_EXCUSED,"");
                        String CC_ATT_GRADE = c.optString(TAG_CC_ATT_GRADE,"");
                        String CC_GRADE = c.optString(TAG_CC_GRADE,"");
                        String CC_GRADE_WITH_EXCUSED = c.optString(TAG_CC_GRADE_WITH_EXCUSED,"");


                        String GC_SESSIONS_COMP = c.optString(TAG_GC_SESSIONS_COMP,"");
                        String GC_PRESENT = c.optString(TAG_GC_PRESENT,"");
                        String GC_ABSENT = c.optString(TAG_GC_ABSENT,"");
                        String GC_LATE = c.optString(TAG_GC_LATE,"");
                        String GC_EXCUSED = c.optString(TAG_GC_EXCUSED,"");
                        String GC_ATT_GRADE = c.optString(TAG_GC_ATT_GRADE,"");
                        String GC_GRADE = c.optString(TAG_GC_GRADE,"");
                        String GC_GRADE_WITH_EXCUSED = c.optString(TAG_GC_GRADE_WITH_EXCUSED,"");

                        String PCS_SESSIONS_COMP = c.optString(TAG_PCS_SESSIONS_COMP,"");
                        String PCS_PRESENT = c.optString(TAG_PCS_PRESENT,"");
                        String PCS_ABSENT = c.optString(TAG_PCS_ABSENT,"");
                        String PCS_LATE = c.optString(TAG_PCS_LATE,"");
                        String PCS_EXCUSED = c.optString(TAG_PCS_EXCUSED,"");
                        String PCS_ATT_GRADE = c.optString(TAG_PCS_ATT_GRADE,"");
                        String PCS_GRADE = c.optString(TAG_PCS_GRADE,"");
                        String PCS_GRADE_WITH_EXCUSED = c.optString(TAG_PCS_GRADE_WITH_EXCUSED,"");

                        String NDT_SESSIONS_COMP = c.optString(TAG_NDT_SESSIONS_COMP,"");
                        String NDT_PRESENT = c.optString(TAG_NDT_PRESENT,"");
                        String NDT_ABSENT = c.optString(TAG_NDT_ABSENT,"");
                        String NDT_LATE = c.optString(TAG_NDT_LATE,"");
                        String NDT_EXCUSED = c.optString(TAG_NDT_EXCUSED,"");
                        String NDT_ATT_GRADE = c.optString(TAG_NDT_ATT_GRADE,"");
                        String NDT_GRADE = c.optString(TAG_NDT_GRADE,"");
                        String NDT_GRADE_WITH_EXCUSED = c.optString(TAG_NDT_GRADE_WITH_EXCUSED,"");



                        // tmp hashmap for single contact



                        // adding each child node to HashMap key => value

                        if (AI_SESSIONS_COMP!=null&&!AI_SESSIONS_COMP.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_SESSIONS_COMP, AI_SESSIONS_COMP);
                        }

                        if (AI_PRESENT!=null&&!AI_PRESENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_PRESENT, AI_PRESENT);
                        }

                        if (AI_ABSENT!=null&&!AI_ABSENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_ABSENT, AI_ABSENT);
                        }

                        if (AI_LATE!=null&&!AI_LATE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_LATE, AI_LATE);
                        }
                        if (AI_EXCUSED!=null&&!AI_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_EXCUSED, AI_EXCUSED);
                        }


                        if (AI_ATT_GRADE!=null&&!AI_ATT_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_ATT_GRADE, AI_ATT_GRADE);
                        }


                        if (AI_GRADE!=null&&!AI_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_GRADE, AI_GRADE);
                        }


                        if (AI_GRADE_WITH_EXCUSED!=null&&!AI_GRADE_WITH_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_AI_GRADE_WITH_EXCUSED, AI_GRADE_WITH_EXCUSED);
                        }





                        if (CG_SESSIONS_COMP!=null&&!CG_SESSIONS_COMP.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_SESSIONS_COMP, CG_SESSIONS_COMP);
                        }


                        if (CG_PRESENT!=null&&!CG_PRESENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_PRESENT, CG_PRESENT);
                        }


                        if (CG_ABSENT!=null&&!CG_ABSENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_ABSENT, CG_ABSENT);
                        }


                        if (CG_LATE!=null&&!CG_LATE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_LATE, CG_LATE);
                        }

                        if (CG_EXCUSED!=null&&!CG_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_EXCUSED, CG_EXCUSED);
                        }

                        if (CG_ATT_GRADE!=null&&!CG_ATT_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_ATT_GRADE, CG_ATT_GRADE);
                        }

                        if (CG_GRADE!=null&&!CG_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_GRADE, CG_GRADE);
                        }


                        if (CG_GRADE_WITH_EXCUSED!=null&&!CG_GRADE_WITH_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CG_GRADE_WITH_EXCUSED, CG_GRADE_WITH_EXCUSED);
                        }





                        if (CC_SESSIONS_COMP!=null&&!CC_SESSIONS_COMP.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_SESSIONS_COMP, CC_SESSIONS_COMP);
                        }

                        if (CC_PRESENT!=null&&!CC_PRESENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_PRESENT, CC_PRESENT);
                        }


                        if (CC_ABSENT!=null&&!CC_ABSENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_ABSENT, CC_ABSENT);
                        }

                        if (CC_LATE!=null&&!CC_LATE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_LATE, CC_LATE);
                        }

                        if (CC_EXCUSED!=null&&!CC_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_EXCUSED, CC_EXCUSED);
                        }

                        if (CC_ATT_GRADE!=null&&!CC_ATT_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_ATT_GRADE, CC_ATT_GRADE);
                        }

                        if (CC_GRADE!=null&&!CC_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_GRADE, CC_GRADE);
                        }

                        if (CC_GRADE_WITH_EXCUSED!=null&&!CC_GRADE_WITH_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_GRADE_WITH_EXCUSED, CC_GRADE_WITH_EXCUSED);
                        }


                        if (CC_GRADE_WITH_EXCUSED!=null&&!CC_GRADE_WITH_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_CC_GRADE_WITH_EXCUSED, CC_GRADE_WITH_EXCUSED);
                        }




                        if (GC_SESSIONS_COMP!=null&&!GC_SESSIONS_COMP.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_SESSIONS_COMP, GC_SESSIONS_COMP);
                        }

                        if (GC_PRESENT!=null&&!GC_PRESENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_PRESENT, GC_PRESENT);
                        }

                        if (GC_ABSENT!=null&&!GC_ABSENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_ABSENT, GC_ABSENT);
                        }

                        if (GC_LATE!=null&&!GC_LATE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_LATE, GC_LATE);
                        }

                        if (GC_EXCUSED!=null&&!GC_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_EXCUSED, GC_EXCUSED);
                        }

                        if (GC_ATT_GRADE!=null&&!GC_ATT_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_ATT_GRADE, GC_ATT_GRADE);
                        }

                        if (GC_GRADE!=null&&!GC_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_GRADE, GC_GRADE);
                        }

                        if (GC_GRADE_WITH_EXCUSED!=null&&!GC_GRADE_WITH_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_GC_GRADE_WITH_EXCUSED, GC_GRADE_WITH_EXCUSED);
                        }



                        if (PCS_SESSIONS_COMP!=null&&!PCS_SESSIONS_COMP.isEmpty())

                        {
                            attendanceHashMap.put(TAG_PCS_SESSIONS_COMP, PCS_SESSIONS_COMP);
                        }

                        if (PCS_PRESENT!=null&&!PCS_PRESENT.isEmpty())
                        {
                            attendanceHashMap.put(TAG_PCS_PRESENT, PCS_PRESENT);
                        }

                        if (PCS_ABSENT!=null&&!PCS_ABSENT.isEmpty())
                        {
                            attendanceHashMap.put(TAG_PCS_ABSENT, PCS_ABSENT);
                        }


                        if (PCS_LATE!=null&&!PCS_LATE.isEmpty())
                        {
                            attendanceHashMap.put(TAG_PCS_LATE, PCS_LATE);
                        }

                        if (PCS_EXCUSED!=null&&!PCS_EXCUSED.isEmpty())
                        {
                            attendanceHashMap.put(TAG_PCS_EXCUSED, PCS_EXCUSED);
                        }


                        if (PCS_ATT_GRADE!=null&&!PCS_ATT_GRADE.isEmpty())
                        {
                            attendanceHashMap.put(TAG_PCS_ATT_GRADE, PCS_ATT_GRADE);
                        }

                        if (PCS_GRADE!=null&&!PCS_GRADE.isEmpty())

                        {
                            attendanceHashMap.put(TAG_PCS_GRADE, PCS_GRADE);
                        }
                        if (PCS_GRADE_WITH_EXCUSED!=null&&!PCS_GRADE_WITH_EXCUSED.isEmpty())

                        {
                            attendanceHashMap.put(TAG_PCS_GRADE_WITH_EXCUSED, PCS_GRADE_WITH_EXCUSED);
                        }





                        if (NDT_SESSIONS_COMP!=null&&!NDT_SESSIONS_COMP.isEmpty())

                        {
                            attendanceHashMap.put(TAG_NDT_SESSIONS_COMP, NDT_SESSIONS_COMP);
                        }

                        if (NDT_PRESENT!=null&&!NDT_PRESENT.isEmpty())

                        {
                            attendanceHashMap.put(TAG_NDT_PRESENT, NDT_PRESENT);
                        }


                        if (NDT_ABSENT!=null&&!NDT_ABSENT.isEmpty())
                        {
                            attendanceHashMap.put(TAG_NDT_ABSENT, NDT_ABSENT);
                        }


                        if (NDT_LATE!=null&&!NDT_LATE.isEmpty())
                        {
                            attendanceHashMap.put(TAG_NDT_LATE, NDT_LATE);
                        }


                        if (NDT_EXCUSED!=null&&!NDT_EXCUSED.isEmpty())
                        {
                            attendanceHashMap.put(TAG_NDT_EXCUSED, NDT_EXCUSED);
                        }


                        if (NDT_ATT_GRADE!=null&&!NDT_ATT_GRADE.isEmpty())
                        {
                            attendanceHashMap.put(TAG_NDT_ATT_GRADE, NDT_ATT_GRADE);
                        }


                        if (NDT_GRADE!=null&&!NDT_GRADE.isEmpty())
                        {
                            attendanceHashMap.put(TAG_NDT_GRADE, NDT_GRADE);
                        }


                        if (NDT_GRADE_WITH_EXCUSED!=null&&!NDT_GRADE_WITH_EXCUSED.isEmpty())
                        {
                            attendanceHashMap.put(TAG_NDT_GRADE_WITH_EXCUSED, NDT_GRADE_WITH_EXCUSED);
                        }



























                    }

                    return true;
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);

            aisessions.setText(attendanceHashMap.get(TAG_AI_SESSIONS_COMP));
            aipresent.setText(attendanceHashMap.get(TAG_AI_PRESENT));
            aiabsent.setText(attendanceHashMap.get(TAG_AI_ABSENT));
            ailate.setText(attendanceHashMap.get(TAG_AI_LATE));
            aiexcused.setText(attendanceHashMap.get(TAG_AI_EXCUSED));
            aiattgrade.setText(attendanceHashMap.get(TAG_AI_ATT_GRADE));
            aigrade.setText(attendanceHashMap.get(TAG_AI_GRADE));
            aigradeexcuse.setText(attendanceHashMap.get(TAG_AI_GRADE_WITH_EXCUSED));


            cgsessions.setText(attendanceHashMap.get(TAG_CG_SESSIONS_COMP));
            cgpresent.setText(attendanceHashMap.get(TAG_CG_PRESENT));
            cgabsent.setText(attendanceHashMap.get(TAG_CG_ABSENT));
            cglate.setText(attendanceHashMap.get(TAG_CG_LATE));
            cgexcused.setText(attendanceHashMap.get(TAG_CG_EXCUSED));
            cgattgrade.setText(attendanceHashMap.get(TAG_CG_ATT_GRADE));
            cggrade.setText(attendanceHashMap.get(TAG_CG_GRADE));
            cggradeexcuse.setText(attendanceHashMap.get(TAG_CG_GRADE_WITH_EXCUSED));

            ccsessions.setText(attendanceHashMap.get(TAG_CC_SESSIONS_COMP));
            ccpresent.setText(attendanceHashMap.get(TAG_CC_PRESENT));
            ccabsent.setText(attendanceHashMap.get(TAG_CC_ABSENT));
            cclate.setText(attendanceHashMap.get(TAG_CC_LATE));
            ccexcused.setText(attendanceHashMap.get(TAG_CC_EXCUSED));
            ccattgrade.setText(attendanceHashMap.get(TAG_CC_ATT_GRADE));
            ccgrade.setText(attendanceHashMap.get(TAG_CC_GRADE));
            ccgradeexcuse.setText(attendanceHashMap.get(TAG_CC_GRADE_WITH_EXCUSED));

            gcsessions.setText(attendanceHashMap.get(TAG_GC_SESSIONS_COMP));
            gcpresent.setText(attendanceHashMap.get(TAG_GC_PRESENT));
            gcabsent.setText(attendanceHashMap.get(TAG_GC_ABSENT));
            gclate.setText(attendanceHashMap.get(TAG_GC_LATE));
            gcexcused.setText(attendanceHashMap.get(TAG_GC_EXCUSED));
            gcattgrade.setText(attendanceHashMap.get(TAG_GC_ATT_GRADE));
            gcgrade.setText(attendanceHashMap.get(TAG_GC_GRADE));
            gcgradeexcuse.setText(attendanceHashMap.get(TAG_GC_GRADE_WITH_EXCUSED));

            pcssessions.setText(attendanceHashMap.get(TAG_PCS_SESSIONS_COMP));
            pcspresent.setText(attendanceHashMap.get(TAG_PCS_PRESENT));
            pcsabsent.setText(attendanceHashMap.get(TAG_PCS_ABSENT));
            pcslate.setText(attendanceHashMap.get(TAG_PCS_LATE));
            pcsexcused.setText(attendanceHashMap.get(TAG_PCS_EXCUSED));
            pcsattgrade.setText(attendanceHashMap.get(TAG_PCS_ATT_GRADE));
            pcsgrade.setText(attendanceHashMap.get(TAG_PCS_GRADE));
            pcsgradeexcuse.setText(attendanceHashMap.get(TAG_PCS_GRADE_WITH_EXCUSED));

            ndtsessions.setText(attendanceHashMap.get(TAG_NDT_SESSIONS_COMP));
            ndtpresent.setText(attendanceHashMap.get(TAG_NDT_PRESENT));
            ndtabsent.setText(attendanceHashMap.get(TAG_NDT_ABSENT));
            ndtlate.setText(attendanceHashMap.get(TAG_NDT_LATE));
            ndtexcused.setText(attendanceHashMap.get(TAG_NDT_EXCUSED));
            ndtattgrade.setText(attendanceHashMap.get(TAG_NDT_ATT_GRADE));
            ndtgrade.setText(attendanceHashMap.get(TAG_NDT_GRADE));
            ndtgradeexcuse.setText(attendanceHashMap.get(TAG_NDT_GRADE_WITH_EXCUSED));



            pDialog.dismiss();
        }
    }
}
