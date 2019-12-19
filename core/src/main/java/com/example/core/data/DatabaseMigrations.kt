package com.example.core.data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

internal object DatabaseMigrations {

    // Bump this on changing the schema
    const val latestVersion = 2

    val migrations: Array<Migration>
        get() = arrayOf(
            migration_1_2(),
            migration_2_3()
        )

    fun migration_1_2() = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {

        }

    }

    fun migration_2_3() = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {

        }

    }
}