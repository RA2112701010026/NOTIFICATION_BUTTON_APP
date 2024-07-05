package com.rowan.notifacation;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID="rowan";
    private static final int rowanID=123;

Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.download,null);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        Bitmap largeIcon= bitmapDrawable.getBitmap();
        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification;
                NotificationManager notificationManager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                     notification=new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.download)
                            .setSubText("rowan")
                            .setContentText("ROWAN RONALD")
                            .setChannelId(CHANNEL_ID)
                            .build();
                            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"rowan",NotificationManager.IMPORTANCE_HIGH));
                }
                else {
                    notification=new Notification.Builder(MainActivity.this)
                            .setLargeIcon(largeIcon)
                            .setSmallIcon(R.drawable.download)
                            .setSubText("rowan")
                            .setContentText("ROWAN RONALD")
                            .build();
                }
                notificationManager.notify(rowanID,notification);
            }


        });

    }
}