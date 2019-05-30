package br.com.thiagozg.domain.api

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
        val deferred = (CoroutineScope(Dispatchers.IO).async rq@{
            return@rq request()
        }.await())?.await()
        deferred?.let {
            if (it.isSuccessful) onSuccess(it.body())
            else onError(IllegalAccessException("Wasn't able to receive a success response."))
        } ?: onError(JsonParseException("Different response object than expected."))
    }
} catch (ex: Exception) {
    onError(ex)
}