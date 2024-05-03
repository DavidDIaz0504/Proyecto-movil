package david.alejandro.projectecomm;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class StartActivity extends AppCompatActivity {

    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logoImageView = findViewById(R.id.logo_start);
    }

    @Override
    protected void onStart() {
        super.onStart();
        iniciarAnimacion();
    }

    private void iniciarAnimacion() {
        // Total duration of animations

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(logoImageView, "alpha", 0f, 1f);
        fadeIn.setDuration(1500);

        ValueAnimator colorFondo = ValueAnimator.ofArgb(
                ContextCompat.getColor(this, R.color.back),
                ContextCompat.getColor(this, R.color.back)
        );
        colorFondo.setDuration(2500);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(logoImageView, "alpha", 1f, 0f);
        fadeOut.setDuration(1000);

        @SuppressLint("Recycle") AnimatorSet conjuntoAnimacion = new AnimatorSet();
        conjuntoAnimacion.playSequentially(fadeIn, colorFondo, fadeOut);

        colorFondo.addUpdateListener(animator -> findViewById(R.id.fondoView_start).setBackgroundColor((Integer) animator.getAnimatedValue()));
    }

}

