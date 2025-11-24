package com.example.nutritionalinformation

import MenuRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nutritionalinformation.ui.screens.NutritionalInformationScreen

import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.nutritionalinformation.ui.theme.NutritionalInformationTheme
import com.example.nutritionalinformation.ui.viewmodel.MenuViewModel
import com.example.nutritionalinformation.ui.viewmodel.MenuViewModelFactory
import data.db.AppDatabase

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MenuViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = AppDatabase.getDatabase(applicationContext)
        val repository = MenuRepository(database.menuItemDao())
        val factory = MenuViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MenuViewModel::class.java]

        enableEdgeToEdge()


                setContent {
            NutritionalInformationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NutritionalInformationTheme {
        Greeting("Android")
    }
}