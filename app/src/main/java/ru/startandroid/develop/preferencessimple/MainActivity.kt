package ru.startandroid.develop.preferencessimple

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var tvInfo: TextView? = null
    var sp: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInfo = findViewById(R.id.tvInfo) as TextView

        sp = PreferenceManager.getDefaultSharedPreferences(this)
    }

    override fun onResume() {
        val notif: Boolean = sp!!.getBoolean("nitif", false)
        val address: String? = sp!!.getString("address", "")
        val text = "Notifications are $notif enabled, address = $address : disabled"
        tvInfo!!.text = text
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val mi = menu!!.add(0, 1, 0, "Preference")
        mi.setIntent(Intent(this, PrefActivity::class.java))
        return super.onCreateOptionsMenu(menu)
    }
}