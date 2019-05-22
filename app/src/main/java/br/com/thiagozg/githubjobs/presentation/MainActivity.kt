package br.com.thiagozg.githubjobs.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import br.com.thiagozg.githubjobs.R
import kotlinx.android.synthetic.main.activity_main.*

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class MainActivity : AppCompatActivity() {

    private val navController by lazy { Navigation.findNavController(this, R.id.navHosFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupNavigation()
    }

    private fun setupNavigation() {
        bottomNavigationView?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
        navigationView?.let {
            NavigationUI.setupWithNavController(it, navController)
        }
        NavigationUI.setupActionBarWithNavController(this, navController, dlLandMainActivity)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = super.onOptionsItemSelected(item) || item?.run {
        NavigationUI.onNavDestinationSelected(item, navController)
    } ?: false

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, dlLandMainActivity)
    }
}
