package br.com.thiagozg.githubjobs.domain

import br.com.thiagozg.githubjobs.domain.jobs.model.business.StateBusiness
import com.sun.net.httpserver.Authenticator

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
abstract class UseCase<in Params, out BO> {

    abstract suspend fun run(params: Params): StateBusiness<BO>

    suspend operator fun invoke(params: Params) = run(params)

}