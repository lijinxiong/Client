package demo.com.client.model;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import demo.com.client.app.App;
import demo.com.client.interfaces.IPresenter;


public class Download {

    public static void getJsonObject(final String url, final IPresenter presenter, final Class clazz) {

        App.getExecutor().execute(new Runnable() {
            @Override
            public void run() {
                StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();
                        Object o = gson.fromJson(response, clazz);
                        presenter.complete(o);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                App.getQueue().add(request);
            }
        });

    }

}


