package com.phong.baitaprenluyentugiai4_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.phong.com.phong.adapter.SanPhamAdapter;
import com.phong.model.SanPham;

public class MainActivity extends AppCompatActivity {

    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        fakeData();
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SanPham sp = sanPhamAdapter.getItem(i);
                Intent intent = new Intent(MainActivity.this, ChiTietSanPhamActivity.class);
                intent.putExtra("SANPHAM", sp);
                startActivityForResult(intent, 742);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void fakeData() {
        sanPhamAdapter.add(new SanPham(R.drawable.hinh1,"Pepsi",450000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh2,"7Up",400000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh3,"Coca",420000));
        sanPhamAdapter.add(new SanPham(R.drawable.hinh4,"Fanta",350000));
    }

    private void addControls() {
        lvSanPham = (ListView) findViewById(R.id.lvSanPham);
        /*
        Làm adapter
        Đối số 1 là màn hình sử dụng nó
        Đối số 2 là layout mình làm
         */
        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item);
        //Gán adapter cho listview:
        lvSanPham.setAdapter(sanPhamAdapter);
    }
}
