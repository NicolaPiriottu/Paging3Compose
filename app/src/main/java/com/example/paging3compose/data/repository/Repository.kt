package com.example.paging3compose.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3compose.data.local.UnsplashDatabase
import com.example.paging3compose.data.paging.UnsplashRemoteMediator
import com.example.paging3compose.data.remote.UnsplashApi
import com.example.paging3compose.model.UnsplashImage
import com.example.paging3compose.utils.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */
@OptIn(ExperimentalPagingApi::class)
class Repository @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) {

    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = Constants.ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}