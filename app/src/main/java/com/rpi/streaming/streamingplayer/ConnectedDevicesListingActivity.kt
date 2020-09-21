package com.rpi.streaming.streamingplayer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_connected_devices_listing.*
import java.util.ArrayList


class ConnectedDevicesListingActivity : AppCompatActivity() {
    private val connectedDevicesList = ArrayList<ConnectedDevices>()
    private var mAdapter: ConnectedDevicesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connected_devices_listing)
        mAdapter = ConnectedDevicesAdapter(connectedDevicesList)
        connectedDevicesRecyclerView!!.setHasFixedSize(true)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        connectedDevicesRecyclerView!!.layoutManager = mLayoutManager
        connectedDevicesRecyclerView!!.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        connectedDevicesRecyclerView!!.itemAnimator = DefaultItemAnimator()
        connectedDevicesRecyclerView!!.adapter = mAdapter
        connectedDevicesRecyclerView!!.addOnItemTouchListener(
            RecyclerTouchListener(
                applicationContext,
                connectedDevicesRecyclerView!!,
                object : RecyclerTouchListener.ClickListener {
                    override fun onLongClick(view: View?, position: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onClick(view: View, position: Int) {
                        loadActivePlaylist(position)
                    }
                })
        )
        prepareMovieData()
    }

    private fun loadActivePlaylist(index: Int) {
        val intent = Intent(this, DeviceActivePlaylistActivity::class.java)
        intent.putExtra("index", index)
        startActivity(intent)
    }

    private fun prepareMovieData() {
        val connectedDevice = ConnectedDevices("Mad Max: Fury Road", "Action & Adventure")
        connectedDevicesList.add(connectedDevice)

        mAdapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_one) {
            Toast.makeText(this, "Item One Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_two) {
            Toast.makeText(this, "Item Two Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_three) {
            Toast.makeText(this, "Item Three Clicked", Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)

    }
}