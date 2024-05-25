package david.alejandro.projectecomm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class ScannerActivity extends AppCompatActivity {

    Button btnCamara;
    ImageView visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        btnCamara = findViewById(R.id.btn_scan);
        visor = findViewById(R.id.iv_visor);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camara();
            }
        });

        // Referencia a la toolbar
        MaterialToolbar toolbar = findViewById(R.id.tb_scanner);

        // Establecer la toolbar como ActionBar
        setSupportActionBar(toolbar);

        // Añadir el Listener al botón de navegación
        toolbar.setNavigationOnClickListener(v -> {
            // Finaliza la actividad
            finish();
        });


    }

    private void camara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, 1);
        }
    }

    protected void onActivityResult(int requestedCode, int resultcode, Intent data) {
        super.onActivityResult(requestedCode, resultcode, data);
        if (requestedCode ==1  && resultcode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            visor.setImageBitmap(imgBitmap);
        }
    }
}
