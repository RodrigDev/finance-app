package com.rodrigo.financ.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rodrigo.financ.data.model.Task
import com.rodrigo.financ.utils.constants.Constants

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Query(value = "SELECT * FROM ${Constants.TaskConst.TABLE_NAME} ORDER BY id ASC")
    fun readAllData(): LiveData<List<Task>>

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query(value = "DELETE FROM ${Constants.TaskConst.TABLE_NAME}")
    suspend fun deleteAll()

}