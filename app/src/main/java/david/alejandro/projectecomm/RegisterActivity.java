package david.alejandro.projectecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private Button btnCrearCuenta;
    private EditText etName, etEmail, etPassword;
    private TextView tvlogin;
     FirebaseFirestore miFirestore;
     FirebaseAuth mAuth;
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
        //base de datos
        miFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el texto de los EditText
                String nameUser = etName.getText().toString().trim();
                String emailUser = etEmail.getText().toString().trim();
                String passwordUser= etPassword.getText().toString().trim();

                if(nameUser.isEmpty() && emailUser.isEmpty() && passwordUser.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Complete los datos", Toast.LENGTH_SHORT).show();
                }else{ registerUser(nameUser, emailUser, passwordUser);              }
              /*  // Verifica si los campos están vacíos y cambia los fondos si es necesario
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
                }*/
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

    private void registerUser(String nameUser, String emailUser, String passwordUser) {
        mAuth.createUserWithEmailAndPassword(emailUser,passwordUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id", id);
                map.put("name", nameUser);
                map.put("email", emailUser);
                map.put("password", passwordUser);

                miFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        Toast.makeText(RegisterActivity.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });


    }
}