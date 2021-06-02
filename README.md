# placespicker_lib

Add it in your root build.gradle at the end of repositories:

      allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }
Step 2. Add the dependency


      dependencies {
              implementation 'com.github.naeemdev:placespicker_lib:1.0.0'
      }

## How to use
You need a Maps and Place API key and add it to your app.
For google map styling visit https://mapstyle.withgoogle.com/

Code For Kotlin

                val intent = PlacePickerClass.IntentBuilder()
                .setLatLong(25.276987, -55.296249)  // Initial Latitude and Longitude the Map will load into
                .showLatLong(true)  // Show Coordinates in the Activity
                .setMapZoom(12.0f)  // Map Zoom Level. Default: 16.0
                .setAddressRequired(true) // Set If return only Coordinates if cannot fetch Address for the coordinates. Default: True
                .hideMarkerShadow(true) // Hides the shadow under the map marker. Default: False
                .setMarkerDrawable(R.drawable.marker) // Change the default Marker Image
                .setMarkerImageImageColor(R.color.colorPrimary)
                .setFabColor(R.color.fabColor)
                .setPrimaryTextColor(R.color.primaryTextColor) // Change text color of Shortened Address
                .setSecondaryTextColor(R.color.secondaryTextColor) // Change text color of full Address
                .setBottomViewColor(R.color.bottomViewColor) // Change Address View Background Color (Default: White)
                .setMapRawResourceStyle(R.raw.map_style)  //Set Map Style (https://mapstyle.withgoogle.com/)
                .setMapType(MapType.NORMAL)
                .setPlaceSearchBar(true, GOOGLE_API_KEY) //Activate GooglePlace Search Bar. Default is false/not activated. SearchBar is a chargeable feature by Google
                .onlyCoordinates(true)  //Get only Coordinates from Place Picker
                .hideLocationButton(true)   //Hide Location Button (Default: false)
                .disableMarkerAnimation(true)   //Disable Marker Animation (Default: false)
                .build(this)
            startActivityForResult(intent, Constants.PLACE_PICKER_REQUEST)
            
 final Step  get the data `onActivityResult`

          override fun onActivityResult(requestCode: Int,resultCode: Int,data: Intent?) {
                  if (requestCode == Constants.PLACE_PICKER_REQUEST) {
                      if (resultCode == Activity.RESULT_OK) {
                      val addressData = data?.getParcelableExtra<AddressDataClass>(Constants.ADDRESS_INTENT)
                      }
                  } else {
                      super.onActivityResult(requestCode, resultCode, data)
                  }
              }
 
 Code For Java       
 

          Intent intent_drop = new PlacePickerClass.IntentBuilder()
                .setLatLong(Double.parseDouble(appSession.getLatitude()),
                        Double.parseDouble(appSession.getLongitude()))  // Initial Latitude and Longitude the Map will load into
                .showLatLong(true)  // Show Coordinates in the Activity
                .setMapZoom(15.0f)  // Map Zoom Level. Default: 14.0
                .setAddressRequired(true) // Set If return only Coordinates if cannot fetch Address for the coordinates. Default: True
                .hideMarkerShadow(true) // Hides the shadow under the map markerDepart. Default: False
                .setMarkerDrawable(R.drawable.ic_map_marker) // Change the default Marker Image
                .setMarkerImageImageColor(R.color.blue)
                .setFabColor(R.color.blue)
                .setPrimaryTextColor(R.color.black_color) // Change text color of Shortened Address
                .setSecondaryTextColor(R.color.black_color) // Change text color of full Address
                .setMapRawResourceStyle(R.raw.map_style)  //Set Map Style
                .setMapType(MapType.NORMAL)
                .setPlaceSearchBar(true,"Your API Key here")
                .onlyCoordinates(true)  //Get only Coordinates from Place Picker
                .hideLocationButton(false)   //Hide Location Button (Default: false)
                .disableMarkerAnimation(false)

                .build(getActivity());
                startActivityForResult(intent_drop, Constants.PLACE_PICKER_REQUEST);

            
            
   final Step  get the data `onActivityResult`
   
                 @Override
                  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
                      if (requestCode == Constants.PLACE_PICKER_REQUEST) {
                          if (resultCode == Activity.RESULT_OK && data != null) {
                            AddressDataClass addressData = data.getParcelableExtra(Constants.ADDRESS_INTENT);
                          }
                      } else {
                          super.onActivityResult(requestCode, resultCode, data);
                      }
                  }
