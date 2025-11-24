package ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nutritionalinformation.ui.viewmodel.MenuViewModel

@Composable
fun NutritionalInformationScreen(
    viewModel: MenuViewModel,
    modifier: Modifier = Modifier
) {
    val menuItems by viewModel.menuItems.collectAsState()

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Menú disponible",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(menuItems) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
