package charles.maziarski.beers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainController {

    private MainActivity activity;

    private RestBeerApi restBeerApi;

    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restBeerApi = retrofit.create(RestBeerApi.class);
        Call<List<Beer>> call = restBeerApi.getListBeer();
        call.enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                                    List<Beer> listBeer = response.body();
                                   activity.showList(listBeer);
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });

}}

