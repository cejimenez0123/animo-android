package com.solbao.animo.android.data.apis

import com.solbao.animo.AppKonfig
import com.solbao.animo.android.util.Enviroment
import de.jensklingenberg.ktorfit.Ktorfit

interface TaskApi {
    companion object{
        private val ktorfit = Ktorfit.Builder().baseUrl(AppKonfig.BASE_PATH).build()

    //        val instance = ktorfit.createT
    }
}