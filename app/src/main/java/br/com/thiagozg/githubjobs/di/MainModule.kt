package br.com.thiagozg.githubjobs.di

import br.com.thiagozg.githubjobs.RetrofitApiProvider
import br.com.thiagozg.githubjobs.data.GitHubRepository
import br.com.thiagozg.githubjobs.presentation.MainViewModel
import br.com.thiagozg.githubjobs.presentation.adapter.JobsResultAdapter
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
val mainModule = module {

    single { RetrofitApiProvider.buildServiceApi(androidApplication()) }

    single { GitHubRepository(get()) }

    factory { MainViewModel(get()) }

    factory { JobsResultAdapter() }
}