package th.phamphuoctai.basicgui_simplemath;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKetQua;
    Button btnKQ;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các view
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKetQua = findViewById(R.id.edtKetQua);
        radioGroup = findViewById(R.id.radioGroup);
        btnKQ = findViewById(R.id.btnKQ);

        // Gán sự kiện click cho nút Kết quả
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra đầu vào
                if (edtA.getText().toString().isEmpty() || edtB.getText().toString().isEmpty()) {
                    edtKetQua.setText("Please input both numbers!");
                    return;
                }

                // Kiểm tra phép toán đã được chọn hay chưa
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    edtKetQua.setText("Please select an operation!");
                    return;
                }

                // Đọc giá trị nhập vào
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                String kq = "";

                // Thực hiện phép toán
                // Thực hiện phép toán bằng if-else
                if (selectedId == R.id.radioOption1) { // Phép cộng
                    kq = String.valueOf(a + b);
                } else if (selectedId == R.id.radioOption2) { // Phép trừ
                    kq = String.valueOf(a - b);
                } else if (selectedId == R.id.radioOption3) { // Phép nhân
                    kq = String.valueOf(a * b);
                } else if (selectedId == R.id.radioOption4) { // Phép chia
                    kq = String.valueOf((float) a / b);
                }

                // Hiển thị kết quả
                edtKetQua.setText(kq);
            }
        });
    }
}
