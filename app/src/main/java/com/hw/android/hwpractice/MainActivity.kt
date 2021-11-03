package com.hw.android.hwpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.start_flutter_activity_btn).setOnClickListener {
            startActivity(
                FlutterActivity.withCachedEngine(COMMON_FLUTTER_ENGINE_ID)
//                .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                .build(this))
        }
    }
}