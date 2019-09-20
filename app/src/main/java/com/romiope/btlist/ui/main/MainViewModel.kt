package com.romiope.btlist.ui.main

import android.bluetooth.BluetoothAdapter
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val bluetoothAdapter by lazy { BluetoothAdapter.getDefaultAdapter() }

    fun getDevices() = bluetoothAdapter.bondedDevices
    fun isBTEnabled() = bluetoothAdapter.isEnabled
}
