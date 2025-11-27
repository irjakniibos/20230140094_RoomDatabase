package com.example.a20230140094_roomdatabase.repositori

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
