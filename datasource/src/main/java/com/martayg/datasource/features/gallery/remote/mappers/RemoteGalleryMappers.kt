package com.martayg.datasource.features.gallery.remote.mappers

import com.martayg.datasource.features.gallery.remote.models.RemoteSingleImage
import com.martayg.model.features.gallery.Image

fun RemoteSingleImage.toDomain(): Image = Image(
    imageId = this.imageId,
    link = this.link,
    username = this.username
)