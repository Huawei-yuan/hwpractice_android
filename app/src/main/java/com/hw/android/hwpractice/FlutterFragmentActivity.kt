package com.hw.android.hwpractice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.RenderMode

class FlutterFragmentActivity : FragmentActivity() {

    private var flutterFragment: FlutterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_fragment)

        val fragmentManager = supportFragmentManager

        flutterFragment =
            fragmentManager.findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?

        if (flutterFragment == null) {
            var newFlutterFragment: FlutterFragment = FlutterFragment
                .withCachedEngine(COMMON_FLUTTER_ENGINE_ID)
                .renderMode(RenderMode.texture)
                .build()
            flutterFragment = newFlutterFragment
            fragmentManager
                .beginTransaction()
                .add(
                    R.id.flutter_fragment_container,
                    newFlutterFragment,
                    TAG_FLUTTER_FRAGMENT
                ).commit()
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        flutterFragment?.onPostResume()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let {
            flutterFragment?.onNewIntent(it)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        flutterFragment?.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        flutterFragment?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        flutterFragment?.onUserLeaveHint()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment?.onTrimMemory(level)
    }

    companion object {
        private const val TAG_FLUTTER_FRAGMENT = "flutter_fragment"
    }

}