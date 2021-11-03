package com.hw.android.hwpractice

import android.app.Application
import android.util.Log
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class HwPracticeApplication : Application() {

    lateinit var flutterEngine: FlutterEngine

    override fun onCreate() {
        super.onCreate()
        initFlutterEngine()
    }

    private fun initFlutterEngine() {
        Log.i(TAG, "initFlutterEngine")
        // Instantiate a FlutterEngine.
        flutterEngine = FlutterEngine(this)

        // Configure an initial route.
        flutterEngine.navigationChannel.setInitialRoute("com/hw/flutter/custom_init_route")

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache.getInstance().put(COMMON_FLUTTER_ENGINE_ID, flutterEngine)

    }

    companion object {
        val TAG = "HwPracticeApplication"
    }
}