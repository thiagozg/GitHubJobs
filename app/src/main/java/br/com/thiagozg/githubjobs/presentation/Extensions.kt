package br.com.thiagozg.githubjobs.presentation

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import br.com.thiagozg.githubjobs.R
import com.bumptech.glide.Glide

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
fun ImageView.bindImageView(
    companyLabel: String,
    companyLogoUrl: String?
) {
    contentDescription = companyLabel
    Glide.with(this)
        .load(companyLogoUrl)
        .centerCrop()
        .placeholder(R.color.primaryLight)
        .into(this)
}

inline fun <T : Any> LiveData<T>.observeNonNull(
    lifecycleOwner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
) {
    observe(lifecycleOwner, Observer {
        it ?: return@Observer
        onChanged.invoke(it)
    })
}