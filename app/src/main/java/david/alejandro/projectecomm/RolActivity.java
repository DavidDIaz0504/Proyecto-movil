package david.alejandro.projectecomm;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RolActivity extends AppCompatActivity {

    private Button btnUserRole;
    private Button btnVendorRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol);

        btnUserRole = findViewById(R.id.btn_user_rol);
        btnVendorRole = findViewById(R.id.btn_vendor_rol);

        btnUserRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to MainActivity
                Intent intent = new Intent(RolActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnVendorRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to AccountVendorActivity
                Intent intent = new Intent(RolActivity.this, AccountVendorActivity.class);
                startActivity(intent);
            }
        });
    }
}