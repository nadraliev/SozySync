package com.soutvoid.sozysync;

import android.content.Context;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

/**
 * Created by soutvoid on 7/28/16.
 */
public class ConnectionWorkerDropbox extends ConnectionWorker {

    final static private String APP_KEY = "i6g4d2gk607rdg5";
    final static private String APP_SECRET = "i6g4d2gk607rdg5";
    private DropboxAPI<AndroidAuthSession> mDBApi;
    public ConnectionDropbox connection = null;

    @Override
    public void createConnection(Context context) {
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);
        mDBApi.getSession().startOAuth2Authentication(context);

    }

    public void finishAuthorisation() {
        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();
                connection = new ConnectionDropbox();
                connection.token = accessToken;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}
