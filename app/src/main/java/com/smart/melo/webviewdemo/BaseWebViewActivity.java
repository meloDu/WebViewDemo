package com.smart.melo.webviewdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * Created by duyanfeng on 2017/6/15.
 */
public abstract class BaseWebViewActivity extends AppCompatActivity {
    private ProgressWebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        webview = (ProgressWebView) findViewById(R.id.webview);

        initView();
        initData();

    }


    protected abstract void initData();

    protected abstract void initView();

    public abstract int getLayoutId();

    public void loadUrl(String url) {
        webview.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack();// 返回前一个页面
            return true;
        }else {
            new AlertDialog.Builder(this).setMessage("确定退出？").setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();
        }


        return super.onKeyDown(keyCode, event);
    }

}
