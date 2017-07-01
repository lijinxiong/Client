package demo.com.client.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import demo.com.client.R;
import demo.com.client.presenter.JsonPresenter;
import demo.com.client.test.LoginReturnData;
import demo.com.client.ui.BlankView;

public class MainActivity extends AppCompatActivity {

    String url = "http://10.0.3.2:8080/ManagerLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", "12345678");
        parameter.put("password", "12345678");

        new JsonPresenter().getJsonObject(url, new BlankView(this) {

            //成功获得后台返回的数据
            /**
             * 已经是在UI线程中执行
             * @param data json 对应的数据类
             */
            @Override
            public void showData(Object data) {
                Toast.makeText(MainActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                LoginReturnData loginData = (LoginReturnData) data;
                Log.d("Color", loginData.getStatus());
            }

            //加载过程的动画或者提示
            //UI线程·
            @Override
            public void showDowning() {
                Toast.makeText(MainActivity.this, "正在下载喔....", Toast.LENGTH_SHORT).show();
            }

            //出错，不能得到后台的数据类
            //已经在UI线程中执行
            @Override
            public void showError(String error) {
                Toast.makeText(MainActivity.this, "不能获取到后台的数据", Toast.LENGTH_SHORT).show();
            }
        }, LoginReturnData.class, parameter);
    }
}
