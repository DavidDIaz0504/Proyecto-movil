package david.alejandro.projectecomm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PaymentGatewayActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Asegúrate de que setContentView se llame aquí
        setContentView(R.layout.activity_payment_gateway);

        // Inicializa el toolbar después de setContentView
        toolbar = findViewById(R.id.top_app_bar_payment);

        // Verifica si toolbar no es nulo antes de usarlo
        if (toolbar != null) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else {
            // Manejar el caso en que toolbar sea nulo
            throw new RuntimeException("Toolbar not found in the layout");
        }
    }
}
