package com.shodiq.todolistapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    var id : Int,
    var title : String,
    var desc : String,
    var imgHeaderUrl : String,
    var isTaskCompleted : Boolean,
) : Parcelable
