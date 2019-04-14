package com.example.beetlestance.benji.domain

import com.example.beetlestance.benji.data.Repositories
import javax.inject.Inject

class TodoUseCase @Inject constructor(var repositories: Repositories) {

    fun onDispose() {
        repositories.dispose()
    }

    operator fun invoke() = repositories.loadPost()
}