package thi.tai64132083.thigiuaki.adapter;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thi.tai64132083.thigiuaki.Bai4;
import thi.tai64132083.thigiuaki.R;
import thi.tai64132083.thigiuaki.modle.SanPham;
import thi.tai64132083.thigiuaki.subBai4;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<SanPham> list;
    ClickLisenner lisenner;

    public MyRecycleAdapter(Context context, List<SanPham> list, ClickLisenner lisenner) {
        this.context = context;
        this.list = list;
        this.lisenner = lisenner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(list.get(position).getImg());
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_gia.setText(list.get(position).getGia());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    lisenner.click(list.get(position).getImg(),list.get(position).getName(),list.get(position).getGia());
                Intent myIntent = new Intent(view.getContext(), subBai4.class);
                myIntent.putExtra("img1",list.get(position).getImg());
                myIntent.putExtra("name1",list.get(position).getName());
                myIntent.putExtra("gia1",list.get(position).getGia());
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
