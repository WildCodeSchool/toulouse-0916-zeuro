package fr.wildcodeschool.zeuro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
        private static int SPLASH_TIME_OUT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final ImageView iv = (ImageView) findViewById(R.id.imgSplash);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
      /*  final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);*/
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /*iv.startAnimation(an2);*/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent runmain = new Intent(Splash.this,MainActivity.class);
                        startActivity(runmain);
                        finish();
                    }
                }, SPLASH_TIME_OUT);
                finish();
                Intent i = new Intent (Splash.this.getBaseContext(),MainActivity.class);
                startActivity(i);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

}}
