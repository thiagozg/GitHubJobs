package br.com.thiagozg.githubjobs.di

import br.com.thiagozg.githubjobs.data.GitHubRepositoryImpl
import br.com.thiagozg.githubjobs.data.di.RetrofitApiProvider
import br.com.thiagozg.githubjobs.jobsresults.MainViewModel
import br.com.thiagozg.githubjobs.jobsresults.adapter.JobsResultAdapter
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
val mainModule = module {

    single { RetrofitApiProvider.buildServiceApi<RetrofitApiProvider>(androidApplication()) }

    single { GitHubRepositoryImpl(get()) }

    factory { MainViewModel(get()) }

    factory { JobsResultAdapter() }
}