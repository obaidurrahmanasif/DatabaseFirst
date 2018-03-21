package com.example.obaidurrahman.databasefirst;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
private EditText userid;
private EditText password;
private DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userid=findViewById(R.id.loginid);
        password=findViewById(R.id.loginpass);
        helper=new DatabaseHelper(getBaseContext());

    }

    public void loginClick(View view) {
        String username=userid.getText().toString();
        String pass=password.getText().toString();
        boolean res=helper.islogin(new UserModel(0,username,null,pass));
        if(res==true)
        {
            Intent intent=new Intent(LogInActivity.this,LoginNavActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getBaseContext(),"Login Failed!!",Toast.LENGTH_SHORT).show();
        }
    }

    public void goRegister(View view) {
        Intent intent=new Intent(LogInActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
