package ru.rubberteam.inventa.retrofit.interfaces

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.rubberteam.inventa.domain.task.Task

interface GetTasksRetro {
    @GET("/task/getTasksByUser")
    fun tasksForUser(@Query("user") user: String): Call<MutableList<Task>>
//	@GET("/users/{user}/repos")
//	fun tasksForUser(@Path("user") user: String): Call<MutableList<TaskTestDTO>>
}