package com.example.homepage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView btnHome, btnEvent, btnTiket, btnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi tombol navigasi
        btnHome = findViewById(R.id.home);
        btnEvent = findViewById(R.id.event);
        btnTiket = findViewById(R.id.tiket);
        btnProfil = findViewById(R.id.profil);

        // Set onClickListener untuk masing-masing tombol
        btnHome.setOnClickListener(this);
        btnEvent.setOnClickListener(this);
        btnTiket.setOnClickListener(this);
        btnProfil.setOnClickListener(this);

        // Tampilkan konten awal (Home)
        displayContent(R.layout.homepage); // Pastikan ada layout `homepage.xml`
    }

    // Method untuk menampilkan layout konten berdasarkan ID layout
    private void displayContent(int layoutId) {
        setContentView(layoutId);
        initNavbarButtons(); // Menginisialisasi kembali tombol setelah perubahan tampilan
    }

    // Method untuk inisialisasi ulang tombol navbar setelah perubahan layout
    private void initNavbarButtons() {
        btnHome = findViewById(R.id.home);
        btnEvent = findViewById(R.id.event);
        btnTiket = findViewById(R.id.tiket);
        btnProfil = findViewById(R.id.profil);

        btnHome.setOnClickListener(this);
        btnEvent.setOnClickListener(this);
        btnTiket.setOnClickListener(this);
        btnProfil.setOnClickListener(this);
    }

    // Menangani klik pada tombol navbar
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                displayContent(R.layout.homepage); // Ganti dengan layout konten Home
                break;
            case R.id.event:
                displayContent(R.layout.event); // Ganti dengan layout konten Event
                break;
            case R.id.tiket:
                displayContent(R.layout.tiket); // Ganti dengan layout konten Tiket
                break;
            case R.id.profil:
                displayContent(R.layout.profil); // Ganti dengan layout konten Profil
                break;
        }
    }
}
