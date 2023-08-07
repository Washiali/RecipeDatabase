package com.example.mboga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.mboga.ui.dashboard.DashboardFragment
import com.example.mboga.ui.home.HomeFragment
import com.example.mboga.ui.notifications.NotificationsFragment
import com.example.mboga.ui.theme.MbogaTheme

class MainActivity2 : ComponentActivity() {

    lateinit var bottomNavigation : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        bottomNavigation = findViewById(R.id.nav_host_fragment_activity_main) as BottomNavigationView
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.navigation_dashboard -> {
                    loadFragment(DashboardFragment())
                    true
                }
                R.id.navigation_notifications -> {
                    loadFragment(NotificationsFragment())
                    true
                }
                else -> false
            }

        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManagerbeginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}



@Preview(showBackground = true, heightDp = 800, widthDp = 390)
@Composable
fun GreetingPreview2() {
    MbogaTheme {
    }
}