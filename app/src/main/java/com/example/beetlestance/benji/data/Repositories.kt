package com.example.beetlestance.benji.data

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.beetlestance.benji.constant.Constant.APPLICATION_CONTEXT
import com.example.beetlestance.benji.model.TodoListData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class Repositories @Inject constructor(
    private var retrofitRetrofitApiService: RetrofitApiService, private var db: RoomApiService,
    @Named(APPLICATION_CONTEXT) var context: Context
) {

    private lateinit var subscription: Disposable

    private var todoListData = MutableLiveData<List<TodoListData>>()

    fun loadPost(): MutableLiveData<List<TodoListData>> {
        subscription = db.getAll()
            .concatMap { dbPostList ->
                if (dbPostList.isEmpty()) retrofitRetrofitApiService.getNames().concatMap { apiPost ->
                    db.insertAll(*apiPost.toTypedArray())
                    Observable.just(apiPost)
                }
                else {
                    Observable.just(dbPostList)
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> todoListData.value = result },
                { error -> Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show() }
            )
        return todoListData
    }

    fun dispose() {
        subscription.dispose()
    }
}