package david.alejandro.projectecomm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Referencia a la toolbar
        MaterialToolbar toolbar = findViewById(R.id.tb_profile);

        // Establecer la toolbar como ActionBar
        setSupportActionBar(toolbar);

        // Añadir el Listener al botón de navegación
        toolbar.setNavigationOnClickListener(v -> {
            // Finaliza la actividad
            finish();
        });
    }
}


