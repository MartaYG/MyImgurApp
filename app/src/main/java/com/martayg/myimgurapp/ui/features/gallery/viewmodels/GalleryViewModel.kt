package com.martayg.myimgurapp.ui.features.gallery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.martayg.domain.interactors.features.gallery.GetAllImagesGalleryPagerUseCase
import com.martayg.model.features.gallery.Image
import com.martayg.myimgurapp.ui.common.states.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val imagesGalleryPager: GetAllImagesGalleryPagerUseCase
):ViewModel() {

    private val _loadingState by lazy { MutableStateFlow<ResourceState<*>>(ResourceState.Idle) }
    val loadingState: StateFlow<ResourceState<*>> get() = _loadingState

    fun loadImagesGallery(): Flow<PagingData<Image>> =
        imagesGalleryPager()
            .catch { error ->
                _loadingState.update { ResourceState.Error(error) }
            }
            .map { pagingData ->
                _loadingState.update { ResourceState.Success("") }
                pagingData
            }
}