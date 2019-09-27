package br.com.thiagozg.githubjobs.domain

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
abstract class UseCase<out BO, in Params> where BO : Any {

    abstract suspend fun run(params: Params): BO

}