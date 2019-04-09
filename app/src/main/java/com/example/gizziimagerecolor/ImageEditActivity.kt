package com.example.gizziimagerecolor

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_image_edit.*

class ImageEditActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, uri: Uri?) : Intent{
            val intent = Intent(context, ImageEditActivity::class.java)
            intent.putExtra("uri", uri)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_edit)

        val uri = Uri(intent.getStringExtra("uri"))
        val bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
        image_result.setImageBitmap(bitmap)
    }
}
