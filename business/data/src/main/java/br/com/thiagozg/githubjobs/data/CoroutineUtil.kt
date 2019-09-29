package br.com.thiagozg.githubjobs.data

import com.google.gson.JsonParseException
import kotlinx.coroutines.*
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

/*
 * Created by Thiago Zagui Giacomini on 29/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
fun coroutineIo(work: suspend (() -> Unit)): Job =
    CoroutineScope(Dispatchers.IO).launch {
        work()
    }

fun <T : Any> coroutineIoUi(
    coroutineContext: CoroutineContext,
    request: suspend (() -> Deferred<Response<T>>?),
    onSuccess: (T?) -> Unit,
    onError: (exception: Exception) -> Unit
) = try {
    CoroutineScope(coroutineContext).launch {
        val asyncRequest = CoroutineScope(Dispatchers.IO).async rq@ {
            return@rq request()
        }.await()
        val deferred = asyncRequest?.await()

        deferred?.let {
            handleSuccessError(it, onSuccess, onError)
        } ?: throwsJsonParseException(onError)
    }
} catch (ex: Exception) {
    onError(ex)
}

private fun <T : Any> handleSuccessError(
    response: Response<T>,
    onSuccess: (T?) -> Unit,
    onError: (exception: Exception) -> Unit
) = if (response.isSuccessful) {
    onSuccess(response.body())
} else {
    onError(IllegalAccessException("Wasn't able to receive a success response."))
}

private fun throwsJsonParseException(onError: (exception: Exception) -> Unit) {
    onError(JsonParseException("Different response object than expected."))
}
