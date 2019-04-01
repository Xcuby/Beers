package charles.maziarski.beers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestBeerApi {
    @GET("beers")
    Call<List<Beer>> getListBeer();
}
