package com.example.recycler_view_test

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    companion object{
        const val POSITION = "0"
        const val REPO_TITLE = "repoTitle"
        const val OWNER_NAME = "ownerName"
        const val DESCRIPTION = "description"
        const val PUBLIC = "true"
        const val IMG_URL = "link"
        const val VISIBILITY = "private"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val letterId = intent?.extras?.getString(POSITION).toString()
        val repoTitle = intent?.extras?.getString(REPO_TITLE).toString()
        val ownerName = intent?.extras?.getString(OWNER_NAME).toString()
        val description = intent?.extras?.getString(DESCRIPTION).toString()
        val public = intent?.extras?.getString(PUBLIC).toString()
        val visibility = intent?.extras?.getString(VISIBILITY).toString()
        val link = intent?.extras?.getString(IMG_URL).toString()

        setContentView(R.layout.activity_detail)

        findViewById<TextView>(R.id.RepoTitle).text = repoTitle
        findViewById<TextView>(R.id.OwnerName).text = ownerName
        findViewById<TextView>(R.id.description).text = description
        findViewById<TextView>(R.id.description2).text = public
        findViewById<TextView>(R.id.Visibility).text = visibility

        Picasso.get().load(link).into(findViewById<ImageView>(R.id.imageView))
    }
}