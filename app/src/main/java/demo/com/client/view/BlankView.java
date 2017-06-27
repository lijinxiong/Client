package demo.com.client.view;

import android.app.Activity;

import java.lang.ref.WeakReference;

import demo.com.client.interfaces.IView;


public class BlankView implements IView {

    private WeakReference<Activity> mActivityWeakReference;

    public WeakReference<Activity> getActivityWeakReference() {
        return mActivityWeakReference;
    }

    public BlankView(Activity activity) {
        mActivityWeakReference = new WeakReference<>(activity);
    }

    @Override
    public void showDowning() {

    }

    @Override
    public void showData(Object data) {

    }
}
