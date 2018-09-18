package com.zhangke.websocket;

public class WebSocketSetting {

    private static String connectUrl;
    private static IResponseDispatcher responseProcessDelivery;
    private static boolean reconnectWithNetworkChanged;
    private static String beforeMessageOfTheReconnect;

    public static String getConnectUrl() {
        return connectUrl;
    }

    public static void setConnectUrl(String connectUrl) {
        WebSocketSetting.connectUrl = connectUrl;
    }

    public static String getPreCmd(){return beforeMessageOfTheReconnect;}

    public static void setPreCmd(String token){
        beforeMessageOfTheReconnect = token;
    }

    public static IResponseDispatcher getResponseProcessDelivery() {
        if (responseProcessDelivery == null) {
            responseProcessDelivery = new DefaultResponseDispatcher();
        }
        return responseProcessDelivery;
    }

    public static void setResponseProcessDelivery(IResponseDispatcher responseProcessDelivery) {
        WebSocketSetting.responseProcessDelivery = responseProcessDelivery;
    }

    public static boolean isReconnectWithNetworkChanged() {
        return reconnectWithNetworkChanged;
    }

    public static void setReconnectWithNetworkChanged(boolean reconnectWithNetworkChanged) {
        WebSocketSetting.reconnectWithNetworkChanged = reconnectWithNetworkChanged;
    }
}
