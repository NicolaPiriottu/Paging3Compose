package com.example.paging3compose.screens.home

import androidx.lifecycle.ViewModel
import com.example.paging3compose.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Nicola Luigi Piriottu on 19/07/22.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(repository: Repository) : ViewModel() {
    val getAllImages = repository.getAllImages()
}