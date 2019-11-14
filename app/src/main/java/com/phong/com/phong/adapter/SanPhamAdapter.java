package com.phong.com.phong.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.phong.baitaprenluyentugiai4_2.R;
import com.phong.model.SanPham;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Nạp file layout vào bộ nhớ:
        LayoutInflater layoutInflater =this.context.getLayoutInflater();
        //Nạp item.xml lên:
        View customView =layoutInflater.inflate(this.resource, null);//resource chính là item.xml
        //Lấy các controls trên giao diện:
        ImageView imgHinh = (ImageView) customView.findViewById(R.id.imgHinh);
        TextView txtTen = (TextView) customView.findViewById(R.id.txtTen);
        TextView txtGia = (TextView) customView.findViewById(R.id.txtGia);
        //Nạp dữ liệu lên cho Controls: muốn nạp thì̀ lấy đối tượng ra
        //Đối số 1 của getView là vị trí mà đối tượng đó đang đc nhân bản lên
        SanPham sp = getItem(position);//tư động lấy đối tượng dữ liệu ra ở vị trí thứ position nào đó
        //Show lên:
        imgHinh.setImageResource(sp.getHinh());
        txtTen.setText(sp.getTen());
        txtGia.setText("Giá:" + sp.getGia() + "/thùng");
        return customView;
    }
}
