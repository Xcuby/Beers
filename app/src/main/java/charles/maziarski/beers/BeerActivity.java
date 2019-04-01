package charles.maziarski.beers;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import charles.maziarski.beers.R;

public class BeerActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        String BeerName = getIntent.getStringExtra("Nombeer");
        String BeerTagline = getIntent.getStringExtra("Sloganbeer");

    }


}
