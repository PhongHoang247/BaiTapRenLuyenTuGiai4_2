package com.phong.baitaprenluyentugiai4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.phong.model.SanPham;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    TextView txtHangSanXuat;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        addControls();
    }

    private void addControls() {
        txtHangSanXuat = (TextView) findViewById(R.id.txtHangSanXuat);
        intent = getIntent();
        SanPham sp = (SanPham) intent.getSerializableExtra("SANPHAM");
        txtHangSanXuat.setText(sp.getTen());
    }
}
