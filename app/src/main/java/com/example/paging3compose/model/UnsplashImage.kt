package com.example.paging3compose.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging3compose.utils.Constants.UNSPLASH_IMAGE_TABLE
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Nicola Luigi Piriottu on 18/07/22.
 */

@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    @Embedded
    val urls:Urls,
    val likes: Int,
    @Embedded
    val user:User
)

@Serializable
data class Urls(
    @SerialName("regular")
    val regular:String
)
@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val links: UserLinks,
    val username:String
)
@Serializable
data class UserLinks(
    val html:String
)


