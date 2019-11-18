package br.com.thiagozg.githubjobs.data.di

import br.com.thiagozg.githubjobs.data.GitHubApiDataSource
import br.com.thiagozg.githubjobs.data.GitHubRepositoryImpl
import br.com.thiagozg.githubjobs.domain.jobs.GitHubRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
val dataModule = module {
    single { RetrofitApiProvider.buildServiceApi<GitHubApiDataSource>(androidApplication()) }
    single<GitHubRepository> { GitHubRepositoryImpl(get()) }
}