package br.com.thiagozg.githubjobs.di

import br.com.thiagozg.githubjobs.data.di.dataModule
import br.com.thiagozg.githubjobs.domain.di.domainModule
import br.com.thiagozg.githubjobs.jobsresults.di.mainModule
import org.koin.core.context.loadKoinModules

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
object FeaturesModules {
    fun mainFeature() = loadKoinModules(listOf(
        dataModule,
        domainModule,
        mainModule
    ))
}