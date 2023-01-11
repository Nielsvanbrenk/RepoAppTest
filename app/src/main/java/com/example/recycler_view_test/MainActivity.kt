package com.example.recycler_view_test

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser.Companion.default
import com.github.kittinunf.fuel.httpGet
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL


class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {



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

//        var page = 0
//        val parser = default(  )

//        val thread = Thread {
//            try {
//
//                val (_, _, result) = "https://api.github.com/users/abnamrocoesd/repos?page=1&per_page=10".httpGet().responseString()
//                val data: JsonObject = parser.parse(result.toString()) as JsonObject
//
//                //Your code goes here
//                var totalPages = data.size/10
//                println(data)
//                println("TESTJE")
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//
//        thread.start()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        val imageUrls = listOf(
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png",
            "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png",
            "https://leanbetekenis.nl/wp-content/uploads/2016/02/Rabobank-logo.jpg",
            "https://scrumevent.nl/wp-content/uploads/ING_logo-lion-880x660.png"
        )

        val adapter = MyAdapter(imageUrls, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(position: Int, context: Context) {

        val repotitle = "testTitel"
        val ownername = "testName"
        val description = "testDescription"
        var public = "true"
        val imgUrl = "https://vanervenverzekeringen.nl/wp-content/uploads/2016/11/ABN-Amro-logo.png"

        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.POSITION, position.toString())
        intent.putExtra(DetailActivity.REPO_TITLE, repotitle)
        intent.putExtra(DetailActivity.OWNER_NAME, ownername)
        intent.putExtra(DetailActivity.DESCRIPTION, description)
        intent.putExtra(DetailActivity.VISIBILITY, position.toString())
        intent.putExtra(DetailActivity.PUBLIC, public)
        intent.putExtra(DetailActivity.IMG_URL, imgUrl)
        context.startActivity(intent)
    }

    var client: OkHttpClient = OkHttpClient();


    private fun getRequest(sUrl: String): String? {
        var result: String? = null
        try {
            // Create URL
            val url = URL(sUrl)
            // Build request
            val request = Request.Builder().url(url).build()
            // Execute request
            val response = client.newCall(request).execute()
            result = response.toString()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }

}

