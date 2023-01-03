package com.hyeon.todolist.ui

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.hyeon.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /** ActionBar 감추기 */
        supportActionBar?.hide()

        /** Navigation View EventListener */
        binding.imageViewButtonMenu.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.END)
        }
    }

    /** Navigation 메뉴 아이템 클릭시 수행 */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

        }
        return false
    }
    /** BackButton 클릭 */
    override fun onBackPressed() {

        if (binding.layoutDrawer.isDrawerOpen(GravityCompat.END)){  // Navigation View 열려있을 때
            binding.layoutDrawer.closeDrawers()
        }
        else{
            super.onBackPressed()
        }



    }

}