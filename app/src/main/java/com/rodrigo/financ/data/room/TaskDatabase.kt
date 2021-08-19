package com.rodrigo.financ.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rodrigo.financ.data.model.Task
import com.rodrigo.financ.utils.constants.Constants

@Database(entities = [Task::class], version = Constants.TaskConst.DATABASE_VERSION, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            val tempInstance = INSTANCE

            if ( tempInstance != null ) return tempInstance else {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        Constants.TaskConst.DATABASE_NAME
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }

}