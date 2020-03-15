package com.ufabc.moduloconteudo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class HomeActivity : AppCompatActivity() {
     // Modificação qualquer só para testar se as funcionalidades do AS com o git estão funcionando direito

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val fab : View = findViewById(R.id.fab_libras)
        fab.setOnClickListener { view ->
            Toast.makeText(this, "Abrir video com tradução em Libras", Toast.LENGTH_SHORT).show()
        }

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_classes, R.id.navigation_archives, R.id.navigation_tutorial, R.id.navigation_configuration
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //FIXME: Pegar informações da tela condigurações
        navView.itemIconSize = 120
    }
}
