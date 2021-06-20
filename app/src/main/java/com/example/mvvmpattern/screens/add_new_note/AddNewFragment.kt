package com.example.mvvmpattern.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpattern.R
import com.example.mvvmpattern.databinding.FragmentAddNewBinding
import com.example.mvvmpattern.models.AppNote
import com.example.mvvmpattern.utilits.APP_ACTIVITY
import com.example.mvvmpattern.utilits.showToast

class AddNewFragment : Fragment() {
    //фрагмент для добавления новых заметок

    private var _binding: FragmentAddNewBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddNewBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewFragmentViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener{
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()){
                showToast(getString(R.string.toastEnterName))
            } else {
                mViewModel.insert(AppNote(name = name, text = text)) {
                    APP_ACTIVITY.navController.navigate(R.id.action_addNewFragment_to_mainFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}