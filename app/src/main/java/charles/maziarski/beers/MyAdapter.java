package charles.maziarski.beers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
    private List<Beer> listValues;
    private Context cxt;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Beer> listValues, Context c) {
        this.listValues = listValues;
        this.cxt = c;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Beer currentBeer = listValues.get(position);
        final String name = currentBeer.getName();
        final String tagline = currentBeer.getTagline();
        final String description = currentBeer.getDescription();
        final String image_url = currentBeer.getImage_url();
        holder.txtHeader.setText(name);
        holder.txtFooter.setText(tagline);
        Glide.with(cxt).asBitmap().load(image_url).into(holder.image);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cxt, BeerActivity.class);
                intent.putExtra("nom", name);
                intent.putExtra("tagline", tagline);
                intent.putExtra("description", description);
                intent.putExtra("image_url", image_url);
                cxt.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listValues.size();
    }

}