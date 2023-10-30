package ml.ahmedsgk.nexthr

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.*


class MainActivity : AppCompatActivity() {
    private var myWebView: WebView? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayUseLogoEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.amg_icon)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        myWebView = findViewById(R.id.webView)
        val webSettings = myWebView!!.settings
        webSettings.javaScriptEnabled = true
        myWebView!!.loadUrl("http://41.33.127.83")
        myWebView!!.webViewClient = WebViewClient()


    }

    override fun onBackPressed() {
        if (myWebView!!.canGoBack()) {
            myWebView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.share -> {
                var sharingIntent  =  Intent(Intent.ACTION_SEND)
                sharingIntent.setType("text/plain")

                var shareSubject :String = " حمل تطبيق الموارد البشريه  : "
                var shareBody :String = "https://apkfab.com/amghr/ml.ahmedsgk.nexthr/apk"
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject)
                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody)
                startActivity(Intent.createChooser(sharingIntent,"شارك التطبيق مع زملائك"))

            }
        }
        return super.onOptionsItemSelected(item)
    }


}