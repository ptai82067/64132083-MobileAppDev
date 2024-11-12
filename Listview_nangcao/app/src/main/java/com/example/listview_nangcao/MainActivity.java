package com.example.listview_nangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//khai bao bien
    int listImage[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,
        R.drawable.img4, R.drawable.img5, R.drawable.img6};
    String listName[]={"CaFe nguyên chất", "CaFe tây nguyên",
        "CaFe phân chuồn", "CaFe đen",
        "CaFe sữa", "Bạc sỉu"};
    ArrayList<CaFe> listCaFe;
    ListView lv;
    MyAdapter myAdapter;
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
        //anh xa id
        lv = findViewById(R.id.lv);
        //gop 2 mang vao array list
        listCaFe = new ArrayList<>();
        for(int i = 0; i<listName.length; i++){
            listCaFe.add(new CaFe(listImage[i],listName[i]));
        }
        //khai bao adapter
        myAdapter = new MyAdapter(MainActivity.this, R.layout.idlayout, listCaFe);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(MainActivity.this, SubActivity.class);
                myIntent.putExtra("name",listCaFe.get(i).getName());
                myIntent.putExtra("image",listCaFe.get(i).getImage());
                startActivity(myIntent);
            }
        });
    }
}