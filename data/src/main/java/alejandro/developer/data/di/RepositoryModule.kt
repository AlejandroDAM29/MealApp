package alejandro.developer.data.di

import alejandro.developer.data.repository.MealRepositoryImpl
import alejandro.developer.domain.repository.MealRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideMealRepository(repository: MealRepositoryImpl): MealRepository
}