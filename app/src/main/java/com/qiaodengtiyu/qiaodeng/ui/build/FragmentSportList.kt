package com.qiaodengtiyu.qiaodeng.ui.build

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.anshdeep.qiaodeng.R
import com.anshdeep.qiaodeng.databinding.FragmentSportListBinding
import com.qiaodengtiyu.qiaodeng.domain.Sport

class FragmentSportList:Fragment(){


    private lateinit var binding: FragmentSportListBinding

    private val viewModel=FragmentSportListViewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportListBinding.inflate(inflater, container, false)
        val adapter = SportListAdapter(SportClick {
            findNavController().navigate(R.id.badmintonFragment)
        })
        binding.sportList.adapter = adapter

        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: SportListAdapter) {
        viewModel.sportsLiveData.observe(viewLifecycleOwner, Observer {
                adapter.sportsList=it
        })
    }

}
class SportClick(val block: (Sport) -> Unit) {
    fun onClick(video: Sport) = block(video)
}