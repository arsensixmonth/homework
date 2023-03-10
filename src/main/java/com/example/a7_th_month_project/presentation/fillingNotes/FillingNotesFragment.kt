package com.example.a7_th_month_project.presentation.fillingNotes

import androidx.fragment.app.viewModels
import com.example.a7_th_month_project.base.BaseFragment
import com.example.a7_th_month_project.databinding.FragmentFillingNotesBinding

class FillingNotesFragment : BaseFragment<FillingNotesViewModel, FragmentFillingNotesBinding>() {
    override val vm: FillingNotesViewModel by viewModels()
    override val binding: FragmentFillingNotesBinding =
        FragmentFillingNotesBinding.inflate(layoutInflater)

    override fun setupRequest() {
        vm.noteState.collectState(onLoading = {

        }, onError = {

        }, onSucces = {

        })
    }


}