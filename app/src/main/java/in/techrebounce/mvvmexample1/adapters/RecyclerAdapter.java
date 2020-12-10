package in.techrebounce.mvvmexample1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import in.techrebounce.mvvmexample1.R;
import in.techrebounce.mvvmexample1.models.NicePlace;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlacesViewHolder>{

    private Context mContext;
    private List<NicePlace> mNicePlaces;

    public RecyclerAdapter(Context context, List<NicePlace> nicePlaces) {
            this.mContext = context;
            this.mNicePlaces = nicePlaces;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        PlacesViewHolder viewHolder = new PlacesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder holder, int position) {

        holder.placesTextView.setText(mNicePlaces.get(position).getTitle());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlaces.get(position).getImageUrl())
                .into(holder.placesImageView);
    }

    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }

    public class PlacesViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView placesImageView;
        private TextView placesTextView;
        public PlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            placesImageView = itemView.findViewById(R.id.place_imageview);
            placesTextView = itemView.findViewById(R.id.place_textview);
        }
    }


}
