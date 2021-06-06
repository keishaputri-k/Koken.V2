package com.kei.kokenv2.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
//Repository bertanggung jawab untuk semua data yang akan digunakan di aplikasi.
// Mau itu menyimpan data, melakukan update data, menghapus data atau mencari data serahkan semuanya kepada Repository
class  Repository @Inject constructor(
    remoteDataSource: RemoteDataSource,
    localDataSource: LocalDataSource
) {
    val remote = remoteDataSource
    val local = localDataSource

}