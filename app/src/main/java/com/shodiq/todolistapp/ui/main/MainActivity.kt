package com.shodiq.todolistapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.shodiq.todolistapp.R
import com.shodiq.todolistapp.databinding.ActivityMainBinding
import com.shodiq.todolistapp.ui.about.AboutDialogFragment
import com.shodiq.todolistapp.ui.taskform.TaskFormActivity
import com.shodiq.todolistapp.ui.tasklist.TaskListFragment
import com.shodiq.todolistapp.utils.views.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        //adding fragment to adapter
        viewPagerAdapter.addFragment(TaskListFragment.newInstance(false), "Undone Task")
        viewPagerAdapter.addFragment(TaskListFragment.newInstance(true), "Done Task")
        binding.vpTask.adapter = viewPagerAdapter
        //setting title for tab layout
        TabLayoutMediator(binding.tlTask, binding.vpTask, true) { tab, pos ->
            tab.text = viewPagerAdapter.getPageTitle(pos)
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.menu_add_task -> {
                startActivity(Intent(this,TaskFormActivity::class.java))
                true
            }
            R.id.menu_about -> {
                openDialogAbout()
                true
            }
            else -> {
                true
            }
        }
    }

    private fun openDialogAbout() {
        AboutDialogFragment().show(supportFragmentManager,null)
    }


}