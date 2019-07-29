package com.antonius1998gmail.tamobile;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class kamera extends AppCompatActivity {
    private Button btCamera;
    Button btnkembali;
    private ImageView ivCamera;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int CAMERA_REQUEST_CODE = 7777;
    Bitmap jj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);
        // memangil fungsi button dan image gambar
        btCamera = (Button) findViewById(R.id.btkamera);
        ivCamera = (ImageView) findViewById(R.id.gambar);
        btnkembali = (Button) findViewById(R.id.btnkembali);
        btCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perintah untuk mengakhiri aplikasi
                Intent intent = new Intent(kamera.this, Welcome.class);
                kamera.this.startActivity(intent);
                finish();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (CAMERA_REQUEST_CODE):
                if (resultCode == Activity.RESULT_OK) {
                    // result code sama, save gambar ke bitmap
                    menyimpangambar(jj);
                    Bitmap bitmap;
                    bitmap = (Bitmap) data.getExtras().get("data");
                    ivCamera.setImageBitmap(bitmap);
                }
                break;
        }
    }
    //pemangilan fungsi simpan yang suadah di deklarasiakn pada bitmap diatas dan akan di simpan di berkas dalam folder picture
    private void menyimpangambar(Bitmap finalBitmap) {
        File mediaStorageDir= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString());
        if (!mediaStorageDir.exists()) {
            mediaStorageDir.mkdirs();
        }
        Toast.makeText(this, mediaStorageDir.toString(), Toast.LENGTH_LONG).show();
        Random generator = new Random();
        int m = 10000;
        m = generator.nextInt(m);
        File anton = new File (mediaStorageDir,  "IMG_"+ m +".jpg");
        if (anton.exists ())
            anton.delete ();

        try {
            FileOutputStream out = new FileOutputStream(anton);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
