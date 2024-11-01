package thi.tai64132083.thigiuaki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class subBai4 extends AppCompatActivity {
    ImageView subImg;
    TextView subName, subGia;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub_bai4);
        subImg = findViewById(R.id.img_sub);
        subName = findViewById(R.id.tv_name_sub);
        subGia = findViewById(R.id.tv_gia_sub);
        Intent myIntent = getIntent();
        subImg.setImageResource(myIntent.getIntExtra("img1",0));
        subName.setText(myIntent.getStringExtra("name1"));
        subGia.setText(myIntent.getStringExtra("gia1"));
    }
}