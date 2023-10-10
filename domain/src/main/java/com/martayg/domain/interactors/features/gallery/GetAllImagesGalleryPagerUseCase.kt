package com.martayg.domain.interactors.features.gallery

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.martayg.data.repository.features.gallery.paging.ImagesGalleryPagingSource
import javax.inject.Inject

open class GetAllImagesGalleryPagerUseCase @Inject constructor(
    private val imagesPager: ImagesGalleryPagingSource
){
    open operator fun invoke() = Pager(
        config = PagingConfig(
            pageSize = 20
        ),
        pagingSourceFactory = { imagesPager }
    ).flow
}