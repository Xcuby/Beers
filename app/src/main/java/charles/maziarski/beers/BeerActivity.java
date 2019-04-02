package charles.maziarski.beers;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import charles.maziarski.beers.R;

public class BeerActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("Nombeer") && getIntent().hasExtra("Sloganbeer") && getIntent().hasExtra("Descriptionbeer") && getIntent().hasExtra("Image_urlbeer")) {

            String BeerName = getIntent().getStringExtra("Nom");
            String BeerTagline = getIntent().getStringExtra("Slogan");
            String BeerDescription = getIntent().getStringExtra("Description");
            String BeerImage_url = getIntent().getStringExtra("urlbeer");
            setBeer(BeerName, BeerTagline, BeerDescription, BeerImage_url);
        }
    }

    private void setBeer(String Name, String Tagline, String Description, String Image_url){
        TextView name = findViewById(R.id.Nombeer);
        name.setText("Nom de la bière : " + Name);
        TextView tagline = findViewById(R.id.Sloganbeer);
        tagline.setText("Slogan : " + Tagline);
        TextView description = findViewById(R.id.Descriptionbeer);
        description.setText("Description : " + Description);
        ImageView image_url = findViewById(R.id.Image_urlbeer);
        Glide.with(this).asBitmap().load(Image_url).into(image_url);
    }
}
