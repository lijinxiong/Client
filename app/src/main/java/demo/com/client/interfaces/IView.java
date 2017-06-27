package demo.com.client.interfaces;

/**
 * Created by jinxiong on 2017/6/26.
 */

public interface IView {

    /**
     * 加载数据的时候一些用户提示
     */
    void showDowning();

    /**
     * 加载完成的时候显示数据
     */

    void showData(Object data);


}
