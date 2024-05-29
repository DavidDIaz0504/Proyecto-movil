package david.alejandro.projectecomm;

import android.view.ViewGroup;
import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Event implements Serializable {

    private String imageUrl;

    public Event(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Event(ArrayList<Product> listEvent) {
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}

