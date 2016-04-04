package mosquito.project.com.mosquiteend;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 29/03/2016.
 */
public class Mosquito1Activity extends AppCompatActivity {

    private Button btOn, btOff, btAlarm30, btAlarm60, btAlarm90;
    //private TextView txtTime;
    private ImageView imageView;
    private AnalogClock analogClock;
    private DigitalClock digitalClock;
    private MediaPlayer mediaPlayer;
    private Context context = this;
    private Handler handler;
    private Runnable runnable;
    private ObjectAnimator objectAnimator;
    private static final int POST_DISPLAY_TIME_30 = 1800000;
    private static final int POST_DISPLAY_TIME_60 = 3600000;
    private static final int POST_DISPLAY_TIME_90 = 5400000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosquito1);

        btOn = (Button) findViewById(R.id.btOn);
        btOff = (Button) findViewById(R.id.btOff);
        btAlarm30 = (Button) findViewById(R.id.btalarm30);
        btAlarm60 = (Button) findViewById(R.id.btalarm60);
        btAlarm90 = (Button) findViewById(R.id.btalarm90);
        imageView = (ImageView) findViewById(R.id.imgMos);
        analogClock = (AnalogClock) findViewById(R.id.analogClock);
        digitalClock = (DigitalClock) findViewById(R.id.digitalClock);

        btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btOn.setBackgroundColor(getResources().getColor(R.color.button_change));
                //btOn.invalidate();
                mediaPlayer = MediaPlayer.create(Mosquito1Activity.this, R.raw.mosquito_sound1);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });

        btOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btOff.setBackgroundColor(getResources().getColor(R.color.button_change));
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });

        btAlarm30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btAlarm30.setBackgroundColor(getResources().getColor(R.color.button_change));
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("SET ALARM");
                builder.setMessage("Would you like set alarm after 30 minutes ?");
                builder.setIcon(R.mipmap.mosquito_icon);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Mosquito1Activity.this, "Successfull", Toast.LENGTH_LONG).show();
                        setAlarmAfter30();
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btAlarm60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btAlarm60.setBackgroundColor(getResources().getColor(R.color.button_change));
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("SET ALARM");
                builder.setMessage("Would you like to set alarm after 60 minutes");
                builder.setIcon(R.mipmap.mosquito_icon);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Mosquito1Activity.this, "Successfull", Toast.LENGTH_LONG).show();
                        setAlarmAfter60();
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btAlarm90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //btAlarm90.setBackgroundColor(getResources().getColor(R.color.button_change));
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("SET ALARM");
                builder.setMessage("Would you like to set alarm after 90 minutes ");
                builder.setIcon(R.mipmap.mosquito_icon);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Mosquito1Activity.this, "Successfull", Toast.LENGTH_LONG).show();
                        setAlarmAfter90();
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();;
    }

    //set Sound Alarm After 30 minutes
    public void setAlarmAfter30(){
            mediaPlayer = MediaPlayer.create(Mosquito1Activity.this, R.raw.mosquito_sound1);
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }
            };
            handler.postDelayed(runnable, POST_DISPLAY_TIME_30);
        }
    // set Sound Alarm After 60 minutes
    public void setAlarmAfter60(){
        mediaPlayer = MediaPlayer.create(Mosquito1Activity.this, R.raw.mosquito_sound1);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        };
        handler.postDelayed(runnable, POST_DISPLAY_TIME_60);
    }
    //set Sound Alarm After 90 minutes
    public void setAlarmAfter90(){
        mediaPlayer = MediaPlayer.create(Mosquito1Activity.this,R.raw.mosquito_sound1);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        };
        handler.postDelayed(runnable, POST_DISPLAY_TIME_90);
    }

    private void Exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("EXIT");
        builder.setMessage("Would you like to exit Apps ?");
        builder.setIcon(R.mipmap.mosquito_icon);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();;
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
