package com.rpi.streaming.streamingplayer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_device_active_playlist.*

class DeviceActivePlaylistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_active_playlist)
        spotifySourceButton.setOnClickListener {
            loadPlaylistActivity(DeviceActiveSpotifyPlaylistActivity::class.java)
        }
        tuneinSourceButton.setOnClickListener {
            loadPlaylistActivity(DeviceActiveTuneInPlaylistActivity::class.java)
        }
        localSourceButton.setOnClickListener {
            loadPlaylistActivity(DeviceActiveLocalPlaylistActivity::class.java)
        }
    }

    private fun loadPlaylistActivity(activity: Class<*>) {
        val intent = Intent(this, activity)
        Log.d("ActivityResult", activity.toString())
//        intent.putExtra("index", index)
        startActivity(intent)
    }
}