package com.room.ps.lifecycleawaredemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainActivityViewModel: ViewModel() {

	private lateinit var myRandomNumber: MutableLiveData<String>

	fun getNumber(): MutableLiveData<String> {

		Log.i(TAG, "Get number")

		if (!::myRandomNumber.isInitialized) {
			myRandomNumber = MutableLiveData()
			this.createNumber()
		}
		return myRandomNumber
	}

	fun createNumber() {
		Log.i(TAG, "Create new number")
		val random = Random()
		myRandomNumber.value = "Number: " + (random.nextInt(10 - 1) + 1)
	}

	companion object {
		private val TAG = MainActivityViewModel::class.simpleName
	}
}