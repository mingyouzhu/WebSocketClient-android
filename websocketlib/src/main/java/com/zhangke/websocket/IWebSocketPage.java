package com.zhangke.websocket;

public interface IWebSocketPage extends SocketListener {

    void onServiceBindSuccess();

    void sendText(String text);

    void reconnect();
}
