package com.martayg.data.repository.features.gallery.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.martayg.data.repository.features.gallery.interfaz.GalleryRepository
import com.martayg.model.features.gallery.Image
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class ImagesGalleryPagingSource @Inject constructor(
    private val galleryRepository: GalleryRepository
): PagingSource<Int, Image>() {
    override fun getRefreshKey(state: PagingState<Int, Image>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> =
        try {
            val page = params.key ?: 0
            val perPage = 20
            val response = galleryRepository.getAllImages(
                page=page,
                perPage = perPage
            ).first()

            LoadResult.Page(
                data = response,
                prevKey = if(page == 0) null else page.minus(1),
                nextKey = if(response.isEmpty()) null else page.plus(1)
            )
        }catch (exception:Exception){
            LoadResult.Error(exception)
        }

}