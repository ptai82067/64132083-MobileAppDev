package th.phamphuoctai.quizgui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;
public class JavaThemes extends AppCompatActivity {
    Button btnNext;
    private TextView lblQuestion;
    private Button btnA, btnB, btnC, btnD;
    private int i = 0;
    private List<CauHoi> list = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java_themes);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cauHoiTracNghiem();
            }
        });
        // Ánh xạ các view
        lblQuestion = findViewById(R.id.lblQuestion);
        btnA =   findViewById(R.id.btnA);
        btnB =   findViewById(R.id.btnB);
        btnC =   findViewById(R.id.btnC);
        btnD =   findViewById(R.id.btnD);

        i = 0;
        list.add(new CauHoi("Trong Java, từ khóa nào được sử dụng để khai báo một lớp?", "class", "struct", "object", "function", "class"));
        list.add(new CauHoi("Trong Java, kiểu dữ liệu nào được dùng để lưu trữ số nguyên?", "float", "int", "double", "char", "int"));
        list.add(new CauHoi("Toán tử nào được sử dụng để truy cập thành viên của một lớp trong Java?", ".", "->", "::", "*", "."));
        list.add(new CauHoi("Hàm nào trong Java trả về số ký tự trong một chuỗi?", "length()", "size()", "strlen()", "sizeof()", "length()"));
        list.add(new CauHoi("Phương thức nào trong Java được gọi khi một đối tượng bị hủy?", "constructor", "finalizer", "destructor", "N/A", "N/A"));


        cauHoiTracNghiem();

        // Gắn sự kiện cho các button
        btnA.setOnClickListener(this::check);
        btnB.setOnClickListener(this::check);
        btnC.setOnClickListener(this::check);
        btnD.setOnClickListener(this::check);
    }

    public void check(View view) {
        Button clickedButton = (Button) view; // Lấy button được nhấn
        String answer = clickedButton.getText().toString(); // Đáp án từ button

        if (answer.equals(list.get(i).getPaDung())) {
            clickedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light)); // Màu xanh lá khi đúng
        } else {
            clickedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light)); // Màu đỏ khi sai
        }

        // Tắt các nút trong khi chờ câu hỏi tiếp theo
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);

        i++;

    }

    public void cauHoiTracNghiem() {
        if (i < list.size()) {
            // Hiển thị câu hỏi và các đáp án
            lblQuestion.setText(list.get(i).getLoiHoi());
            btnA.setText(list.get(i).getPa1());
            btnB.setText(list.get(i).getPa2());
            btnC.setText(list.get(i).getPa3());
            btnD.setText(list.get(i).getPa4());

            // Reset lại màu cho các button
            btnA.setBackgroundColor(getResources().getColor(android.R.color.white));
            btnB.setBackgroundColor(getResources().getColor(android.R.color.white));
            btnC.setBackgroundColor(getResources().getColor(android.R.color.white));
            btnD.setBackgroundColor(getResources().getColor(android.R.color.white));

            btnA.setEnabled(true);
            btnB.setEnabled(true);
            btnC.setEnabled(true);
            btnD.setEnabled(true);
        } else {
            Intent myIntent = new Intent(JavaThemes.this, Result.class);
            startActivity(myIntent);
        }


    }
}