package com.hmju.presentation

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.hmju.presentation.databinding.FMainBinding
import com.hmju.presentation.refreshtoken.RefreshTokenFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment(R.layout.f_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = DataBindingUtil.bind<FMainBinding>(view)!!

        binding.expiredToken.setOnClickListener {
            moveFragment(RefreshTokenFragment())
        }
    }

    private fun moveFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}