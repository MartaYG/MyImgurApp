package com.martayg.myimgurapp.ui.features.gallery.screen

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.martayg.model.features.gallery.Image
import com.martayg.myimgurapp.ui.common.states.ResourceState
import com.martayg.myimgurapp.ui.features.gallery.viewmodels.GalleryViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GalleryScreen(galleryViewModel: GalleryViewModel,navController: NavController) {
    val appContext = LocalContext.current
    val loadingState by galleryViewModel.loadingState.collectAsState()
    val imagesData = galleryViewModel.loadImagesGallery().collectAsLazyPagingItems()

    Column {
        when (loadingState) {

            is ResourceState.Error ->
                Toast.makeText(appContext, "error", Toast.LENGTH_SHORT).show()

            is ResourceState.Success ->
                GalleryView(imagesData=imagesData)

            else -> {}
        }
    }
}

@Composable
fun GalleryView(imagesData: LazyPagingItems<Image>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.weight(2f)
        ) {
            items(count = imagesData.itemCount) { index ->
                imagesData[index]?.let { item ->
                    ImageItem(item)
                }
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            GalleryButton()
        }
    }
}

@Composable
fun ImageItem(item: Image) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    ) {
        AsyncImage(
            model = item.link,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun GalleryButton(){
    Button(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(top = 16.dp)
            .height(40.dp),
        onClick = {},
    ) {
        Text("Importar imagen")
    }

    Spacer(modifier = Modifier.width(16.dp))

    Button(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(top = 16.dp)
            .height(40.dp),
        onClick = {},
    ) {
        Text("Tomar foto")
    }
}

@Preview(showBackground = true)
@Composable
fun GalleryPreview() {}