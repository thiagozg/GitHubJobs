package br.com.thiagozg.githubjobs.data.model

/*
 * Created by Thiago Zagui Giacomini on 29/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
sealed class StateResponse
class StateSuccess<T>(val data: T) : StateResponse()
class StateError(val error: Throwable) : StateResponse()