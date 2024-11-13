package com.example.homepage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements Navbar.OnNavbarItemSelectedListener {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi FragmentManager
        this.fm = this.getSupportFragmentManager();
        FragmentTransaction ft = this.fm.beginTransaction();

        // Tambahkan fragment Navbar ke container_bawah
        ft.add(R.id.container_bawah, new Navbar(), "FB");
        ft.commit();

        // Tampilkan fragment awal di container_atas
        displayFragment(new Homepage()); // Pastikan Homepage adalah class yang extends Fragment
    }

    // Method untuk menampilkan fragment di container_atas
    private void displayFragment(Fragment fragment) {
        FragmentTransaction ft = this.fm.beginTransaction();
        ft.replace(R.id.container_atas, fragment);
        ft.commit();
    }

    // Method dari interface OnNavbarItemSelectedListener untuk menangani pilihan dari Navbar
    @Override
    public void onNavbarItemSelected(int itemId) {
        Fragment selectedFragment = null;

        // Gunakan if-else untuk menentukan fragment berdasarkan itemId
        if (itemId == R.id.home) {
            selectedFragment = new Homepage(); // Pastikan Homepage extends Fragment
        } else if (itemId == R.id.event) {
            selectedFragment = new Event(); // Pastikan Event extends Fragment
        } else if (itemId == R.id.tiket) {
            selectedFragment = new Tiket(); // Pastikan Tiket extends Fragment
        } else if (itemId == R.id.profil) {
            selectedFragment = new Profil(); // Pastikan Profil extends Fragment
        }

        // Jika ada fragment yang dipilih, panggil displayFragment untuk menggantinya
        if (selectedFragment != null) {
            displayFragment(selectedFragment);
        }
    }
}
