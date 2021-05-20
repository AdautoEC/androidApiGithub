package com.example.jya.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.jya.Item
import com.example.jya.R
import com.example.jya.Constants.EXTRA_ITEM
import com.squareup.picasso.Picasso

class ItemDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_description)

        val clickedItem = intent.getSerializableExtra(EXTRA_ITEM) as? Item
        if (clickedItem != null) {
            launchScreen(clickedItem)
        }
    }

    fun launchScreen(item: Item){
        val imgUserAvatar: ImageView = findViewById(R.id.item_user_avatar)
        val btnGoToPage: AppCompatButton = findViewById(R.id.item_btn_go_url)
        val txtUserTitle: TextView = findViewById(R.id.item_title)
        val txtUserDescription: TextView = findViewById(R.id.item_description)
        val txtUserCreatedAt: TextView = findViewById(R.id.item_created_at)

        Picasso.with(this).load( item.userAvatarUrl).into(imgUserAvatar)
        btnGoToPage.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.htmlUrl))
            startActivity(browserIntent)
        }
        txtUserTitle.text = item.title
        txtUserDescription.text = item.body
        txtUserCreatedAt.text = item.createdAt
    }
}

