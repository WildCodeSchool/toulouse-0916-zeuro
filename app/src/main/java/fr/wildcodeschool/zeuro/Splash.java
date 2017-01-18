package fr.wildcodeschool.zeuro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import fr.wildcodeschool.zeuro.DBHandler.DBHandler;

public class Splash extends AppCompatActivity {
        private static int SPLASH_TIME_OUT ;
        private DBHandler mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.mDBHelper = new DBHandler(this);
        //this.copyDatabase(this);
        // check if database exist
        File database = this.getApplicationContext().getDatabasePath("databaselite.sqlite");
        if (!database.exists()) {
            this.mDBHelper.getReadableDatabase();
            // and copy database with method
            if (!this.copyDatabase(this)) {
                Toast.makeText(this, "error cannot copy Database", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        final ImageView iv = (ImageView) findViewById(R.id.imgSplash);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
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
        });}
        //copying database from assets to database folder
    private boolean copyDatabase(Context context) {
        try {
            InputStream inpuStream = context.getAssets().open("databaselite.sqlite");
            // set target of output
            OutputStream outputStream = new FileOutputStream(getDatabasePath("databaselite.sqlite"));
            // buffer
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inpuStream.read(buff)) > 0) {
                //writing
                outputStream.write(buff, 0, length);

            }
            //clear buffer
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;

        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

}

