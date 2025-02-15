package david.alejandro.projectecomm;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button btnIniciarSesion;
    private TextView tvRegistrarse;

    private EditText etmail, etpswrd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
        tvRegistrarse = findViewById(R.id.tv_registrarse);
        etmail = findViewById(R.id.et_correo_electronico);
        etpswrd = findViewById(R.id.et_password);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el texto de los EditText
                String email = etmail.getText().toString().trim();
                String password = etpswrd.getText().toString().trim();

                // Verifica si los campos están vacíos y cambia los fondos si es necesario
                if (email.isEmpty() && password.isEmpty() ) {
                    etmail.setBackgroundResource(R.drawable.edit_text_border);
                    etpswrd.setBackgroundResource(R.drawable.edit_text_border);
                    Toast.makeText(LoginActivity.this, "Por Favor Ingrese los Datos", Toast.LENGTH_SHORT).show();
                } else {
                  loginUser(email  , password);
                }
                // Verifica si algún campo está vacío
             /*   if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Mostrar Toast de éxito
                    Toast.makeText(LoginActivity.this, "Iniciaste sesion correctamente", Toast.LENGTH_SHORT).show();

                    // Si no hay campos vacíos, procede con el registro
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }*/


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
private void loginUser(String email, String password){

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });

}


}