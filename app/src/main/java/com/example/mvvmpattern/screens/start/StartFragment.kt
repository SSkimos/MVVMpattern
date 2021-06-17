package com.example.mvvmpattern.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpattern.R
import com.example.mvvmpattern.databinding.FragmentStartBinding
import com.example.mvvmpattern.utilits.APP_ACTIVITY
import com.example.mvvmpattern.utilits.TYPE_ROOM

class StartFragment : Fragment() {
    //фрагмент, из которого будет запускаться приложение

    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization(){
        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel:: class.java)
        mBinding.btnRoom.setOnClickListener{
            mViewModel.initDatabase(TYPE_ROOM){
                APP_ACTIVITY.mNavController.navigate(R.id.action_startFragment_to_mainFragment)
            }
        }
    }
}