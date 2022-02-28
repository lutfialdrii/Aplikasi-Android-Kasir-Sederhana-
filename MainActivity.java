package com.example.aplikasikasir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvJumlahBayar, tvHarga,tvBarang, tvTotal, tvDiskon, tvKodeTransaksi;
    private EditText etKodeBarang, etJumlah, etKodeDiskon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        etKodeDiskon = findViewById(R.id.etKodeDiskon);
        etKodeBarang = findViewById(R.id.etKodeBarang);
        etJumlah = findViewById(R.id.etJumlah);
        Button btnHitung = findViewById(R.id.btnHitung);
        tvJumlahBayar = findViewById(R.id.tvJumlahBayar);
        tvBarang = findViewById(R.id.tvBarang);
        tvTotal = findViewById(R.id.tvTotal);
        tvDiskon = findViewById(R.id.tvDiskon);
        tvHarga = findViewById(R.id.tvHarga);
        tvKodeTransaksi = findViewById(R.id.tvKodeTransaksi);

        btnHitung.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnHitung) {
            //proses menghitung
            String Kode = etKodeBarang.getText().toString().trim();
            String Jumlah = etJumlah.getText().toString().trim();
            String KodeDiskon = etKodeDiskon.getText().toString().trim();

            //Cek
            boolean tidakdiinput = false;
            if (TextUtils.isEmpty(Kode)) {
                tidakdiinput = true;
                etKodeBarang.setError("Tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(Jumlah)) {
                tidakdiinput = true;
                etJumlah.setError("Tidak boleh kosong!");
            }
            if (TextUtils.isEmpty(KodeDiskon)) {
                tidakdiinput = true;
                etKodeDiskon.setError("Tidak boleh kosong!");
            }
            if (!tidakdiinput) {
                String kodebarang = etKodeBarang.getText().toString().substring(0,3);
                String diskon = etKodeBarang.getText().toString().substring(3);
                if (kodebarang.equals("AND")) {
                    String nama1 = "Android";
                    int harga1 = 1000000;
                    tvBarang.setText(nama1);
                    tvHarga.setText(String.valueOf(harga1));

                    String kodetransaksi = etKodeBarang.getText().toString() + etKodeDiskon.getText().toString();
                    tvKodeTransaksi.setText(kodetransaksi);

                    int totalHarga = harga1 * Integer.parseInt( etJumlah.getText().toString());
                    tvTotal.setText("" + totalHarga);

                    int Diskon = (totalHarga * Integer.parseInt(diskon))/ 100;
                    tvDiskon.setText(""+ Diskon);

                    int JumlahBayar = totalHarga - Diskon;
                    tvJumlahBayar.setText("" + JumlahBayar);
                }
            }
        }
    }
}
