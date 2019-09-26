package br.com.thiagozg.githubjobs.presentation.fragment

import android.os.Parcelable
import br.com.thiagozg.githubjobs.data.model.JobDTO
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

fun JobDTO.toVO() = JobVO(
    company,
    companyLogo,
    companyUrl,
    createdAt,
    description,
    howToApply,
    location,
    title
)
