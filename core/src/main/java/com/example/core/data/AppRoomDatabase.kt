package com.example.core.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.dao.FurnitureDao
import com.example.core.model.CartHomeItem
import com.example.core.model.HomeItem

@Database(entities = [HomeItem::class, CartHomeItem::class], version = DatabaseMigrations.latestVersion, exportSchema = false)
@FeatureScope
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun furnitureDao(): FurnitureDao

    companion object {

        private const val databaseName = "furniture-db"

        fun buildDefault(context: Context): AppRoomDatabase = synchronized(this) {
            Room.databaseBuilder(context, AppRoomDatabase::class.java,
                databaseName
            )
                .addMigrations(*DatabaseMigrations.migrations)
                .build()
        }
    }
}