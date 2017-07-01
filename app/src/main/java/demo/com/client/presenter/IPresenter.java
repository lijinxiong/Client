package demo.com.client.presenter;

/**
 * Created by jinxiong on 2017/6/26.
 */

public interface IPresenter {

    void complete(Object o);

    void failed(String error);
}
