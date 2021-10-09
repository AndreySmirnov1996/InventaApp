package ru.rubberteam.inventa.modules

import dagger.Module
import dagger.Provides
import ru.rubberteam.inventa.services.RetrofitClientService

@Module
class RetrofitClientModule {

    @Provides
    fun provideRetrofitClientService(): RetrofitClientService {
        return RetrofitClientService()
    }

}