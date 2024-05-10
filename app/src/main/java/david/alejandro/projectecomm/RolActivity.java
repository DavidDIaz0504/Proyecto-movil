package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RolActivity extends AppCompatActivity {

    private Button btnVendorRol;
    private Button btnUserRol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rol);

        btnVendorRol = findViewById(R.id.btn_vendor_rol);
        btnUserRol = findViewById(R.id.btn_user_rol);

        btnVendorRol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir AccountActivity
                Intent intent = new Intent(RolActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        btnUserRol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir MainActivity
                Intent intent = new Intent(RolActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}