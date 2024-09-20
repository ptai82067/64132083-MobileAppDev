package thi.tai64132083.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    }
    public void sayHello(View v){
        EditText edtA = findViewById(R.id.edtA);
        EditText edtB = findViewById(R.id.edtB);
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        Toast.makeText(this, "Kết quả là:" + (a+b), Toast.LENGTH_SHORT).show();
    }
}