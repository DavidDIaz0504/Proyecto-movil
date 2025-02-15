package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import android.support.design.widget.BottomAppBar;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SlideModel> eventList = new ArrayList<>(); // Create event list
    private ArrayList<Product> listProducts = new ArrayList<>();
    private ImageSlider imageSlider;
    private RecyclerView rvProductsMain;

    private BottomAppBar bnTienda;

    private BottomNavigationView bnTienda;
    private TextView tvEventMain;
    private TextView tvStoreMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cargar informacion falsa

        tvEventMain = findViewById(R.id.tv_event_seeall);
        tvStoreMain = findViewById(R.id.tv_shop_seeall);

        tvEventMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to EventActivity
                Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });

        tvStoreMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to ShopActivity
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        loadFakeData();
        //slider de eventos
        imageSlider = findViewById(R.id.event_slider_home);

        eventList.add(new SlideModel("https://img.freepik.com/vector-gratis/plantilla-detallada-banner-anime_52683-66691.jpg", "...", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEjHSULWlBnAIf2pDueXARrU_NnFxkaEpC4vYd-YcsCg&s", "..", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://t4.ftcdn.net/jpg/04/04/73/39/360_F_404733910_2mIXr6RbC5G3WZJFjopVsBaR3EOM6Bqy.jpg", ".", ScaleTypes.FIT));

        eventList.add(new SlideModel("https://img.freepik.com/vector-gratis/diseno-plantilla-banner-rectangulo-festival-anime-otaku_742173-4924.jpg?size=626&ext=jpg&ga=GA1.1.1319243779.1711411200&semt=ais", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/anime-event-flyer-design-facebook-template-0def29cd5467ccbd8fe67424599bfd7e_screen.jpg?ts=1660392266",  ScaleTypes.FIT));
        eventList.add(new SlideModel("https://img.freepik.com/vector-gratis/banner-anime-fuera-linea-twitch_79603-2016.jpg?size=626&ext=jpg&ga=GA1.1.1319243779.1711411200&semt=ais",  ScaleTypes.FIT));

        imageSlider.setImageList(eventList);

        //recycle view productos
        rvProductsMain = findViewById(R.id.rv_products_main);
        ProductAdapter myAdapter = new ProductAdapter(listProducts);
        rvProductsMain.setAdapter(myAdapter);
        StaggeredGridLayoutManager myStaged = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvProductsMain.setLayoutManager(myStaged);
        //barra de navegacion
        bnTienda = findViewById(R.id.bottom_navigation_tienda);

        bnTienda.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.page_count) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    return true;
                } else if (itemId == R.id.page_scanner) {
                    startActivity(new Intent(MainActivity.this, ScannerActivity.class));
                    return true;
                } else if (itemId == R.id.page_carrito) {
                    startActivity(new Intent(MainActivity.this, CartShoppingActivity.class));
                    return true;
                } else {
                    return false;
                }
            }
        });
/*
        bnTienda.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.page_count) {
                    // Manejar la pulsación del icono page_count
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.page_scanner) {
                    // Manejar la pulsación del icono accelerator
                    Intent intent1 = new Intent(MainActivity.this, ScannerActivity.class);
                    startActivity(intent1);
                } else if (item.getItemId() == R.id.page_carrito) {
                    // Manejar la pulsación del icono rotation
                    Intent intent2 = new Intent(MainActivity.this, CartShoppingActivity.class);
                    startActivity(intent2);
                } else {
                    // Manejar otros casos
                }
                return false;
            }

        });*/
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

}
