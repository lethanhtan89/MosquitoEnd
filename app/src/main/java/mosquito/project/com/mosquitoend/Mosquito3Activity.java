package mosquito.project.com.mosquitoend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Administrator on 29/03/2016.
 */
public class Mosquito3Activity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button btOn, btOff, btAlarm30, btAlarm60, btAlarm90;
    private ImageButton img;
    private Context context = this;
    private Handler handler;
    private Runnable runnable;
    private static final int POST_DISPLAY_TIME_30 = 1800000;
    private static final int POST_DISPLAY_TIME_60 = 3600000;
    private static final int POST_DISPLAY_TIME_90 = 5400000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosquito3);

        btOn = (Button) findViewById(R.id.btOn);
        btOff = (Button) findViewById(R.id.btOff);
        btAlarm30 = (Button) findViewById(R.id.btalarm30);
        btAlarm60 = (Button) findViewById(R.id.btalarm60);
        btAlarm90 = (Button) findViewById(R.id.btalarm90);
        mediaPlayer = MediaPlayer.create(Mosquito3Activity.this, R.raw.mosquito_sound3);

        btOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    Toast.makeText(Mosquito3Activity.this,"Please again", Toast.LENGTH_LONG).show();
                    mediaPlayer.pause();
                }
                else {
                    mediaPlayer.start();
                }
                mediaPlayer.setLooping(true);
            }
        });

        btOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }
        });

        btAlarm30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("SET ALARM");
                builder.setMessage("Would you like to set Alarm after 30 minutes");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Mosquito3Activity.this, "Successfull", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("SET ALARM");
                builder.setMessage("Would you like to set Alarm after 60 minutes");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Mosquito3Activity.this, "Successfull", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("SET ALARM");
                builder.setMessage("Would you like to set Alarm after 90 minutes");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Mosquito3Activity.this, "Successfull", Toast.LENGTH_SHORT).show();
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
        finish();
        mediaPlayer.stop();
    }

    public void setAlarmAfter30(){
        mediaPlayer = MediaPlayer.create(Mosquito3Activity.this, R.raw.mosquito_sound3);
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
//Set alarm 60 minites
    public void setAlarmAfter60(){
        mediaPlayer = MediaPlayer.create(Mosquito3Activity.this, R.raw.mosquito_sound3);
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

    public void setAlarmAfter90(){
        mediaPlayer = MediaPlayer.create(Mosquito3Activity.this, R.raw.mosquito_sound3);
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
}
