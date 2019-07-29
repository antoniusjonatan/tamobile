package com.antonius1998gmail.tamobile;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    Button btnlist;
    Button btnkmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnkmr = (Button) findViewById(R.id.btnkmr);
        btnlist = (Button) findViewById(R.id.btnlist);

        btnkmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perintah untuk mengakhiri aplikasi
                Intent intent = new Intent(Welcome.this, kamera.class);
                Welcome.this.startActivity(intent);
                finish();
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //perintah untuk mengakhiri aplikasi
                Intent intent = new Intent(Welcome.this, list.class);
                Welcome.this.startActivity(intent);
                finish();
            }
        });

    }
}
