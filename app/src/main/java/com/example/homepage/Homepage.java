package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    private Button happysep;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage); // Mengatur layout untuk Activity

        // Inisialisasi tombol "Selengkapnya"
        happysep = findViewById(R.id.happybutton);
        happysep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk berpindah ke Activity Happysep
                Intent intent = new Intent(Homepage.this, Happysep.class);
                startActivity(intent);
            }
        });
    }
}
