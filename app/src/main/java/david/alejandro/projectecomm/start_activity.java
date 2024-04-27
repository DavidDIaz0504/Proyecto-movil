package david.alejandro.projectecomm;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class start_activity extends AppCompatActivity {

    private ImageView logoImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logoImageView = findViewById(R.id.logo_start);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        iniciarAnimacion();
    }

    private void iniciarAnimacion() {
        int animationDuration = 5000; // Total duration of animations

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(logoImageView, "alpha", 0f, 1f);
        fadeIn.setDuration(1500);

        ValueAnimator colorFondo = ValueAnimator.ofArgb(
                ContextCompat.getColor(this, R.color.back),
                ContextCompat.getColor(this, R.color.back)
        );
        colorFondo.setDuration(2500);

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(logoImageView, "alpha", 1f, 0f);
        fadeOut.setDuration(1000);

        AnimatorSet conjuntoAnimacion = new AnimatorSet();
        conjuntoAnimacion.playSequentially(fadeIn, colorFondo, fadeOut);

        colorFondo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                findViewById(R.id.fondoView_start).setBackgroundColor((Integer) animator.getAnimatedValue());
            }
        });

        ValueAnimator progressAnimator = ValueAnimator.ofInt(0, 100);
        progressAnimator.setDuration(animationDuration);
        progressAnimator.addUpdateListener(animation -> progressBar.setProgress((Integer) animation.getAnimatedValue()));

        conjuntoAnimacion.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {
                progressAnimator.start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(start_activity.this, login_activity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {
            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {
            }
        });

        conjuntoAnimacion.start();
    }
}

