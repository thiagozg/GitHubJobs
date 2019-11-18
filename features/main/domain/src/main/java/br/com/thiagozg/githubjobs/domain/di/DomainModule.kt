package br.com.thiagozg.githubjobs.domain.di

import br.com.thiagozg.githubjobs.domain.jobs.usecase.FetchJobsUseCase
import org.koin.dsl.module

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
val domainModule = module {
    single { FetchJobsUseCase(get()) }
}