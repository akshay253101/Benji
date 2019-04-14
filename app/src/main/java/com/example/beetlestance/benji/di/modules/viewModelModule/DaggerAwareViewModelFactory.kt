package com.example.beetlestance.benji.di.modules.viewModelModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.beetlestance.benji.ui.todo.TodoFragmentModule
import javax.inject.Inject
import javax.inject.Provider

/**
 * ViewModel Factory which uses dagger to create instances.
 * @see [TodoFragmentModule.bindTodoViewModel] for key mapping.
 */
class DaggerAwareViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val found =
            creators.entries.find { modelClass.isAssignableFrom(it.key) }   //isAssignableFrom checks if the provide view model is in the creators
        val creator = found?.value
            ?: throw IllegalArgumentException("unknown model class $modelClass")  // If key is not mapped in creators key it will throw error
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T  // let dagger create our viewModel by invoking get()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
