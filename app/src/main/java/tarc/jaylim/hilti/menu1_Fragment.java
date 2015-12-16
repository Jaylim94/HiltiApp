package tarc.jaylim.hilti;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Z0NEN on 10/22/2014.
 */
public class menu1_Fragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainView = (View) inflater.inflate(R.layout.menu1_layout, container, false);
        WebView webView = (WebView) mainView.findViewById(R.id.webView);
        webView.loadUrl("https://www.hilti.com/Company/media-relations/media");

        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

        return mainView;
    }

}
