package mosquito.project.com.mosquiteend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by Administrator on 3/31/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private Runnable runnable;
    private Handler handler;
    private static final int POST_DISPLAY_TIME = 2000;
    private ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplash = (ImageView) findViewById(R.id.img_splash);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        };
        handler.postDelayed(runnable, POST_DISPLAY_TIME);
    }
}
