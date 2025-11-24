
import data.dao.MenuItemDao
import data.entity.MenuItem
import kotlinx.coroutines.flow.Flow

class MenuRepository(private val dao: MenuItemDao) {

    fun getAll(): Flow<List<MenuItem>> = dao.getAll()

    suspend fun insert(item: MenuItem) {
        dao.insert(item)
    }

    suspend fun update(item: MenuItem) {
        dao.update(item)
    }

    suspend fun delete(item: MenuItem) {
        dao.delete(item)
    }
}
