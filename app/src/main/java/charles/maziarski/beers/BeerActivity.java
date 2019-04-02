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
        String BeerName = getIntent().getStringExtra("Nombeer");
        String BeerTagline = getIntent().getStringExtra("Sloganbeer");
        String BeerDescription = getIntent().getStringExtra("Descriptionbeer");
        String BeerImage_url = getIntent().getStringExtra("Image_urlbeer");
        setBeer(BeerName, BeerTagline, BeerDescription, BeerImage_url);
    }

    private void setBeer(String Name, String Tagline, String Description, String Image_url){
        TextView name = findViewById(R.id.Bname);
        name.setText("Nom de la bière : " + Name);
        TextView tagline = findViewById(R.id.Btagline);
        tagline.setText("Slogan : " + Tagline);
        TextView description = findViewById(R.id.Bdescription);
        description.setText("Description : " + Description);
        ImageView image_url = findViewById(R.id.Bimage_url);
        Glide.with(this).load(Image_url).into(image_url);
    }
}
