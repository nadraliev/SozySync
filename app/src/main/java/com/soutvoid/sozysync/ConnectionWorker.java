package com.soutvoid.sozysync;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

/**
 * Created by soutvoid on 7/28/16.
 */
public abstract class ConnectionWorker {

    public Connection connection;

    public abstract void createConnection(Context context);
    //public abstract boolean openConnection();
    //public abstract boolean closeConnection();
    //public abstract List<String> getEntryList(String pathToDir);
    //public abstract String getAbsolutePath();
    //public abstract boolean changeDirectory(String pathToDir);
    //public abstract boolean downloadFile(String pathToFile, String destination);
    //public abstract boolean uploadFile(String pathToFile, String destination);
    //public abstract boolean downloadFiles(List<String> pathsToFiles, String destination);
    //public abstract boolean uploadFiles(List<String> pathsToFiles, String destination);
    //public abstract int compareFiles(String pathToFirstFile, String pathToSecondFile);

}
