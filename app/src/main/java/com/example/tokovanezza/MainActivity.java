package com.example.tokovanezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tokovanezza.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbBarang;

    FirebaseRecyclerAdapter<Barang, MenuViewHolder> adapter;

    TextView txtName;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton tmbhbrg = findViewById(R.id.tambah_barang);

        firebaseDatabase = FirebaseDatabase.getInstance();
        dbBarang = firebaseDatabase.getReference("bar       ang");

        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        tmbhbrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(MainActivity.this, TambahBarang.class);
                startActivity(t);
            }
        });

        loadmenu();



    }

    private void loadmenu() {
        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Barang>()
                .setQuery(dbBarang, Barang.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Barang, MenuViewHolder>(options) {
            @NonNull
            @Override
            public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_barang,parent,false);
                return new MenuViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MenuViewHolder holder, int position, @NonNull Barang model) {
                holder.textView.setText(model.getNama());
            }


        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
