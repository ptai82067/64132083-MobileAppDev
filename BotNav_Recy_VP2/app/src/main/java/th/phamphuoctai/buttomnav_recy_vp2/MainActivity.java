package th.phamphuoctai.buttomnav_recy_vp2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentCn1()).commit();
        }
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if(item.getItemId()==R.id.nav_home){
                selectedFragment = new FragmentCn1();
            } else if (item.getItemId()==R.id.nav_recy) {
                selectedFragment = new FragmentCn2();
            }else if (item.getItemId()==R.id.nav_vp2) {
                selectedFragment = new FragmentCn3();
            }else {
                selectedFragment = new FragmentCn4();

            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();
            }
            return true;
        });
    }
}