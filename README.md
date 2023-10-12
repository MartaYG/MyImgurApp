# MyImgurApp

## Introducción

En esta App se podrá visualizar una galería de imágenes de la plataforma Imgur, que se tendra que acceder con un Login previamente.

![1697107826636](https://github.com/MartaYG/MyImgurApp/assets/34567942/c497b4f6-9e07-4a48-9cbd-9eca19fcb060) ![1697107826628](https://github.com/MartaYG/MyImgurApp/assets/34567942/4d3b0824-62a5-4cb7-92bc-d9cf1b0e949c)

![1697107826621](https://github.com/MartaYG/MyImgurApp/assets/34567942/08d5ed54-f37f-484d-9ff6-c850edd7b314) ![1697107826616](https://github.com/MartaYG/MyImgurApp/assets/34567942/e015bf67-c54d-49fa-9a2f-c413bbf19ead)

## Estructura del proyecto

Este proyecto se compone de 5 capas:

- app: Es la capa en la que se encarga de la presentación visual e interacción con el usuario. Contiene         
       arquitectura MVVM y Jetpack Compose 
- domain: Es la capa que se encarga de centrar los casos de uso y la lógica de negocio de la app para obtener 
          fuente de datos externas.
- data: Es la capa que se encarga de la gestión de datos, en la que escoge de la capa de datasource los datos a remoto o cache. 
- datasource: Es la capa de gestionar el acceso a la fuente de datos externas de una base de datos y servicios web
- model: contiene las entidades de dominio.

## Características y funcionalidades implementadas

- Lenguaje de programación [Kotlin](https://kotlinlang.org).
- [Corrutinas](https://developer.android.com/kotlin/coroutines?hl=es-419) de kotlin.
- Flujos de kotlin con [Flow](https://developer.android.com/kotlin/flow?hl=es-419).
- Base de datos local con [Room](https://developer.android.com/training/data-storage/room?hl=es-419).
- Acceso a APIs Rest con [Retrofit](https://square.github.io/retrofit/).
- Inyección de dependencias con [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=es-419).
- Paginación con [paging](https://developer.android.com/topic/libraries/architecture/paging/v3-overview?hl=es-419) en compose.
- Login y galería con [Jetpack Compose](https://developer.android.com/jetpack/compose?hl=es-419).
