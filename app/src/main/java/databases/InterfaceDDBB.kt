package databases

import androidx.room.*


@Dao
interface interfaceDDBB {

    @Query("SELECT * FROM ModeloProductosBBDD")
    fun getAll(): List<ModeloProductosBBDD>

    @Query("SELECT * FROM ModeloProductosBBDD WHERE id LIKE :id")
    fun findByTitle(id: String): ModeloProductosBBDD

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg todo: ModeloProductosBBDD)

    @Update
    fun updateTodo(vararg todos: ModeloProductosBBDD)

}