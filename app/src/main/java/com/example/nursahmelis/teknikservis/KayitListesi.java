package com.example.nursahmelis.teknikservis;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
public class KayitListesi extends AppCompatActivity {
    RecyclerView rvKayitlar;
    Button btnBack;
    ArrayList<ServisKayit> kayitlar;
    ServisKayitAdapter servisKayitAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_listesi);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            kayitlar = (ArrayList<ServisKayit>) getIntent().getSerializableExtra("kayitlar");
        }
        rvKayitlar = (RecyclerView) findViewById(R.id.rvKayitlar);
        btnBack = (Button) findViewById(R.id.btnBack);
        servisKayitAdapter = new ServisKayitAdapter(kayitlar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvKayitlar.setLayoutManager(mLayoutManager);
        rvKayitlar.setAdapter(servisKayitAdapter);
        rvKayitlar.setItemAnimator(new DefaultItemAnimator());
    }
    public void btnBackTapped(View view){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}