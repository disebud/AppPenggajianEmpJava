package com.disebud.penghitungangaji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

public class HitungGaji extends AppCompatActivity {
    String bulanGajiIn,namaKaryawanIn ;
    Integer gajiPokokIn , lemburIn , golonganIn , hariMasukIn , hasilTunjanganGolongan , hasilTunjanganTransport , hasilUangMakan , hasilGajiKotor , hasilPajak , hasilGajiBersih;

    EditText bulanGaji, namaKaryawan , gajiPokok , lembur , golongan , hariMasuk , tunjanganGolongan , tunjanganTrasnsport , uangMakan , gajiKotor , pajak,gajiBersih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_gaji);

        bulanGaji = (EditText) findViewById(R.id.et_bulan_gaji_hitung);
        namaKaryawan = (EditText) findViewById(R.id.et_nama_karyawan_hitung);
        gajiPokok = (EditText) findViewById(R.id.et_gaji_pokok_hitung);
        lembur = (EditText) findViewById(R.id.et_lembur_hitung);
        golongan = (EditText) findViewById(R.id.et_Golongan_hitung);
        hariMasuk = (EditText) findViewById(R.id.et_hari_masuk_hitung);
        tunjanganGolongan = (EditText) findViewById(R.id.et_tunjangan_golongan_hitung);
        tunjanganTrasnsport = (EditText) findViewById(R.id.et_tunjangan_transport_hitung);
        uangMakan = (EditText) findViewById(R.id.et_uang_makan);
        gajiKotor = (EditText) findViewById(R.id.et_gaji_kotor);
        pajak = (EditText) findViewById(R.id.et_pajak);
        gajiBersih = (EditText) findViewById(R.id.et_gaji_bersih);

        bulanGajiIn = getIntent().getStringExtra("bulanGaji");
        namaKaryawanIn = getIntent().getStringExtra("namaKaryawan");
        gajiPokokIn = Integer.parseInt(getIntent().getStringExtra("gajiPokok"));
        lemburIn = Integer.parseInt(getIntent().getStringExtra("lembur"));
        golonganIn = Integer.parseInt(getIntent().getStringExtra("golongan"));
        hariMasukIn = Integer.parseInt(getIntent().getStringExtra("hariMasuk"));

        if (golonganIn == 1 ){
            hasilTunjanganGolongan = 250000;
        }else if (golonganIn == 2){
            hasilTunjanganGolongan = 500000;
        }else if (golonganIn == 3){
            hasilTunjanganGolongan = 750000;
        }else{
            hasilTunjanganGolongan = 1000000;
        }

        hasilTunjanganTransport = hariMasukIn * 25000;

        hasilUangMakan = hariMasukIn * 20000;

        hasilGajiKotor = gajiPokokIn + lemburIn + hasilTunjanganGolongan + hasilTunjanganTransport + hasilUangMakan;

        hasilPajak = hasilGajiKotor * 10/100 ;

        hasilGajiBersih = hasilGajiKotor - hasilPajak ;

        Locale locale = new Locale("in","ID");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        bulanGaji.setText(bulanGajiIn);
        namaKaryawan.setText(namaKaryawanIn);
        gajiPokok.setText("Rp." + numberFormat.format(gajiPokokIn));
        lembur.setText("Rp." + numberFormat.format(lemburIn));
        golongan.setText(String.valueOf(golonganIn));
        hariMasuk.setText(String.valueOf(hariMasukIn));
        tunjanganGolongan.setText("Rp." + numberFormat.format(hasilTunjanganGolongan));
        tunjanganTrasnsport.setText("Rp." + numberFormat.format(hasilTunjanganTransport));
        uangMakan.setText("Rp." + numberFormat.format(hasilUangMakan));
        gajiKotor.setText("Rp." + numberFormat.format(hasilGajiKotor));
        pajak.setText("Rp." + numberFormat.format(hasilPajak));
        gajiBersih.setText("Rp." + numberFormat.format(hasilGajiBersih));

    }

    public void MenuUtama(View view) {
        Intent in = new Intent(HitungGaji.this,MainActivity.class);
        startActivity(in);
    }
}