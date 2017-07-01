package demo.com.client.ui;


public interface IView {

    /**
     * 加载数据的时候一些用户提示
     */
    void showDowning();

    /**
     * 加载完成的时候显示数据
     */

    void showData(Object data);

    //加载数据错误
    void showError(String error);

}
