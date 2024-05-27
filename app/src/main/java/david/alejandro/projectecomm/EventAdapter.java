package david.alejandro.projectecomm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<Event> listObjets;
    private Context context;

    public EventAdapter(ArrayList<Event> listObjets) {
        this.listObjets = listObjets;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View myView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_event, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        holder.associate(listObjets.get(position));
    }

    @Override
    public int getItemCount() {
        return listObjets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myImage;
        private Button btnAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.iv_event);
            btnAdd = itemView.findViewById(R.id.btn_add_event);
        }

        public void associate(Event myProduct) {
            Picasso.get().load(myProduct.getImageUrl()).into(myImage);

        }
    }
}
