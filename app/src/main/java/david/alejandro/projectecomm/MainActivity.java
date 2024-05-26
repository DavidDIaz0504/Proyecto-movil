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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SlideModel> eventList = new ArrayList<>(); // Create event list
    private ArrayList<Product> listProducts = new ArrayList<>();
    private ImageSlider imageSlider;
    private RecyclerView rvProductsMain;
    private BottomNavigationView bnTienda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cargar informacion falsa
        loadFakeData();
        //slider de eventos
        imageSlider = findViewById(R.id.event_slider_home);
        eventList.add(new SlideModel("https://img.freepik.com/vector-gratis/plantilla-detallada-banner-anime_52683-66691.jpg", "...", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEjHSULWlBnAIf2pDueXARrU_NnFxkaEpC4vYd-YcsCg&s", "..", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://t4.ftcdn.net/jpg/04/04/73/39/360_F_404733910_2mIXr6RbC5G3WZJFjopVsBaR3EOM6Bqy.jpg", ".", ScaleTypes.FIT));
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
        Product product1 = new Product("Computador Asus", " El mejor computador Gamer que puedes comprar ", 11000000.0, "https://rampcrosario.com/wp-content/uploads/2019/03/pc-gamer.png");
        Product product2 = new Product("Teclado Asus ", " El mejor teclado Gamer que puedes comprar ", 100000.0, "https://d22fxaf9t8d39k.cloudfront.net/f65ad7c8036f1e99b17e1e3fbcd89625026e26a0e81e4af34b1dc8b0cf7d235c169554.png");
        Product product3 = new Product("Celular Rog", " El mejor celular Gamer que puedes comprar ", 7000000.0, "https://dlcdnwebimgs.asus.com/gain/FB338DAC-B312-4D25-A7A3-DBDBDBC123CA");
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