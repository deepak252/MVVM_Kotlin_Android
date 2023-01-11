package com.academy.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver

class MainActivity : AppCompatActivity(), LifecycleObserver{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Observer().registerLifecycle(lifecycle);

        Log.d("MAIN", "MainActivity, onCreate")

    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN", "MainActivity, onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN", "MainActivity, onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN", "MainActivity, onDestroy")
    }


}