package com.devteam.jetpackusers.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devteam.jetpackusers.R
import com.devteam.jetpackusers.common.AppViewModelFactory
import com.devteam.jetpackusers.databinding.FragmentUserDetailBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class UserDetailFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    lateinit var binding: FragmentUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user_detail, container, false)
        binding = FragmentUserDetailBinding.inflate(inflater, view as ViewGroup?, false);
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // get the factory instance from DI
        val factory: AppViewModelFactory by instance()

        viewModel = ViewModelProvider(this, factory).get(UserDetailViewModel::class.java)

        viewModel.userId = arguments?.getInt("userId")!!
        viewModel.userDetails.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.user = it
            }
        })
    }
}