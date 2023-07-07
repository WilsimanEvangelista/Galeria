package silva.evangelista.santos.wilsiman.galeria;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter {
    MainActivity mainActivity;
    List<String> photos;

    public MainAdapter(MainActivity mainActivity, List<String> photos) {
        this.mainActivity = mainActivity;
        this.photos = photos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ImageView imPhoto =
                holder.itemView.findViewById(R.id.imItem);
        int w = (int)
                mainActivity.getResources().getDimension(R.dimen.itemWidth);
        int h = (int)
                mainActivity.getResources().getDimension(R.dimen.itemHeight);
        Bitmap bitmap = Utils.getBitmap(photos.get(position), w, h);
        imPhoto.setImageBitmap(bitmap);
        imPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mainActivity.startPhotoActivity(photos.get(position));
            }
        });
    }
}