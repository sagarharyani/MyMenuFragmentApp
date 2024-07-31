package com.example.mymenufragmentapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import android.widget.Button // Ensure this import is present

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonShowFragment: Button = findViewById(R.id.button_show_fragment)
        buttonShowFragment.setOnClickListener {
            showFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_show_fragment -> {
                showFragment()
                true
            }
            R.id.action_show_dialog_fragment -> {
                showDialogFragment()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showFragment() {
        val fragment = MyFragment()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showDialogFragment() {
        val dialogFragment = MyDialogFragment()
        dialogFragment.show(supportFragmentManager, "MyDialogFragment")
    }
}
