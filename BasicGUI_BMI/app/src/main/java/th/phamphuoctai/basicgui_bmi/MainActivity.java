package th.phamphuoctai.basicgui_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtChieuCao, edtCanNang;
    TextView edtKetQua;
    Button btnKetQua;
    private RadioGroup radioGroup;
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
        edtChieuCao = findViewById(R.id.edtChieuCao);
        edtCanNang = findViewById(R.id.edtCanNang);
        edtKetQua = findViewById(R.id.edtKetQua);
        radioGroup = findViewById(R.id.radioGroup);
        btnKetQua = findViewById(R.id.btnKQ);

        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtChieuCao.getText().toString().isEmpty() || edtCanNang.getText().toString().isEmpty()) {
                    edtKetQua.setText("Vui lòng điền đầy đủ thông tin!");
                    return;
                }
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    edtKetQua.setText("Vui chọn khu vục");
                    return;
                }
                float chieuCao = Float.parseFloat(edtChieuCao.getText().toString());
                float canNang = Float.parseFloat(edtCanNang.getText().toString());
                String kq = "";
                if(selectedId == R.id.radioOption1){
                    if(!(1.0f < chieuCao && chieuCao < 2.2f)){
                        edtKetQua.setText("Chiều cao không hợp lý!!! Mời nhập lại....");
                        edtChieuCao.setText("");
                    } else if (!(2f < canNang && canNang < 200f)) {
                        edtKetQua.setText("Cân nặng không hợp lý !!! vui lòng nhập lại...");
                    }else{
                        float bMI = canNang / (chieuCao * chieuCao);
                        if (bMI < 17.50f) {
                            edtKetQua.setText("Gầy");
                        } else if (bMI >= 17.50f && bMI < 22.99f) {
                            edtKetQua.setText("Bình thường");
                        } else if (bMI >= 23.00f && bMI <= 27.99f) {
                            edtKetQua.setText("Thừa cân");
                        } else {
                            edtKetQua.setText("Béo phì");
                        }
                    }

                }else if(selectedId == R.id.radioOption2) {
                    if(!(1.0f < chieuCao && chieuCao < 2.2f)){
                        edtKetQua.setText("Chiều cao không hợp lý!!! Mời nhập lại....");
                        edtChieuCao.setText("");
                    } else if (!(2f < canNang && canNang < 200f)) {
                        edtKetQua.setText("Cân nặng không hợp lý !!! vui lòng nhập lại...");
                    }else{
                        float bMI = canNang / (chieuCao * chieuCao);
                        if (bMI < 18.50f) {
                            edtKetQua.setText("Gầy");
                        } else if (bMI >= 18.50f && bMI < 24.99f) {
                            edtKetQua.setText("Bình thường");
                        } else if (bMI >= 25.00f && bMI <= 29.99f) {
                            edtKetQua.setText("Thừa cân");
                        } else {
                            edtKetQua.setText("Béo phì");
                        }
                    }
                }

            }
        });

    }
}