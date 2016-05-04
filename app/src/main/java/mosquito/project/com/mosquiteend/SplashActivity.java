package mosquito.project.com.mosquiteend;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Administrator on 3/31/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private Runnable runnable;
    private Handler handler;
    private static final int POST_DISPLAY_TIME = 2500;
    private ImageView imgSplash;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplash = (ImageView) findViewById(R.id.img_splash);
        //imgSplash.setBackgroundResource(R.drawable.splash_animation);
        //animationDrawable = (AnimationDrawable) imgSplash.getBackground();
        //animationDrawable.start();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.animator.activity_open_translate, R.animator.activity_close_scale);
                finish();
            }
        };
        handler.postDelayed(runnable, POST_DISPLAY_TIME);

    }
}
