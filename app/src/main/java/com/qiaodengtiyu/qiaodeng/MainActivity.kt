package com.qiaodengtiyu.qiaodeng

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.anshdeep.qiaodeng.R
import com.qiaodengtiyu.qiaodeng.ui.build.FragmentBuild
import com.qiaodengtiyu.qiaodeng.ui.dashboard.FragmentDashboard
import com.qiaodengtiyu.qiaodeng.ui.home.FragmentHome
import com.qiaodengtiyu.qiaodeng.ui.me.FragmentMe
import com.qiaodengtiyu.qiaodeng.ui.notification.FragmentNotification
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.qiaodengtiyu.qiaodeng.ui.build.BadmintonFragment


class MainActivity : AppCompatActivity() ,BadmintonFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {

    }

    private var content: FrameLayout? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = FragmentHome()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = FragmentDashboard()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_build -> {
                val fragment = FragmentBuild()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val fragment = FragmentNotification()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_me -> {
                val fragment = FragmentMe()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content = findViewById(R.id.content)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = FragmentBuild()
        addFragment(fragment)
    }

    /**
     * add/replace fragment in container [FrameLayout]
     */
    @SuppressLint("PrivateResource")
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.content, fragment, fragment.javaClass.simpleName)
                .commit()
    }
}
