package com.smart.melo.webviewdemo;

/**
 * Created by melo on 2017/6/15.
 */
public class WebViewActivity extends BaseWebViewActivity {


    @Override
    protected void initData() {
        String url = "https://www.baidu.com/";
        loadUrl(url);
    }

    @Override
    protected void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }


}
