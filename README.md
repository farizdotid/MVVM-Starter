
<h1 align="center">MVVM Starter</h1></br>
<p align="center">  
A demo Images app using <a href="https://material.io/design/motion/the-motion-system.html" target="_blank"> transformation motions </a> based on MVVM architecture.<br>
</p>

## Screeshots
<p align="center">

</p>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct database.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
  - [Koin](https://github.com/InsertKoinIO/koin) - dependency injection
- Material Design & Animations
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor, logging and mocking web server
- [Glide](https://github.com/bumptech/glide) - loading images
- [BaseRecyclerViewAdapter](https://github.com/skydoves/BaseRecyclerViewAdapter) - implementing adapters and viewHolders
- [WhatIf](https://github.com/skydoves/whatif) - checking nullable object and empty collections more fluently
- [Timber](https://github.com/JakeWharton/timber) - logging
- Ripple animation, Shared element container transform/transition

## Unit Testing Frameworks
Unit Tests verify the interactions of viewmodels between repositories and dao & REST api requests.
- [Robolectric](https://github.com/robolectric/robolectric) - Robolectric is the industry-standard unit testing framework for Android.
- [Mockito-Kotlin](https://github.com/nhaarman/mockito-kotlin) - a small library that provides helper functions to work with Mockito in Kotlin.

# Reference
[DisneyMotions](https://github.com/skydoves/DisneyMotions) - A demo Disney app using transformation motions based on MVVM architecture.

# License
```xml
Designed and developed by 2020 skydoves (Jaewoong Eum)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```