package ru.rubberteam.inventa.retrofit.interfaces

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.rubberteam.inventa.domain.task.Task

interface TasksApi {

    @GET("/task/getTasksByUser")
    @Headers("Content-Type: application/json")
    fun getTasksByUser(@Query("user") user: String): Call<MutableList<Task>>


}