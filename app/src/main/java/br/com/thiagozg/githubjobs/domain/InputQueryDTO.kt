package br.com.thiagozg.githubjobs.domain

import android.os.Parcelable

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
@Parcelize
class InputQueryDTO(
    var language: String? = null,
    var location: String? = null
) : Parcelable