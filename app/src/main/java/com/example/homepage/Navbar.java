package com.example.homepage;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Navbar extends Fragment implements View.OnClickListener {

    private ImageView btnHome, btnEvent, btnTiket, btnProfil;
    private ImageView selectedButton;
    private OnNavbarItemSelectedListener listener;

    // Deklarasi interface di dalam Navbar.java
    public interface OnNavbarItemSelectedListener {
        void onNavbarItemSelected(int itemId);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnNavbarItemSelectedListener) {
            listener = (OnNavbarItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " harus mengimplementasikan OnNavbarItemSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navbar, container, false);

        btnHome = view.findViewById(R.id.home);
        btnEvent = view.findViewById(R.id.event);
        btnTiket = view.findViewById(R.id.tiket);
        btnProfil = view.findViewById(R.id.profil);

        btnHome.setOnClickListener(this);
        btnEvent.setOnClickListener(this);
        btnTiket.setOnClickListener(this);
        btnProfil.setOnClickListener(this);

        setButtonSelected(btnHome);  // Tombol awal yang dipilih
        return view;
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
