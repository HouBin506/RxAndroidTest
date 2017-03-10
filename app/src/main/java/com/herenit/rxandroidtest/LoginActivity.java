package com.herenit.rxandroidtest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.herenit.rxandroidtest.utils.LoginUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private EditText userName,passWord;
    private Button login;

    private final String url = "";

    private LoginUtil loginUtil;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.userName);
        passWord = (EditText) findViewById(R.id.passWord);
        login = (Button) findViewById(R.id.login);
        loginUtil = new LoginUtil();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Login...");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                Map<String,String> params = new HashMap<String, String>();
                params.put("userName","houbin");
                params.put("passWord","1234");
                loginUtil.login(url,params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNext(String s) {
                        finish();
                    }
                });
            }
        });
    }
}
