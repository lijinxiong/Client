package demo.com.client.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.toolbox.JsonObjectRequest;

import demo.com.client.R;
import demo.com.client.presenter.JsonPresenter;
import demo.com.client.test.Data;
import demo.com.client.view.BlankView;

public class MainActivity extends AppCompatActivity {

    String url = "http://hometown.scau.edu.cn/course/index.php?s=/Api&course=105";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonPresenter().getJsonObject(url, new BlankView(this) {
            @Override
            public void showData(Object data) {
                Log.d("Color", ((Data) data).getStatus());
            }
        }, Data.class);
    }
}
