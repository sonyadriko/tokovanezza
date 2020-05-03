package com.example.tokovanezza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TambahBarang extends AppCompatActivity {

    private static final String URL = "https://tokovanezza.000webhostapp.com/";
    private EditText etbarang,etharga,ettempat;
    private Button tmbh;
    private FirebaseDatabase dbBarang;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);
        FirebaseApp.initializeApp(this);
        etbarang = findViewById(R.id.etBarang);
        etharga = findViewById(R.id.etHarga);
        ettempat = findViewById(R.id.etTempat);
        tmbh = findViewById(R.id.btnTbhBrg);
       // dbBarang = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("barang");

        tmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBarang();
            }
        });

       /* tmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etbarang.getText().toString();
                String hargab = etharga.getText().toString();
                String tempatb = ettempat.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RegistAPI api = retrofit.create(RegistAPI.class);
                Call<Value> call = api.tmbhbarang(nama,hargab,tempatb);
                call.enqueue(new Callback<Value>() {
                    @Override
                    public void onResponse(Call<Value> call, Response<Value> response) {
                        String value = response.body().getValue();
                        String message = response.body().getBarang();
                        Toast.makeText(TambahBarang.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Value> call, Throwable t) {
                        Toast.makeText(TambahBarang.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
-
        */
    }

    private void addBarang() {
        String nama = etbarang.getText().toString();
        String harga = etharga.getText().toString();
        String tempat = ettempat.getText().toString();

        if (!TextUtils.isEmpty(nama)){
            String id = databaseReference.push().getKey();

            Barang barang = new Barang(id,nama,harga,tempat);
            databaseReference.child(id).setValue(barang);
            Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
