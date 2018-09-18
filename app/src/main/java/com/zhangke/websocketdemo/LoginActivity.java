package com.zhangke.websocketdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.zhangke.websocket.ErrorResponse;
import com.zhangke.websocket.IWebSocketPage;
import com.zhangke.websocket.Response;
import com.zhangke.websocket.WebSocketServiceConnectManager;

public class LoginActivity extends AppCompatActivity{

    WebSocketServiceConnectManager manager;

    private EditText etAccount;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        manager = new WebSocketServiceConnectManager(this, mPage);
        manager.onCreate();


        etAccount = findViewById(R.id.et_account);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = etAccount.getText().toString();
                if(TextUtils.isEmpty(account)){
                    UiUtil.showToast(LoginActivity.this, "输入不能为空");
                    return;
                }
                mPage.sendText(account);
            }
        });
    }

    IWebSocketPage mPage = new IWebSocketPage() {
        @Override
        public void onServiceBindSuccess() {

        }

        @Override
        public void sendText(String text) {
            manager.sendText(text);
        }

        @Override
        public void reconnect() {
            manager.reconnect();
        }

        @Override
        public void onConnected() {
            UiUtil.showToast(LoginActivity.this,"连接成功!");
        }

        @Override
        public void onConnectError(Throwable cause) {
            UiUtil.showToast(LoginActivity.this,cause.getMessage());
        }

        @Override
        public void onDisconnected() {
            UiUtil.showToast(LoginActivity.this,"已断开连接!");
        }

        @Override
        public void onMessageResponse(Response message) {
            UiUtil.showToast(LoginActivity.this, message.getResponseText());
        }

        @Override
        public void onSendMessageError(ErrorResponse error) {
            UiUtil.showToast(LoginActivity.this, error.getDescription());
        }
    };

    @Override
    protected void onDestroy() {
        manager.onDestroy();
        super.onDestroy();
    }
}
