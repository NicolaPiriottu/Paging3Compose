package com.example.paging3compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3compose.data.local.dao.UnsplashImageDao
import com.example.paging3compose.data.local.dao.UnsplashRemoteKeyDao
import com.example.paging3compose.model.UnsplashImage
import com.example.paging3compose.model.UnsplashRemoteKeys

/**
 * Created by Nicola Luigi Piriottu on 18/07/22.
 */
@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {


    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeyDao(): UnsplashRemoteKeyDao

}