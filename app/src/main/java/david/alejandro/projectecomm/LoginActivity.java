package david.alejandro.projectecomm;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnIniciarSesion;
    TextView tvRegistrarse;

    EditText etmail, etpswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        tvRegistrarse = findViewById(R.id.tv_registrarse);
        etmail = findViewById(R.id.et_correo_electronico);
        etpswrd = findViewById(R.id.et_password);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el texto de los EditText
                String email = etmail.toString().trim();
                String password = etpswrd.getText().toString().trim();

                // Verifica si los campos están vacíos y cambia los fondos si es necesario
                if (email.isEmpty()) {
                    etmail.setBackgroundResource(R.drawable.edit_text_border);
                } else {
                    etmail.setBackgroundResource(R.drawable.shape_contorno);
                }
                if (password.isEmpty()) {
                    etpswrd.setBackgroundResource(R.drawable.edit_text_border);
                } else {
                    etpswrd.setBackgroundResource(R.drawable.shape_contorno);
                }

                // Verifica si algún campo está vacío
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar Toast de éxito
                    Toast.makeText(LoginActivity.this, "Cuenta creada satisfactoriamente", Toast.LENGTH_SHORT).show();

                    // Si no hay campos vacíos, procede con el registro
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
        tvRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad "activity_register"
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                // Finalizar esta actividad
                finish();
            }
        });
    }
}