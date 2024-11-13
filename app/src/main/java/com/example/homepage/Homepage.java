package com.example.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Homepage extends Fragment {

    private Button happysep;

    // Ubah onCreate menjadi onCreateView untuk fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout untuk fragment
        View view = inflater.inflate(R.layout.homepage, container, false);

        // Inisialisasi tombol "Selengkapnya" dengan findViewById dari view
        happysep = view.findViewById(R.id.happybutton);
        happysep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menggunakan requireActivity() untuk mendapatkan konteks activity
                Intent intent = new Intent(requireActivity(), Happysep.class);
                startActivity(intent);
            }
        });

        return view; // Mengembalikan tampilan fragment
    }
}
