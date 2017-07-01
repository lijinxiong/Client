package demo.com.client.ui;

import android.app.Activity;

import java.lang.ref.WeakReference;


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

    @Override
    public void showError(String error) {

    }
}
