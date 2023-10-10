package com.martayg.datasource.features.gallery.cache.mapper

import com.martayg.datasource.features.gallery.cache.models.CacheImage
import com.martayg.model.features.gallery.Image

fun CacheImage.toDomain(): Image=Image(
    imageId = this.imageId,
    link =this.link,
    username = this.accountUrl
)

fun Image.toCache(): CacheImage = CacheImage(
    imageId=this.imageId,
    link=this.link,
    accountUrl = this.username
)