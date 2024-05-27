package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class DetailProductActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Product myProduct;
    private TextView titleTextView, priceTextView, descriptionTextView;
    private ImageView ivProduct;
    private Button btnAddCart, btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        putFindViewById();

        toolbar = findViewById(R.id.top_app_bar_detail_product);

        // Obtén el objeto Product del intent
        myProduct = (Product) getIntent().getSerializableExtra("product");

        if (myProduct == null) {
            Toast.makeText(this, "Error al cargar el producto", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        loadInformation();

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar toast y finalizar la actividad
                Toast.makeText(DetailProductActivity.this, "Producto añadido correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailProductActivity.this, CartShoppingActivity.class);
                intent.putExtra("product", myProduct);
                startActivity(intent);
            }
        });
    }

    private void putFindViewById() {
        toolbar = findViewById(R.id.top_app_bar_detail_product);
        titleTextView = findViewById(R.id.tv_title_detail_product);
        descriptionTextView = findViewById(R.id.tv_decription_detail_product);
        priceTextView = findViewById(R.id.tv_price_detail_product);
        ivProduct = findViewById(R.id.iv_detail_product);
        btnAddCart = findViewById(R.id.btn_add_cart);
        btnBuy = findViewById(R.id.btn_buy);
    }

    private void loadInformation() {
        titleTextView.setText(myProduct.getName());
        priceTextView.setText("$ " + myProduct.getPrice().toString());
        descriptionTextView.setText(myProduct.getDescription());
        Picasso.get().load(myProduct.getImageUrl()).into(ivProduct);
    }
}
