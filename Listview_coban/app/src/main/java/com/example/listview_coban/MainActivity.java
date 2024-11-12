package com.example.listview_coban;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<String> list;
ArrayAdapter<String> myAdapter;
ListView lv;
Button btnThem;
EditText edtThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        list = new ArrayList<>();
        list.add("Cà phê muối");
        list.add("Cà phê phân chuồn");
        list.add("Bạc xỉu");
        list.add("Cà phê đen");
        list.add("Cà phê sữa");
        list.add("Đậu phộng rang");
        lv = findViewById(R.id.lv);
        btnThem = findViewById(R.id.btnThem);
        edtThem = findViewById(R.id.edtThem);
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(myAdapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenBaiHat = edtThem.getText().toString();
                list.add(tenBaiHat);
                myAdapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

}