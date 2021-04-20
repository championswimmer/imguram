package com.scaler.imguram

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class ImguramApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader(ImageLoader.Builder(this@ImguramApp)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(this@ImguramApp))
                } else {
                    add(GifDecoder())
                }
            }
            .build())
    }
}
