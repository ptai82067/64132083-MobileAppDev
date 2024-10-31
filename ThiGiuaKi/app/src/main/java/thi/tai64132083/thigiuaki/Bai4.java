package thi.tai64132083.thigiuaki;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import thi.tai64132083.thigiuaki.adapter.ClickLisenner;
import thi.tai64132083.thigiuaki.adapter.MyRecycleAdapter;
import thi.tai64132083.thigiuaki.modle.SanPham;

import java.util.ArrayList;
import java.util.List;

public class Bai4 extends AppCompatActivity {

    int[] imgs = {R.drawable.hinh1,R.drawable.hinh2,R.drawable.hinh3,R.drawable.hinh4,
            R.drawable.hinh5,R.drawable.hinh6,R.drawable.hinh7,R.drawable.hinh8};
    String[] names = {"Gậy tập tay", "Ấm đun siêu tốc", "Sửa rửa mặt", "Kem chống nắng",
            "Tất cho nam","Quần co dãn", "Tai nghe","Cháo dinh dưỡng"};
    String[] gias = {"100000","200000","50000","150000","400000","100000","120000","100000"};

    List<SanPham> list;
    RecyclerView recyclerView;
    MyRecycleAdapter myRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);

        list = new ArrayList<>();
        for (int i =0; i < imgs.length; i++){
            list.add(new SanPham(imgs[i],names[i],gias[i]));
        }
        recyclerView = (RecyclerView)findViewById(R.id.recyler);
        myRecycleAdapter = new MyRecycleAdapter(getApplication(),list,new ClickLisenner());
        recyclerView.setAdapter(myRecycleAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(Bai4.this,2));
    }
}