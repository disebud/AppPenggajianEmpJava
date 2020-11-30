package com.disebud.penghitungangaji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText bulanGaji, namaKaryawan , gajiPokok , lembur , golongan , hariMasuk  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bulanGaji = (EditText) findViewById(R.id.et_bulan_gaji);
        namaKaryawan = (EditText) findViewById(R.id.et_nama_karyawan);
        gajiPokok = (EditText) findViewById(R.id.et_gaji_pokok);
        lembur = (EditText) findViewById(R.id.et_lembur);
        golongan = (EditText) findViewById(R.id.et_Golongan);
        hariMasuk = (EditText) findViewById(R.id.et_hari_masuk);

    }

    public void hitungGaji(View view) {
        Intent in = new Intent(getApplicationContext(), HitungGaji.class);
        in.putExtra("bulanGaji" , bulanGaji.getText().toString());
        in.putExtra("namaKaryawan" , namaKaryawan.getText().toString());
        in.putExtra("gajiPokok" , gajiPokok.getText().toString());
        in.putExtra("lembur" , lembur.getText().toString());
        in.putExtra("golongan" , golongan.getText().toString());
        in.putExtra("hariMasuk" , hariMasuk.getText().toString());
        startActivity(in);
    }
}