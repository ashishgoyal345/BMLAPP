package bmu.in.bmuapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends Activity implements Animation.AnimationListener{

    ImageView b1 ;
    TextToSpeech tts;


    // Animation
    Animation  animfadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (ImageView)findViewById(R.id.img1);

        animfadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        b1.setVisibility(View.VISIBLE);
        b1.startAnimation(animfadein);





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(i); // to start the activity
                finish(); // so that when we press back this screen will never come

            }
        },3000);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
