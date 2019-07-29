package com.antonius1998gmail.tamobile;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class list extends Activity {
Button btnkml;
    protected ListView lv;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Ltn;
    String[] Gbr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        btnkml = (Button) findViewById(R.id.btnkml);

       btnkml.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                //perintah untuk mengakhiri aplikasi
              Intent intent = new Intent(list.this, Welcome.class);
                list.this.startActivity(intent);
                //finish();
            }
        });
        lv = (ListView) findViewById(R.id.lv);

        Pil = new String[] {"Institut Pertanian Bogor", "Universitas Padjadjaran", "Universitas Pembangunan Nasional",
                            "Universitas Negri Gorontalo", "Universitas Muhammadiyah Tangerang ","Universitas Tenologi Nasional",
                            "Universitas Negri Malang"};
        Ltn = new String[] {"Loc: Bogor", "Loc: Bandung", "Loc: Yogyakarta", "Loc: Gorontalo", "Loc: Tangerang","Loc: Malang","Loc: Malang"};
        Gbr = new String[] {Integer.toString(R.drawable.its),
                Integer.toString(R.drawable.unpad1),
                Integer.toString(R.drawable.upn1),
                Integer.toString(R.drawable.ung1),
                Integer.toString(R.drawable.umt1),
                Integer.toString(R.drawable.itn1),
                Integer.toString(R.drawable.umn1)};

        mylist = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < Pil.length; i++){
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("latin", Ltn[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(this, mylist, R.layout.list2,
                new String[] {"list", "latin", "gbr"}, new int[] {R.id.tv_nama, R.id.tv_ltn, R.id.imV});
        lv.setAdapter(Adapter);
    }

}