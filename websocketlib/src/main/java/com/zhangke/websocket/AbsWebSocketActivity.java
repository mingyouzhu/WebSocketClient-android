package com.zhangke.websocket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class AbsWebSocketActivity extends AppCompatActivity implements IWebSocketPage {

    WebSocketServiceConnectManager mConnectManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void sendText(String text) {
        mConnectManager.sendText(text);
    }

    @Override
    public void reconnect() {
        mConnectManager.reconnect();
    }

    @Override
    public void onServiceBindSuccess() {

    }

    @Override
    public void onConnected() {

    }

    @Override
    public void onConnectError(Throwable cause) {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    protected void onDestroy() {
        mConnectManager.onDestroy();
        super.onDestroy();
    }
}