package data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "menu_items")
data class MenuItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val description: String,
    val category: String,
    val calories: Int,
    val carbs: Int,
    val fats: Int,
    val proteins: Int,
    val tags: String,
    val imageUrl: String? = null,
    val isFavorite: Boolean = false
)
