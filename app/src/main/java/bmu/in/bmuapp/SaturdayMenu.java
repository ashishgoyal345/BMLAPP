package bmu.in.bmuapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class SaturdayMenu extends AppCompatActivity {

    private ProgressDialog pDialog;

    HashMap<String, String> saturdaymenuHashMap;        //new

    // JSON Node names
    private static final String TAG_SATURDAY = "saturdaymenu";
    private static final String TAG_DRY_CEREAL = "DRY_CEREAL";
    private static final String TAG_DRINK_ONE = "DRINK_ONE";
    private static final String TAG_DRINK_TWO = "DRINK_TWO";
    private static final String TAG_MAIN = "MAIN";
    private static final String TAG_ACCOMPANIMENT = "ACCOMPANIMENT";
    private static final String TAG_B_BREAD = "B_BREAD";
    private static final String TAG_L_SALAD = "L_SALAD";
    private static final String TAG_L_RICE = "L_RICE";
    private static final String TAG_L_DAL = "L_DAL";
    private static final String TAG_L_PANEER = "L_PANEER";
    private static final String TAG_L_SEMI = "L_SEMI";
    private static final String TAG_L_GRAVY = "L_GRAVY";
    private static final String TAG_L_DESSERT = "L_DESSERT";
    private static final String TAG_L_BREAD = "L_BREAD";
    private static final String TAG_L_CURD = "L_CURD";
    private static final String TAG_SNACKS = "SNACKS";
    private static final String TAG_DRINK = "DRINK";
    private static final String TAG_D_SALAD = "D_SALAD";
    private static final String TAG_D_RICE = "D_RICE";
    private static final String TAG_D_DAL = "D_DAL";
    private static final String TAG_D_PANEER = "D_PANEER";
    private static final String TAG_D_SEMI = "D_SEMI";
    private static final String TAG_D_GRAVY = "D_GRAVY";
    private static final String TAG_D_DESSERT = "D_DESSERT";
    private static final String TAG_D_BREAD = "D_BREAD";
    private static final String TAG_D_CURD = "D_CURD";



    // contacts JSONArray
    JSONArray saturdaymenu = null;

    TextView dryCereal,drinkOne,drinkTwo,main,accompaniment,bread,lSalad,lRice,lDal,lPaneer,lSemi,lGravy,lDessert,lBread,lCurd,
            snacks,drink,dSalad,dRice,dDal,dPaneer,dSemi,dGravy,dDessert,dBread,dCurd;               //new


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturday_menu);

        Log.d("check 1 : ", "Success"  );
        // Calling async task to get json
        new GetContacts().execute();
        Log.d("check 2 : ", "Success"  );

        dryCereal =(TextView)findViewById(R.id.DRY_CEREAL);
        drinkOne =(TextView)findViewById(R.id.DRINK_ONE);
        drinkTwo =(TextView)findViewById(R.id.DRINK_TWO);
        main =(TextView)findViewById(R.id.MAIN);
        accompaniment =(TextView)findViewById(R.id.ACCOMPANIMENT);
        bread =(TextView)findViewById(R.id.B_BREAD);

        lSalad =(TextView)findViewById(R.id.L_SALAD);
        lRice =(TextView)findViewById(R.id.L_RICE);
        lDal =(TextView)findViewById(R.id.L_DAL);
        lPaneer =(TextView)findViewById(R.id.L_PANEER);
        lSemi =(TextView)findViewById(R.id.L_SEMI);
        lGravy =(TextView)findViewById(R.id.L_GRAVY);
        lBread =(TextView)findViewById(R.id.L_BREAD);
        lCurd =(TextView)findViewById(R.id.L_CURD);
        lDessert =(TextView)findViewById(R.id.L_DESSERT);

        snacks =(TextView)findViewById(R.id.SNACKS);
        drink =(TextView)findViewById(R.id.DRINK);

        dSalad =(TextView)findViewById(R.id.D_SALAD);
        dRice =(TextView)findViewById(R.id.D_RICE);
        dDal =(TextView)findViewById(R.id.D_DAL);
        dPaneer =(TextView)findViewById(R.id.D_PANEER);
        dSemi =(TextView)findViewById(R.id.D_SEMI);
        dGravy =(TextView)findViewById(R.id.D_GRAVY);
        dDessert =(TextView)findViewById(R.id.D_DESSERT);
        dBread =(TextView)findViewById(R.id.D_BREAD);
        dCurd =(TextView)findViewById(R.id.D_CURD);

    }


    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            Log.d("check 3 : ", "Success"  );
            super.onPreExecute();
            Log.d("check 4 : ", "Success"  );
            // Showing progress dialog
            pDialog = new ProgressDialog(SaturdayMenu.this);
            Log.d("check 5 : ", "Success"  );
            pDialog.setMessage("Please wait...");
            Log.d("check 6 : ", "Success"  );
            pDialog.setCancelable(false);
            Log.d("check 7 : ", "Success"  );
            pDialog.show();
            Log.d("check 8 : ", "Success"  );

        }

        @Override
        protected Boolean doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
            Log.d("check 9 : ", "Success"  );

            // Making a request to url and getting response
            String url = "http://dcafe-menu.getsandbox.com/dcafe-menu-saturday";
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                Log.d("check 10 : ", "Success"  );
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    Log.d("check 11 : ", "Success"  );
                    // Getting JSON Array node
                    saturdaymenu = jsonObj.getJSONArray(TAG_SATURDAY);
                    Log.d("check 12 : ", "" +saturdaymenu  );

                    saturdaymenuHashMap = new HashMap<String, String>();
                    // looping through All Contacts
                    for (int i = 0; i < saturdaymenu.length(); i++) {
                        JSONObject c = saturdaymenu.getJSONObject(i);


                        String DRY_CEREAL = c.optString(TAG_DRY_CEREAL,"");
                        Log.d("check 13 : ", "" +DRY_CEREAL  );
                        String DRINK_ONE = c.optString(TAG_DRINK_ONE,"");
                        String DRINK_TWO = c.optString(TAG_DRINK_TWO,"");
                        String MAIN = c.optString(TAG_MAIN,"");
                        String ACCOMPANIMENT = c.optString(TAG_ACCOMPANIMENT,"");
                        String B_BREAD = c.optString(TAG_B_BREAD,"");
                        String L_SALAD = c.optString(TAG_L_SALAD,"");
                        Log.d("check star : ", "" +L_SALAD  );
                        String L_RICE = c.optString(TAG_L_RICE,"");
                        String L_DAL = c.optString(TAG_L_DAL,"");
                        String L_PANEER = c.optString(TAG_L_PANEER,"");
                        String L_SEMI = c.optString(TAG_L_SEMI,"");
                        String L_GRAVY = c.optString(TAG_L_GRAVY,"");
                        String L_DESSERT = c.optString(TAG_L_DESSERT,"");
                        String L_BREAD = c.optString(TAG_L_BREAD,"");
                        String L_CURD = c.optString(TAG_L_CURD,"");
                        String SNACKS = c.optString(TAG_SNACKS,"");
                        String DRINK = c.optString(TAG_DRINK,"");
                        String D_SALAD = c.optString(TAG_D_SALAD,"");
                        String D_RICE = c.optString(TAG_D_RICE,"");
                        String D_DAL = c.optString(TAG_D_DAL,"");
                        String D_PANEER = c.optString(TAG_D_PANEER,"");
                        String D_SEMI = c.optString(TAG_D_SEMI,"");
                        String D_GRAVY = c.optString(TAG_D_GRAVY,"");
                        String D_DESSERT = c.optString(TAG_D_DESSERT,"");
                        String D_BREAD = c.optString(TAG_D_BREAD,"");
                        String D_CURD = c.optString(TAG_D_CURD,"");


                        // tmp hashmap for single contact

                        Log.d("check 14 : ", "Success"  );


                        // adding each child node to HashMap key => value

                        if (DRY_CEREAL!=null&&!DRY_CEREAL.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_DRY_CEREAL, DRY_CEREAL);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }
                        //saturdaymenu.put(TAG_DRY_CEREAL, DRY_CEREAL);

                        // saturdaymenu.put(TAG_DRINK_ONE, DRINK_ONE);

                        if (DRINK_ONE!=null&&!DRINK_ONE.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_DRINK_ONE, DRINK_ONE);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        //saturdaymenu.put(TAG_DRINK_TWO, DRINK_TWO);
                        if (DRINK_TWO!=null&&!DRINK_TWO.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_DRINK_TWO, DRINK_TWO);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_MAIN, MAIN);
                        if (MAIN!=null&&!MAIN.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_MAIN, MAIN);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }
                        // saturdaymenu.put(TAG_ACCOMPANIMENT, ACCOMPANIMENT);
                        if (ACCOMPANIMENT!=null&&!ACCOMPANIMENT.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_ACCOMPANIMENT, ACCOMPANIMENT);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        // saturdaymenu.put(TAG_B_BREAD, B_BREAD);
                        if (B_BREAD!=null&&!B_BREAD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_B_BREAD, B_BREAD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        // saturdaymenu.put(TAG_L_SALAD, L_SALAD);
                        if (L_SALAD!=null&&!L_SALAD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_SALAD, L_SALAD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        //  saturdaymenu.put(TAG_L_RICE, L_RICE);
                        if (L_RICE!=null&&!L_RICE.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_RICE, L_RICE);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_L_DAL, L_DAL);

                        if (L_DAL!=null&&!L_DAL.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_DAL, L_DAL);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_L_PANEER, L_PANEER);

                        if (L_PANEER!=null&&!L_PANEER.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_PANEER, L_PANEER);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        //saturdaymenu.put(TAG_L_SEMI, L_SEMI);

                        if (L_SEMI!=null&&!L_SEMI.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_SEMI, L_SEMI);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        //saturdaymenu.put(TAG_L_GRAVY, L_GRAVY);

                        if (L_GRAVY!=null&&!L_GRAVY.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_GRAVY, L_GRAVY);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        //saturdaymenu.put(TAG_L_DESSERT, L_DESSERT);

                        if (L_DESSERT!=null&&!L_DESSERT.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_DESSERT, L_DESSERT);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        // saturdaymenu.put(TAG_L_BREAD, L_BREAD);

                        if (L_BREAD!=null&&!L_BREAD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_BREAD, L_BREAD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        //saturdaymenu.put(TAG_L_CURD, L_CURD);

                        if (L_CURD!=null&&!L_CURD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_L_CURD, L_CURD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        //saturdaymenu.put(TAG_SNACKS, SNACKS);

                        if (SNACKS!=null&&!SNACKS.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_SNACKS, SNACKS);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_DRINK, DRINK);

                        if (DRINK!=null&&!DRINK.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_DRINK, DRINK);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        //saturdaymenu.put(TAG_D_SALAD, D_SALAD);

                        if (D_SALAD!=null&&!D_SALAD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_SALAD, D_SALAD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_D_RICE, D_RICE);

                        if (D_RICE!=null&&!D_RICE.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_RICE, D_RICE);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_D_DAL, D_DAL);
                        if (D_DAL!=null&&!D_DAL.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_DAL, D_DAL);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        //saturdaymenu.put(TAG_D_PANEER, D_PANEER);
                        if (D_PANEER!=null&&!D_PANEER.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_PANEER, D_PANEER);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        //saturdaymenu.put(TAG_D_SEMI, D_SEMI);

                        if (D_SEMI!=null&&!D_SEMI.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_SEMI, D_SEMI);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }


                        //saturdaymenu.put(TAG_D_GRAVY, D_GRAVY);

                        if (D_GRAVY!=null&&!D_GRAVY.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_GRAVY, D_GRAVY);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }
                        // saturdaymenu.put(TAG_D_DESSERT, D_DESSERT);

                        if (D_DESSERT!=null&&!D_DESSERT.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_DESSERT, D_DESSERT);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }

                        // saturdaymenu.put(TAG_D_BREAD, D_BREAD);

                        if (D_BREAD!=null&&!D_BREAD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_BREAD, D_BREAD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }
                        // saturdaymenu.put(TAG_D_CURD, D_CURD);

                        if (D_CURD!=null&&!D_CURD.isEmpty())

                        {
                            saturdaymenuHashMap.put(TAG_D_CURD, D_CURD);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }
                        Log.d("check 15 : ", "Success"  );
                    }

                    return true;
                }
                catch (JSONException e) {
                    Log.d("check 16 : ", "Success"  );
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

            dryCereal.setText(saturdaymenuHashMap.get(TAG_DRY_CEREAL));
            drinkOne.setText(saturdaymenuHashMap.get(TAG_DRINK_ONE));
            drinkTwo.setText(saturdaymenuHashMap.get(TAG_DRINK_TWO));
            main.setText(saturdaymenuHashMap.get(TAG_MAIN));
            accompaniment.setText(saturdaymenuHashMap.get(TAG_ACCOMPANIMENT));
            bread.setText(saturdaymenuHashMap.get(TAG_B_BREAD));

            lSalad.setText(saturdaymenuHashMap.get(TAG_L_SALAD));
            lRice.setText(saturdaymenuHashMap.get(TAG_L_RICE));
            lDal.setText(saturdaymenuHashMap.get(TAG_L_DAL));
            lPaneer.setText(saturdaymenuHashMap.get(TAG_L_PANEER));
            lSemi.setText(saturdaymenuHashMap.get(TAG_L_SEMI));
            lGravy.setText(saturdaymenuHashMap.get(TAG_L_GRAVY));
            lDessert.setText(saturdaymenuHashMap.get(TAG_L_DESSERT));
            lBread.setText(saturdaymenuHashMap.get(TAG_L_BREAD));
            lCurd.setText(saturdaymenuHashMap.get(TAG_L_CURD));

            snacks.setText(saturdaymenuHashMap.get(TAG_SNACKS));
            drink.setText(saturdaymenuHashMap.get(TAG_DRINK));

            dSalad.setText(saturdaymenuHashMap.get(TAG_D_SALAD));
            dRice.setText(saturdaymenuHashMap.get(TAG_D_RICE));
            dDal.setText(saturdaymenuHashMap.get(TAG_D_DAL));
            dPaneer.setText(saturdaymenuHashMap.get(TAG_D_PANEER));
            dSemi.setText(saturdaymenuHashMap.get(TAG_D_SEMI));
            dGravy.setText(saturdaymenuHashMap.get(TAG_D_GRAVY));
            dDessert.setText(saturdaymenuHashMap.get(TAG_D_DESSERT));
            dBread.setText(saturdaymenuHashMap.get(TAG_D_BREAD));
            dCurd.setText(saturdaymenuHashMap.get(TAG_D_CURD));



            pDialog.dismiss();
        }
    }
}



