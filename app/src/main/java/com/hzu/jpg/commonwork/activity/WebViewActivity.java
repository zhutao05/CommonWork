package com.hzu.jpg.commonwork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hzu.jpg.commonwork.R;
import com.hzu.jpg.commonwork.utils.StringUtils;
import com.hzu.jpg.commonwork.utils.ToastUtil;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        String url = getIntent().getStringExtra("url");
        if (!StringUtils.isEmpty(url)) {
            WebView webView = (WebView) findViewById(R.id.web_view);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
        }else{
            ToastUtil.showToast("地址有错，无法获取文章");
        }
    }
}
