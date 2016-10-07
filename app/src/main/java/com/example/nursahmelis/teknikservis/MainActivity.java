package com.example.nursahmelis.teknikservis;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class MainActivity extends AppCompatActivity {
    public EditText etIsletmeAdi, etCihazAdi, etCihazKodu, etArizaTanimi;
    public TextView textView;
    public Button save, load;
    ArrayList<ServisKayit> kayitlar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIsletmeAdi = (EditText) findViewById(R.id.etIsletmeAdi);
        etCihazAdi = (EditText) findViewById(R.id.etCihazAdi);
        etCihazKodu = (EditText) findViewById(R.id.etCihazKodu);
        etArizaTanimi = (EditText) findViewById(R.id.etArizaTanimi);
        save = (Button) findViewById(R.id.kaydet);
        load = (Button) findViewById(R.id.goster);
        kayitlar = readFromDeviceStorage(this);
    }
    public void buttonSave (View view)
    {
        String isletmeAdi = etIsletmeAdi.getText().toString();
        String cihazAdi = etCihazAdi.getText().toString();
        String cihazKodu = etCihazKodu.getText().toString();
        String arizaTanimi = etArizaTanimi.getText().toString();
        ServisKayit yeniKayit = new ServisKayit(isletmeAdi,cihazAdi,arizaTanimi,cihazKodu);
        kayitlar.add(yeniKayit);
        saveToDeviceStorage(kayitlar, this);
    }
    public void buttonLoad (View view)
    {
        Intent intent = new Intent(getBaseContext(), KayitListesi.class);
        intent.putExtra("kayitlar", kayitlar);
        startActivity(intent);
    }
    public void saveToDeviceStorage(ArrayList<ServisKayit> kayitlar, Context context){
        SharedPreferences mPrefs = context.getSharedPreferences("kayitlar", context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String jsonCars = gson.toJson(kayitlar);
        prefsEditor.putString("myJson", jsonCars);
        prefsEditor.commit();
    }
    public ArrayList<ServisKayit> readFromDeviceStorage(Context context){
        ArrayList<ServisKayit> kayitlar = new ArrayList<ServisKayit>();
        SharedPreferences mPrefs = context.getSharedPreferences("kayitlar", context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("myJson", "");
        if (json.isEmpty()) {
            kayitlar = new ArrayList<ServisKayit>();
        } else {
            Type type = new TypeToken<List<ServisKayit>>() {
            }.getType();
            kayitlar = gson.fromJson(json, type);
        }
        return kayitlar;
    }
}