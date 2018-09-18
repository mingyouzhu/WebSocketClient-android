package com.zhangke.websocket;

public interface IResponseDispatcher {

    void onConnected(ResponseDelivery delivery);

    void onConnectError(Throwable cause, ResponseDelivery delivery);

    void onDisconnected(ResponseDelivery delivery);

    void onMessageResponse(Response message, ResponseDelivery delivery);

    void onSendMessageError(ErrorResponse error, ResponseDelivery delivery);
}