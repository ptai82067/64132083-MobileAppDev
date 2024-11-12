package com.example.listview_nangcao;


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

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<CaFe> {
    //Khai bao bien
    Activity context;
    int idlayout;
    ArrayList<CaFe> listCaFe;

    public MyAdapter( Activity context, int idlayout, ArrayList<CaFe> listCaFe) {
        super(context, idlayout, listCaFe);
        this.context = context;
        this.idlayout = idlayout;
        this.listCaFe = listCaFe;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // tao de chua layout

        if (convertView == null) {
            // Khởi tạo LayoutInflater nếu convertView chưa được tạo
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(idlayout, parent, false);
        }

        //lay 1 CaFe trong mang dua vao position
        CaFe myCaFe = listCaFe.get(position);
        // khai bao, anh xa id va set thuoc tinh len layout
        ImageView imgCaFe = convertView.findViewById(R.id.imgCaFe);
        imgCaFe.setImageResource(myCaFe.getImage());
        TextView txtCaFe = convertView.findViewById(R.id.txtCaFe);
        txtCaFe.setText(myCaFe.getName());
        return convertView;
    }
}
