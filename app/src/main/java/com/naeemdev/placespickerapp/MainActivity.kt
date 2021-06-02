package com.naeemdev.placespickerapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.naeemdev.placeslib.AddressDataClass
import com.naeemdev.placeslib.Constants
import com.naeemdev.placeslib.MapType
import com.naeemdev.placeslib.PlacePickerClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init ()

    }
    fun init () {
        val intent = PlacePickerClass.IntentBuilder()
            .setLatLong(25.276987, -55.296249)
            .showLatLong(true)
            .setMapZoom(15.0f)
            .setAddressRequired(true)
            .setMapRawResourceStyle(R.raw.map_style)
            .setMapType(MapType.NORMAL)
            .setPlaceSearchBar(true, "Your key here")
            .build(this)
          registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            onActivityResult(Constants.PLACE_PICKER_REQUEST, result)
        }.launch(intent)

    }

  private fun onActivityResult(requestCode: Int, result: ActivityResult) {

      if (requestCode == Constants.PLACE_PICKER_REQUEST) {
          if (result.resultCode == Activity.RESULT_OK) {
              val intent = result.data
              try {
                  val addressData = intent?.getParcelableExtra<AddressDataClass>(Constants.ADDRESS_INTENT)

                  findViewById<TextView>(R.id.tv_address).text = addressData.toString()
              } catch (e: Exception) {
                  e.message?.let { Log.e("MainActivity", it) }
              }
          }
      }

}

}