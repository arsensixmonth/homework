package com.example.a7_th_month_project.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.a7_th_month_project.presentation.notes.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@Suppress("UNUSED_EXPRESSION")
abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {
    protected abstract val vm: VM
    protected abstract val binding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialise()
        listener()
        setupRequest()

    }

    protected open fun initialise() {}
    protected open fun listener() {}
    protected open fun setupRequest() {}

    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        onSucces: (T) -> Unit,
        onError: (String) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect {
                    when (it) {
                        is UIState.Empty -> {
                        }
                        is UIState.Error -> {
                            onError(it.msg)
                        }
                        is UIState.Loading -> {
                            onLoading()
                        }
                        is UIState.Success -> {
                            it.data?.let { it1 -> onSucces(it1) }
                        }
                    }
                }
            }
        }
    }
}