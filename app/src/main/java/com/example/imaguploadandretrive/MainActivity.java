package com.example.imaguploadandretrive;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }

    public void img(View view) {
        Intent intent = new Intent(MainActivity.this, facial_emotion.class);
        startActivity(intent);
    }

    public void text(View view) {
        Intent intent = new Intent(MainActivity.this, textual_emotion.class);
        startActivity(intent);
    }

    public void speech(View view) {
        Intent intent = new Intent(MainActivity.this, speech_emotion.class);
        startActivity(intent);
    }
}