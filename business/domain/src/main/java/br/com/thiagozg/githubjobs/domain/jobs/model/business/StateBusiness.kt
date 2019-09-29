package br.com.thiagozg.githubjobs.domain.jobs.model.business

import br.com.thiagozg.githubjobs.domain.jobs.model.business.StateBusiness.Companion.failure
import br.com.thiagozg.githubjobs.domain.jobs.model.business.StateBusiness.Companion.success

/*
 * Created by Thiago Zagui Giacomini on 28/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
data class StateBusiness<out T>(
    val status: Status,
    val data: T? = null,
    val exception: Exception? = null
) {

    companion object {
        fun <T> success(data: T): StateBusiness<T> {
            return StateBusiness(Status.SUCCESS, data = data)
        }

        fun <T> failure(exception: Exception): StateBusiness<T> {
            return StateBusiness(Status.ERROR, exception = exception)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR
    }

    inline fun <T, R> fold(
        onSuccess: (data: T) -> R,
        onFailure: (exception: Exception) -> R
    ): R = if (status == Status.SUCCESS) {
        onSuccess(data as T)
    } else {
        onFailure(exception!!)
    }

}

inline fun <R> runCatchingState(func: () -> R): StateBusiness<R> = try {
    success(func())
} catch (e: Exception) {
    failure(e)
}

