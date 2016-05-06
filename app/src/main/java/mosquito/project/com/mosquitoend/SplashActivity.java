package mosquito.project.com.mosquitoend;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 3/31/2016.
 */
public class SplashActivity extends AppCompatActivity {
    private Runnable runnable;
    private Handler handler;
    private static final int POST_DISPLAY_TIME = 2500;
    private ImageView imgSplash, imgMore;
    private AnimationDrawable animationDrawable;
    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgSplash = (ImageView) findViewById(R.id.img_splash);
        imgMore = (ImageView) findViewById(R.id.img_more);
         mediaPlayer= MediaPlayer.create(getApplicationContext(), R.raw.mosquito_sound1);

        imgMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                setProgressDialog();
                overridePendingTransition(R.animator.activity_open_translate, R.animator.zoom_in);
                finish();
            }
        });

        imgSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_LONG).show();
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgSplash.setImageResource(R.drawable.img_splash);
                } else {
                    mediaPlayer.start();
                    imgSplash.setImageResource(R.drawable.img_splash_after);
                }
            }
        });
    }

    private void setProgressDialog(){
        progressDialog=new ProgressDialog(SplashActivity.this);
        progressDialog.setMessage("Loading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("EXIT")
                    .setMessage("Would you like to exit Application ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
                            SplashActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
