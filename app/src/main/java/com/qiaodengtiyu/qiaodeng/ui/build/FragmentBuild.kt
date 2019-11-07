package com.qiaodengtiyu.qiaodeng.ui.build

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anshdeep.qiaodeng.R

/**
 * Created by ansh on 21/02/18.
 */
class FragmentBuild : Fragment() {

    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): FragmentBuild {
            val fragmentHome = FragmentBuild()
            val args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_build, container, false)
    }
}