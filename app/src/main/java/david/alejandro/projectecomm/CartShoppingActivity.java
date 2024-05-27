package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class CartShoppingActivity extends AppCompatActivity {

    private Button btnBuyCart;
    private Toolbar toolbar;
    private Product myProduct;
    private TextView titleTextView, priceTextView;
    private ImageView ivProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_shopping);
        putFindViewById();

        // Obtén el objeto Product del intent
        myProduct = (Product) getIntent().getSerializableExtra("product");

        if (myProduct == null) {
            // Mostrar mensaje de error y finalizar la actividad
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

        // Añadir listener para btn_buy_cart
        btnBuyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartShoppingActivity.this, PaymentGatewayActivity.class);
                startActivity(intent);
            }
        });
    }

    private void putFindViewById() {
        toolbar = findViewById(R.id.top_app_bar_cart);
        titleTextView = findViewById(R.id.tv_title_detail_product);
        priceTextView = findViewById(R.id.tv_pricetotal);
        ivProduct = findViewById(R.id.iv_detail_product);
        btnBuyCart = findViewById(R.id.btn_buy_cart);
    }

    private void loadInformation() {
        titleTextView.setText(myProduct.getName());
        priceTextView.setText("$ " + myProduct.getPrice().toString());
        Picasso.get().load(myProduct.getImageUrl()).into(ivProduct);
    }
}
