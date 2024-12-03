package th.phamphuoctai.chuyenmanhinh_fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class TA_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ta);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Fragment_ta_1 fragment_ta_1 = new Fragment_ta_1();
        Fragment_ta_2 fragment_ta_2 = new Fragment_ta_2();
        Fragment_ta_3 fragment_ta_3 = new Fragment_ta_3();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_ta_1,fragment_ta_1);
        transaction.replace(R.id.fragment_ta_2,fragment_ta_2);
        transaction.replace(R.id.fragment_ta_3,fragment_ta_3);
        transaction.commit();
    }
}