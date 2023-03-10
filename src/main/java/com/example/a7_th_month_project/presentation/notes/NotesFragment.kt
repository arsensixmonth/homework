package com.example.a7_th_month_project.presentation.notes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.a7_th_month_project.R
import com.example.a7_th_month_project.base.BaseFragment
import com.example.a7_th_month_project.databinding.FragmentNotesBinding

class NotesFragment : BaseFragment<NotesViewModel, FragmentNotesBinding>() {
    override val vm: NotesViewModel by viewModels()

    override val binding: FragmentNotesBinding = FragmentNotesBinding.inflate(layoutInflater)

    override fun setupRequest() {
        vm.noteState.collectState(onLoading = {

        }, onError =  {

        }, onSucces =  {

        })
    }

    override fun listener() {
        super.listener()
    }

    override fun initialise() {
        super.initialise()
    }

}