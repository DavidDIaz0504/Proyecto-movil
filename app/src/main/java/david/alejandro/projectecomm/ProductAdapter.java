package david.alejandro.projectecomm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<Product> listObjets;
    private Context context;

    public ProductAdapter(ArrayList<Product> listObjets) {
        this.listObjets = listObjets;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View myView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.associate(listObjets.get(position));
    }

    @Override
    public int getItemCount() {
        return listObjets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myImage;
        private TextView nameProduct, priceProduct;
        private Button btnAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.iv_event);
            nameProduct = itemView.findViewById(R.id.tv_name_product_item);
            priceProduct = itemView.findViewById(R.id.tv_name_price_item);
            btnAdd = itemView.findViewById(R.id.btn_add_event);
        }

        public void associate(Product myProduct) {
            nameProduct.setText(myProduct.getName());
            priceProduct.setText("$ " + myProduct.getPrice().toString());
            Picasso.get().load(myProduct.getImageUrl()).into(myImage);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailProductActivity.class);
                    intent.putExtra("product", myProduct);
                    context.startActivity(intent);
                }
            });
        }
    }
}

