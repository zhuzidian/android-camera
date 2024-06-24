package com.zhu.android_camera

import android.content.Context
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zhu.android_camera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = this::class.java.simpleName
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var usbManager: UsbManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usbManager = getSystemService(Context.USB_SERVICE) as UsbManager
        Log.d(TAG, "usbManager.deviceList: ${usbManager.deviceList.size}")
        for ((_, usbDevice) in usbManager.deviceList) {
            Log.d(TAG, "${usbDevice.productName}")
            Log.d(TAG, "$usbDevice")
        }
    }
}