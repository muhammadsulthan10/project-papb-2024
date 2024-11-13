package com.example.homepage;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Navbar extends AppCompatActivity implements View.OnClickListener {

    private ImageView btnHome, btnEvent, btnTiket, btnProfil;
    private ImageView selectedButton;
    private OnNavbarItemSelectedListener listener;

    // Deklarasi interface di dalam Navbar.java
    public interface OnNavbarItemSelectedListener {
        void onNavbarItemSelected(int itemId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar); // Mengatur layout untuk Activity

        btnHome = findViewById(R.id.home);
        btnEvent = findViewById(R.id.event);
        btnTiket = findViewById(R.id.tiket);
        btnProfil = findViewById(R.id.profil);

        btnHome.setOnClickListener(this);
        btnEvent.setOnClickListener(this);
        btnTiket.setOnClickListener(this);
        btnProfil.setOnClickListener(this);

        setButtonSelected(btnHome); // Tombol awal yang dipilih

        // Inisialisasi listener jika Activity ini mengimplementasikannya
        if (this instanceof OnNavbarItemSelectedListener) {
            listener = (OnNavbarItemSelectedListener) this;
        }
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onNavbarItemSelected(view.getId());
        }
        setButtonSelected((ImageView) view);
    }

    private void setButtonSelected(ImageView button) {
        if (selectedButton != null) {
            selectedButton.clearColorFilter();
        }
        button.setColorFilter(0xFF0000FF, PorterDuff.Mode.SRC_IN); // Ubah warna menjadi biru
        selectedButton = button;
    }
}
