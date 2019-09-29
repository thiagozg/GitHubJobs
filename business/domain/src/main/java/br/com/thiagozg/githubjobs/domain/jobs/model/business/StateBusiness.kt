package br.com.thiagozg.githubjobs.domain.jobs.model.business

/*
 * Created by Thiago Zagui Giacomini on 28/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
data class StateBusiness<out T>(val data: T? = null, val exception: Exception? = null) {
    companion object {
        fun <T> success(data: T? = null): StateBusiness<T> {
            return StateBusiness(data = data)
        }

        fun <T> error(exception: Exception): StateBusiness<T> {
            return StateBusiness(exception = exception)
        }
    }
}