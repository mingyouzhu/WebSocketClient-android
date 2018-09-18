package com.zhangke.websocketdemo;

import android.app.Application;
import android.content.Intent;
import android.webkit.WebSettings;

import com.zhangke.websocket.WebSocketService;
import com.zhangke.websocket.WebSocketSetting;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        WebSocketSetting.setPreCmd("login onlly");
        WebSocketSetting.setConnectUrl("ws://192.168.0.103:1106/chat");
        WebSocketSetting.setReconnectWithNetworkChanged(true);
        startService(new Intent(this, WebSocketService.class));

    }
}