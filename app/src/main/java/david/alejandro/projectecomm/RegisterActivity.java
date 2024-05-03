package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        EditText etName = findViewById(R.id.et_namer_register);
        EditText etEmail = findViewById(R.id.et_emailer_register);
        EditText etPassword = findViewById(R.id.et_psswrd_register);
        Button btnCrearCuenta = findViewById(R.id.btn_crear_cuenta);
        TextView tvlogin = findViewById(R.id.tv_login);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el texto de los EditText
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Verifica si los campos están vacíos y cambia los fondos si es necesario
                if (name.isEmpty()) {
                    etName.setBackgroundResource(R.drawable.edit_text_border);
                } else {
                    etName.setBackgroundResource(R.drawable.shape_contorno);
                }
                if (email.isEmpty()) {
                    etEmail.setBackgroundResource(R.drawable.edit_text_border);
                } else {
                    etEmail.setBackgroundResource(R.drawable.shape_contorno);
                }
                if (password.isEmpty()) {
                    etPassword.setBackgroundResource(R.drawable.edit_text_border);
                } else {
                    etPassword.setBackgroundResource(R.drawable.shape_contorno);
                }

                // Verifica si algún campo está vacío
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar Toast de éxito
                    Toast.makeText(RegisterActivity.this, "Cuenta creada satisfactoriamente", Toast.LENGTH_SHORT).show();

                    // Si no hay campos vacíos, procede con el registro
                    Intent intent = new Intent(RegisterActivity.this, RolActivity.class);
                    startActivity(intent);
                    finish(); // Opcional: finaliza la actividad actual si no necesitas volver a ella
                }
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad "activity_register"
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                // Finalizar esta actividad
                finish();
            }
        });
    }
}