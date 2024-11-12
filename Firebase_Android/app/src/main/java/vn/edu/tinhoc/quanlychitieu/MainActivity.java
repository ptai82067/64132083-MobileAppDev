package vn.edu.tinhoc.quanlychitieu;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    private DatabaseReference mDatabase;
    ArrayList<String> list = new ArrayList<>();;
    ArrayAdapter<String> myAdapter;
    ListView lv;
    Button btnThem;
    EditText edtThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(myAdapter);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setList();
        changListen();


        btnThem = findViewById(R.id.btnThem);
        edtThem = findViewById(R.id.edtThem);


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                writeNewUser(String.valueOf(i),edtThem.getText().toString(),"");
                list.add(edtThem.getText().toString());
                myAdapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), list.get(i), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setList() {
        mDatabase.child("users").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
                else {
                    list.clear();
                    i = 0;
                    for (DataSnapshot snapshot : task.getResult().getChildren()) {
                        i++;
                        String userId = snapshot.getKey();
                        User userData =  snapshot.getValue(User.class);
                        if (userData != null && userData.username != null) {
                            list.add(userData.username.toString());

                        }
                    }
                    if (list.size() > 0) {
//                        Toast.makeText(MainActivity.this, "Số lượng user: " + list.size(), Toast.LENGTH_SHORT).show();
                        // Truy cập phần tử trong danh sách
                        String firstUser = list.get(0);
//                        Toast.makeText(MainActivity.this, "User đầu tiên: " + firstUser, Toast.LENGTH_SHORT).show();
                    } else {
//                        Toast.makeText(MainActivity.this, "Danh sách user rỗng", Toast.LENGTH_SHORT).show();
                    }
                    myAdapter.notifyDataSetChanged();

                }
            }
        });
    }


    public void writeNewUser(String userId, String name, String email) {
        User user = new User(name, email);

        mDatabase.child("users").child(userId).setValue(user);
    }
    public void updateUser(String userId, String name){
        mDatabase.child("users").child(userId).child("username").setValue(name);
    }

    public void changListen(){
        mDatabase.child("users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                setList();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String name = snapshot.getValue(User.class).username;
                String email = snapshot.getValue(User.class).email;
                setList();

//                if (list.size() > 0) {
//                    Toast.makeText(MainActivity.this, "Số lượng user: " + list.size(), Toast.LENGTH_SHORT).show();
//                    // Truy cập phần tử trong danh sách
//
//                    Toast.makeText(MainActivity.this, "User đầu tiên: " + firstUser, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Danh sách user rỗng", Toast.LENGTH_SHORT).show();
//                }
//                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                setList();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                setList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}