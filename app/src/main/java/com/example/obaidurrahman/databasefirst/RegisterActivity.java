package com.example.obaidurrahman.databasefirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
private EditText username;
private EditText password;
private EditText re_password;
private EditText email;
private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.inpuserid);
        password=findViewById(R.id.inppass);
        re_password=findViewById(R.id.inprepass);
        email=findViewById(R.id.inpmail);
        databaseHelper=new DatabaseHelper(getBaseContext());
    }

    public void registerClick(View view) {
        UserModel umodel=new UserModel(0,username.getText().toString(),email.getText().toString(),password.getText().toString());
       boolean res= databaseHelper.createUser(umodel);
       if(res==true)
       {
           Intent intent=new Intent(RegisterActivity.this,LogInActivity.class);
           startActivity(intent);
       }
    }
}
