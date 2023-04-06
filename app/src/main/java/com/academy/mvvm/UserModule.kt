package com.academy.mvvm

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

//A Hilt module is a class that is annotated with @Module. It informs Hilt how to provide instances of certain types.
//Must annotate Hilt modules with @InstallIn to tell Hilt which Android class each module will be used or installed in.
// Eg. ActivityComponent (for Activity),SingletonComponent (for retroFit/roomDB etc.), FragmentComponent
@Module
@InstallIn(ActivityComponent::class) // Because using this module in Activity
class UserModule {
//    Tell Hilt how to provide instances of this(UserRepository) type by creating a function inside a Hilt module and annotating that function with @Provides.
    @Provides
    fun providesUserRepository2() : UserRepository{
        return SQLRepository()
    }
}