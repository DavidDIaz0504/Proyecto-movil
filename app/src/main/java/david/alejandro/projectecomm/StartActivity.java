package david.alejandro.projectecomm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
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
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(logoImageView, "alpha", 0f, 1f);
        fadeIn.setDuration(1500);

        ValueAnimator colorFondo = ValueAnimator.ofArgb(
                ContextCompat.getColor(this, R.color.back),
                ContextCompat.getColor(this, R.color.back)
        );
        colorFondo.setDuration(1000);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(logoImageView, "alpha", 1f, 0f);
        fadeOut.setDuration(1000);

        AnimatorSet conjuntoAnimacion = new AnimatorSet();
        conjuntoAnimacion.playSequentially(fadeIn, colorFondo, fadeOut);

        // Updating the background color with animation update listener
        colorFondo.addUpdateListener(animator -> findViewById(R.id.fondoView_start).setBackgroundColor((Integer) animator.getAnimatedValue()));

        // Set Animator Listener to start LoginActivity when animation ends
        conjuntoAnimacion.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                // Actions to do at the start of the animation
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // Start LoginActivity when animation ends
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // Actions to do if the animation is canceled
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                // Actions to do on animation repeat
            }
        });

        conjuntoAnimacion.start();
    }
}


