package com.zhangke.websocket;

public interface SocketListener {

    void onConnected();

    void onConnectError(Throwable cause);

    void onDisconnected();

    void onMessageResponse(Response message);

    void onSendMessageError(ErrorResponse error);
}
