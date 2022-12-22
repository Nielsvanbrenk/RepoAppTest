package com.example.recycler_view_test

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recycler_view_test.MyAdapter
import com.example.recycler_view_test.R
import com.squareup.picasso.Picasso
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_INTERNET = 1
    private val REQUEST_CODE_EXTERNAL_STORAGE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.INTERNET)
        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.INTERNET),
                REQUEST_CODE_INTERNET
            )
        }
//
//        if (ContextCompat.checkSelfPermission(this,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE)
//        != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
//                REQUEST_CODE_EXTERNAL_STORAGE
//            )
//        }


//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val imageUrls = listOf(
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
//            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
//            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
//            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
//            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
//            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
//            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
//            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
//            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
//            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png"
        )

        val imageUri = "https://avatars.githubusercontent.com/u/15876397?v=4"
        println("test")
        val imageView2 = findViewById<ImageView>(R.id.imageView2)

        println("imageUri is $imageUri")
        Picasso.get().isLoggingEnabled = true
        Picasso.get().load(imageUri).into(imageView2);
        println("TEST: ${Picasso.get().load(imageUri).into(imageView2)}")

        val adapter = MyAdapter(imageUrls)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}