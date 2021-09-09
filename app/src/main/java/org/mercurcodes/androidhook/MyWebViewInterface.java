package org.mercurcodes.androidhook;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class MyWebViewInterface {
    MainActivity mContext;

    MyWebViewInterface(MainActivity c) {
        mContext = c;
    }

    @JavascriptInterface
    public void someMessageHandler(final String newMessage) {
        mContext.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mContext.changeMessage(newMessage);
            }
        });
    }

}
