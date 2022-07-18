package com.example.paging3compose.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging3compose.utils.Constants.UNSPLASH_REMOTE_KEYS_TABLE

/**
 * Created by Nicola Luigi Piriottu on 18/07/22.
 */
@Entity( tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val prevPage:Int?,
    val nextPage:Int?
)
