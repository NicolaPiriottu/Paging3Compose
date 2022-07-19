package com.example.paging3compose.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */
@Serializable
data class SearchResult(

    @SerialName("results")
    val images: List<UnsplashImage>
)
