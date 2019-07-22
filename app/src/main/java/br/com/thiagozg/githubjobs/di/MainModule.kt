package br.com.thiagozg.githubjobs.di

import br.com.thiagozg.githubjobs.data.GitHubRepository
import br.com.thiagozg.githubjobs.presentation.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
val mainModule = module {

    single { GitHubApiProvider.buildServiceApi(androidApplication()) }

    single { GitHubRepository(get()) }

    factory { MainViewModel(get()) }
}