package com.example.jzabar7531.lyricist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    EditText usernameRegTxt, passwordRegTxt;
    Button submitRegBtn;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Register");

        final EditText usernameRegTxt = (EditText) findViewById(R.id.usernameRegTxt);
        final EditText passwordRegTxt = (EditText) findViewById(R.id.passwordRegTxt);
        final Button submitRegBtn = (Button) findViewById(R.id.submitRegBtn);

        submitRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = usernameRegTxt.getText().toString();
                String password = passwordRegTxt.getText().toString();

                if(userName.equals("")|| password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Field Vaccant",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
//                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(),
                            "Account Created", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(RegisterActivity.this,
                            MainActivity.class);
                    startActivity(i);
//                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy()
    {
       super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
