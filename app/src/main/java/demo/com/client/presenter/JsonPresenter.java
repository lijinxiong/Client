package demo.com.client.presenter;

import android.app.Activity;

import demo.com.client.interfaces.IPresenter;
import demo.com.client.model.Download;
import demo.com.client.view.BlankView;

/**
 * Created by jinxiong on 2017/6/26.
 */

public class JsonPresenter {

    public void getJsonObject(String url, final BlankView listener, Class clazz) {


        IPresenter iPresenter = new IPresenter() {
            @Override
            public void complete(final Object o) {

                Activity activity = listener.getActivityWeakReference().get();
                if (activity == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.showData(o);
                    }
                });

            }
        };

        listener.showDowning();
        Download.getJsonObject(url, iPresenter, clazz);


    }

}
