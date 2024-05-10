package david.alejandro.projectecomm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<SlideModel> eventList = new ArrayList<>(); // Create event list
    private ArrayList<Product> listProducts = new ArrayList<>();
    private ImageSlider imageSlider;
    private RecyclerView rvProductsMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cargar informacion falsa
        loadFakeData();
        //slider de eventos
        imageSlider= findViewById(R.id.event_slider_home);
        eventList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.", ScaleTypes.FIT));
        eventList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.", ScaleTypes.FIT));
        imageSlider.setImageList(eventList);

        //recycle view productos
        rvProductsMain = findViewById(R.id.rv_products_main);
        ProductAdapter myAdapter = new ProductAdapter(listProducts);
        rvProductsMain.setAdapter(myAdapter);
        StaggeredGridLayoutManager myStaged = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvProductsMain.setLayoutManager(myStaged);

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