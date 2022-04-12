package com.example.tuan8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText edtuser,edtaddress;
    private Button btnadd;
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;
    private List<User> listuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intUI();
        userAdapter=new UserAdapter();
        listuser=new ArrayList<>();
        userAdapter.setData(listuser);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setAdapter(userAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    private void addUser() {
        String muser=edtuser.getText().toString().trim();
        String address=edtaddress.getText().toString().trim();
        User user=new User(muser,address);
        UserDataBase.getInstance(this).userDao().insertAll(user);
        Toast.makeText(this, "Them Thanh Cong", Toast.LENGTH_SHORT).show();
        edtuser.setText("");
        edtaddress.setText("");

        listuser=UserDataBase.getInstance(this).userDao().getAll();
        userAdapter.setData(listuser);

    }

    private void intUI(){
        edtuser=(EditText) findViewById(R.id.edtuser);
        edtaddress=(EditText) findViewById(R.id.edtaddress);
        btnadd=(Button) findViewById(R.id.btnadd);
        rcvUser=(RecyclerView) findViewById(R.id.rcvuser);
    }
}