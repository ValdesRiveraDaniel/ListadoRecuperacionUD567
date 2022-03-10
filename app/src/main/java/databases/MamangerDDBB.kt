package databases



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE = "secretChat"

@Database(
    entities = [ModeloProductosBBDD::class],
    version = 1,
    exportSchema = false
)
abstract class DatabaseManager : RoomDatabase() {

    abstract fun roomDb(): interfaceDDBB

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: DatabaseManager? = null

        fun getInstance(context: Context): DatabaseManager {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): DatabaseManager {
            return Room.databaseBuilder(context, DatabaseManager::class.java, DATABASE).allowMainThreadQueries()
                .build()
        }
    }
}