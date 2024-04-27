package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_activity extends AppCompatActivity {
    Button btnIniciarSesion;
    TextView tvRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        tvRegistrarse = findViewById(R.id.tv_registrarse);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad "activity_main"
                startActivity(new Intent(login_activity.this, MainActivity.class));
                // Finalizar esta actividad
                finish();
            }
        });

        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad "activity_register"
                startActivity(new Intent(login_activity.this, register_activity.class));
                // Finalizar esta actividad
                finish();
            }
        });
    }
}