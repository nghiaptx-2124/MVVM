package com.example.mvvm.master

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import kotlinx.android.synthetic.main.fragment_master.*

class MasterFragment : Fragment(),LifecycleOwner, MasterAdapter.OnclickListener {
    private lateinit var mViewModel: MasterViewModel
    private lateinit var mAdapter: MasterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_master,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(requireActivity()).get(MasterViewModel::class.java)
        initView()
        mViewModel.getData().observe(
            this, Observer {
                mAdapter.addData(it) })

    }

    private fun initView() {
         mAdapter = MasterAdapter()
         mAdapter.setListener(this)
        recycleview.adapter = mAdapter
    }

    override fun onClick(result: String) {
        mViewModel.setSelectedItem(result)
    }
}