package com.example.a20230140094_roomdatabase.repositori

import android.app.Application
import android.content.Context
import com.example.a20230140094_roomdatabase.room.DatabaseSiswa

interface containerApp{
    val repositoriSiswa : RepositoriSiswa
}

class ContainerDataApp(private val context: Context): containerApp{
    override val repositoriSiswa: RepositoriSiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}

class AplikasiSiswa : Application(){
    /**
     * AppContainer instance digunakan oleh kelas lainnya untuk mendapatkan dependensi
     */

    lateinit var container: containerApp

    override fun onCreate(){
        super.onCreate()
        container = ContainerDataApp(this)

    }
}