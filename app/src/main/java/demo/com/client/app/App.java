package demo.com.client.app;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by jinxiong on 2017/6/26.
 */

public class App extends Application {

    private static RequestQueue queue;
    private static App app;
    private static Executor executor;

    public static Executor getExecutor() {
        return executor;
    }

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        app = this;
        queue = Volley.newRequestQueue(this);
        executor = Executors.newSingleThreadExecutor();
    }

    public static RequestQueue getQueue() {
        return queue;
    }
}
