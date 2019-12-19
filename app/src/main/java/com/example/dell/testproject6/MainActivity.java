package com.example.dell.testproject6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText login_username_text;
    private EditText login_password_text;
    private Button loginButton;
    private Button login_layout_regist;

    private EditText register_username_text;
    private EditText register_phone_text;
    private EditText register_password_text;
    private Button registButton;

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login_username_text = (EditText)findViewById(R.id.login_username_text);
        login_password_text = (EditText)findViewById(R.id.login_password_text);
        loginButton = (Button)findViewById(R.id.loginButton);
        login_layout_regist = (Button)findViewById(R.id.login_layout_regist);

        loginButton.setOnClickListener(this);
        login_layout_regist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                String loginName = login_username_text.getText().toString();
                String loginPsd = login_password_text.getText().toString();
                Log.d("MainActivity",loginName+";"+loginPsd);
                dbHelper = new MyDatabaseHelper(this,"User.db",null,2);
                SQLiteDatabase db1 =  dbHelper.getWritableDatabase();//更新数据库
                Log.d("MainActivity","更新数据库");
                Cursor user = db1.query("User",null,null,null,null,null,null);
                Log.d("MainActivity","user1");
                int flag = 0;
                if(user.moveToFirst()){
                    do{
                        String name = user.getString(user.getColumnIndex("username"));
                        String password = user.getString(user.getColumnIndex("password"));
                        Log.d("MainActivity","数据库中查出："+name+","+password);
                        if(name.equals(loginName) && password.equals(loginPsd)){
                            Intent intent = new Intent(MainActivity.this,IndexActivity.class);
                            startActivity(intent);
                            finish();
                            flag = 1;
                            break;
                        }
                    }while (user.moveToNext());
                }
                if(flag == 0){
                    Toast.makeText(MainActivity.this,"用户或密码输入错误",Toast.LENGTH_SHORT).show();
                }
                user.close();
                Log.d("MainActivity",loginName+";"+loginPsd);
                break;
            case R.id.login_layout_regist:
                setContentView(R.layout.regist_layout);
                register_username_text = (EditText)findViewById(R.id.register_username_text);
                register_password_text = (EditText)findViewById(R.id.register_password_text);
                register_phone_text = (EditText)findViewById(R.id.register_phone_text);
                Button registButton = (Button)findViewById(R.id.registButton);
                dbHelper = new MyDatabaseHelper(this,"User.db",null,2);
                registButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SQLiteDatabase db =  dbHelper.getWritableDatabase();//创建数据库
                        Log.d("MainActivity","创建数据库成功");
                        String registerName = register_username_text.getText().toString();
                        String registerPsd = register_password_text.getText().toString();
                        String registerPhone = register_phone_text.getText().toString();
                        ContentValues valuesUser = new ContentValues();
                        valuesUser.put("username",registerName);
                        valuesUser.put("password",registerPsd);
                        valuesUser.put("phone",registerPhone);
                        db.insert("User",null,valuesUser);
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                        Log.d("MainActivity",registerName+"=="+registerPsd+"=="+registerPhone);
                    }
                });
                break;
        }
    }
}
