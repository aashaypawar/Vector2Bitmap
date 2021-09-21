package org.geeksforgeeks.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mImageViewBefore = findViewById<ImageView>(R.id.image_view_1)
        val mImageViewAfter = findViewById<ImageView>(R.id.image_view_2)
        val mButton = findViewById<Button>(R.id.button_1)

        mImageViewBefore.setImageResource(R.drawable.sample_vector)

        mButton.setOnClickListener {
            val mBitmap = getBitmapFromVectorDrawable(this, R.drawable.sample_vector)
            mImageViewAfter.setImageBitmap(mBitmap)
        }
    }

    private fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
        val drawable = ContextCompat.getDrawable(context, drawableId)
        val bitmap = Bitmap.createBitmap(
            drawable!!.intrinsicWidth,
            drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }
}