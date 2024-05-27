package david.alejandro.projectecomm;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AccountVendorActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ArrayList<Product> listProducts = new ArrayList<>();
    private ImageSlider imageSlider;
    private RecyclerView rvProductsFav;
    private BottomNavigationView bnTienda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_account_vendor);

        toolbar = findViewById(R.id.top_app_bar_vendor);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        loadFakeData();

        rvProductsFav = findViewById(R.id.rv_products_fav);
        ProductAdapter myAdapter = new ProductAdapter(listProducts);
        rvProductsFav.setAdapter(myAdapter);
        StaggeredGridLayoutManager myStaged = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvProductsFav.setLayoutManager(myStaged);

    }

    private void loadFakeData() {
        Product product1 = new Product("Bolso OnePiece", " hoi ", 100000.00,"https://m.media-amazon.com/images/I/51XRvih20sL.__AC_SX300_SY300_QL70_FMwebp_.jpg");
        Product product2 = new Product("Mochila Totoro", "UNA BOLSO DE TOTOROO :0", 100000.0, "https://m.media-amazon.com/images/I/71jn1tRUlBL._AC_SY500_.jpg");
        Product product3 = new Product("Teclado Gamer", " Severo teclado COmpralo", 7000000.0, "https://m.media-amazon.com/images/I/71WBwf2mkXL._AC_SL1500_.jpg");
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
    }
}