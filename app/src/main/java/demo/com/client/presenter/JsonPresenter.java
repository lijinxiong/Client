package demo.com.client.presenter;

import android.app.Activity;
import android.support.annotation.Nullable;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import demo.com.client.model.Download;
import demo.com.client.ui.BlankView;

/**
 * Created by jinxiong on 2017/6/26.
 */

public class JsonPresenter {


    /**
     * @param url        请求的地址
     * @param listener   监听器
     * @param clazz      返回的json 对应的数据类
     * @param parameters 参数列表
     */
    public void getJsonObject(String url, final BlankView listener, Class clazz,
                              @Nullable Map<String, String> parameters) {

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

            @Override
            public void failed(final String error) {

                Activity activity = listener.getActivityWeakReference().get();
                if (activity == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.showError(error);
                    }
                });
            }
        };

        if (parameters != null && parameters.size() > 0) {
            url = addParameter(parameters, url);
        }

        listener.showDowning();
        Download.getJsonObject(url, iPresenter, clazz);

    }

    private String addParameter(Map<String, String> map, String url) {

        StringBuilder stringBuilder = new StringBuilder(url);
        if (!url.contains("?")) {
            stringBuilder.append("?");
        }

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
            stringBuilder.append(key + "=" + value + "&");
        }


        return stringBuilder.toString();

    }


}
















