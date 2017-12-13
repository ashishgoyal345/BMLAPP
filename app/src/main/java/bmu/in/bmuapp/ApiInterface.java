package bmu.in.bmuapp;



import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("hym/")
    Call<ArrayList<Search_GetSet>> getSearch(@Query("email") String userid, @Query("password") String name);

   // @GET("showname/")
    //Call<ArrayList<Search_GetSet>> getSearch(@Query("email") String userid );


   @GET("showbasic/")
   Call<ArrayList<Search_GetSet>> getSearch(@Query("id") String id );

}
