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

public class SundayMenu extends AppCompatActivity {

    private ProgressDialog pDialog;

    HashMap<String, String> sundaymenuHashMap;        //new

    // JSON Node names
    private static final String TAG_SUNDAY = "sundaymenu";
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
    JSONArray sundaymenu = null;

    TextView dryCereal,drinkOne,drinkTwo,main,accompaniment,bread,lSalad,lRice,lDal,lPaneer,lSemi,lGravy,lDessert,lBread,lCurd,
            snacks,drink,dSalad,dRice,dDal,dPaneer,dSemi,dGravy,dDessert,dBread,dCurd;               //new


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunday_menu);
        // Calling async task to get json
        new GetSundayFood().execute();
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
    private class GetSundayFood extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(SundayMenu.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String url = "http://dcafe-menu.getsandbox.com/dcafe-menu-sunday";
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    sundaymenu = jsonObj.getJSONArray(TAG_SUNDAY);

                    sundaymenuHashMap = new HashMap<String, String>();
                    // looping through All Contacts
                    for (int i = 0; i < sundaymenu.length(); i++) {
                        JSONObject c = sundaymenu.getJSONObject(i);


                        String DRY_CEREAL = c.optString(TAG_DRY_CEREAL,"");
                        String DRINK_ONE = c.optString(TAG_DRINK_ONE,"");
                        String DRINK_TWO = c.optString(TAG_DRINK_TWO,"");
                        String MAIN = c.optString(TAG_MAIN,"");
                        String ACCOMPANIMENT = c.optString(TAG_ACCOMPANIMENT,"");
                        String B_BREAD = c.optString(TAG_B_BREAD,"");
                        String L_SALAD = c.optString(TAG_L_SALAD,"");
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


                        // adding each child node to HashMap key => value

                        if (DRY_CEREAL!=null&&!DRY_CEREAL.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_DRY_CEREAL, DRY_CEREAL);
                            //Log.d("check  : ", "" +TAG_DRY_CEREAL  );
                        }
                        if (DRINK_ONE!=null&&!DRINK_ONE.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_DRINK_ONE, DRINK_ONE);
                        }

                        if (DRINK_TWO!=null&&!DRINK_TWO.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_DRINK_TWO, DRINK_TWO);
                        }

                        if (MAIN!=null&&!MAIN.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_MAIN, MAIN);
                        }
                        if (ACCOMPANIMENT!=null&&!ACCOMPANIMENT.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_ACCOMPANIMENT, ACCOMPANIMENT);
                        }


                        if (B_BREAD!=null&&!B_BREAD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_B_BREAD, B_BREAD);
                        }


                        if (L_SALAD!=null&&!L_SALAD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_SALAD, L_SALAD);
                        }


                        if (L_RICE!=null&&!L_RICE.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_RICE, L_RICE);
                        }

                        // sundaymenu.put(TAG_L_DAL, L_DAL);

                        if (L_DAL!=null&&!L_DAL.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_DAL, L_DAL);
                        }


                        if (L_PANEER!=null&&!L_PANEER.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_PANEER, L_PANEER);
                        }



                        if (L_SEMI!=null&&!L_SEMI.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_SEMI, L_SEMI);
                        }

                        if (L_GRAVY!=null&&!L_GRAVY.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_GRAVY, L_GRAVY);
                        }

                        if (L_DESSERT!=null&&!L_DESSERT.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_DESSERT, L_DESSERT);
                        }

                        if (L_BREAD!=null&&!L_BREAD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_BREAD, L_BREAD);
                        }

                        if (L_CURD!=null&&!L_CURD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_L_CURD, L_CURD);
                        }

                        if (SNACKS!=null&&!SNACKS.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_SNACKS, SNACKS);
                        }

                        if (DRINK!=null&&!DRINK.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_DRINK, DRINK);
                        }

                        if (D_SALAD!=null&&!D_SALAD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_SALAD, D_SALAD);
                        }


                        if (D_RICE!=null&&!D_RICE.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_RICE, D_RICE);
                        }

                        if (D_DAL!=null&&!D_DAL.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_DAL, D_DAL);
                        }

                        if (D_PANEER!=null&&!D_PANEER.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_PANEER, D_PANEER);
                        }


                        if (D_SEMI!=null&&!D_SEMI.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_SEMI, D_SEMI);
                        }



                        if (D_GRAVY!=null&&!D_GRAVY.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_GRAVY, D_GRAVY);
                        }

                        if (D_DESSERT!=null&&!D_DESSERT.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_DESSERT, D_DESSERT);
                        }

                        if (D_BREAD!=null&&!D_BREAD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_BREAD, D_BREAD);
                        }

                        if (D_CURD!=null&&!D_CURD.isEmpty())

                        {
                            sundaymenuHashMap.put(TAG_D_CURD, D_CURD);
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

            dryCereal.setText(sundaymenuHashMap.get(TAG_DRY_CEREAL));
            drinkOne.setText(sundaymenuHashMap.get(TAG_DRINK_ONE));
            drinkTwo.setText(sundaymenuHashMap.get(TAG_DRINK_TWO));
            main.setText(sundaymenuHashMap.get(TAG_MAIN));
            accompaniment.setText(sundaymenuHashMap.get(TAG_ACCOMPANIMENT));
            bread.setText(sundaymenuHashMap.get(TAG_B_BREAD));

            lSalad.setText(sundaymenuHashMap.get(TAG_L_SALAD));
            lRice.setText(sundaymenuHashMap.get(TAG_L_RICE));
            lDal.setText(sundaymenuHashMap.get(TAG_L_DAL));
            lPaneer.setText(sundaymenuHashMap.get(TAG_L_PANEER));
            lSemi.setText(sundaymenuHashMap.get(TAG_L_SEMI));
            lGravy.setText(sundaymenuHashMap.get(TAG_L_GRAVY));
            lDessert.setText(sundaymenuHashMap.get(TAG_L_DESSERT));
            lBread.setText(sundaymenuHashMap.get(TAG_L_BREAD));
            lCurd.setText(sundaymenuHashMap.get(TAG_L_CURD));

            snacks.setText(sundaymenuHashMap.get(TAG_SNACKS));
            drink.setText(sundaymenuHashMap.get(TAG_DRINK));

            dSalad.setText(sundaymenuHashMap.get(TAG_D_SALAD));
            dRice.setText(sundaymenuHashMap.get(TAG_D_RICE));
            dDal.setText(sundaymenuHashMap.get(TAG_D_DAL));
            dPaneer.setText(sundaymenuHashMap.get(TAG_D_PANEER));
            dSemi.setText(sundaymenuHashMap.get(TAG_D_SEMI));
            dGravy.setText(sundaymenuHashMap.get(TAG_D_GRAVY));
            dDessert.setText(sundaymenuHashMap.get(TAG_D_DESSERT));
            dBread.setText(sundaymenuHashMap.get(TAG_D_BREAD));
            dCurd.setText(sundaymenuHashMap.get(TAG_D_CURD));



            pDialog.dismiss();
        }
    }
}



