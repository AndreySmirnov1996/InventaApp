package ru.rubberteam.inventa.models

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.rubberteam.inventa.retrofit.interfaces.TasksApi

class TasksModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
//
//    fun fetchTasks(taskApi: TasksApi) {
//        compositeDisposable.add(
//            taskApi.getTasksByUser("user")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                           Log.e("TAG", it.size.toString())
//                }, {
//                    Log.e("TAG", "error")
//                }))
//    }
}