package br.com.thiagozg.githubjobs.presentation.fragment

import android.os.Parcelable
import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.JobBO
import kotlinx.android.parcel.Parcelize

/*
 * Created by Thiago Zagui Giacomini on 24/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
@Parcelize
class JobVO(
    val company: String,
    val companyLogo: String?,
    val companyUrl: String?,
    val createdAt: String,
    val description: String,
    val howToApply: String,
    val location: String,
    val title: String
) : Parcelable

fun JobBO.toVO(): JobVO = companyBO.run {
    JobVO(
        name,
        logo,
        url,
        createdAt,
        description,
        howToApply,
        location,
        title
    )
}
