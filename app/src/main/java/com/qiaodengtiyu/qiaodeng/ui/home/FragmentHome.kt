package com.qiaodengtiyu.qiaodeng.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.anshdeep.qiaodeng.R
import com.qiaodengtiyu.qiaodeng.ui.home.index.FragmentIndex
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @author hfy
 * @date 2019/10/23 19:43
 */
class FragmentHome : Fragment() {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionPagerAdapter = DemoCollectionPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = demoCollectionPagerAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
        (activity as AppCompatActivity).setSupportActionBar(toolbar as Toolbar)
    }
}

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int  = 3

    override fun getItem(i: Int): Fragment {

        val fragment = DemoObjectFragment()
//        fragment.arguments = Bundle().apply {
//            // Our object is just an integer :-P
//            putInt(ARG_OBJECT, i + 1)
//        }
//        return fragment
         when(i){
            0->{
                    return FragmentIndex()
                }
            1->fragment.arguments=Bundle().apply {  putInt(ARG_OBJECT, 2)}
            2->fragment.arguments=Bundle().apply {  putInt(ARG_OBJECT, 3)}
            else ->fragment.arguments=Bundle().apply {  putInt(ARG_OBJECT, 1)}
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {

//        return "OBJECT ${(position + 1)}"
        return when(position){
            0->"附近"
            1->"所有"
            2->"我的"
            else ->"附近"
        }
    }
}

private const val ARG_OBJECT = "object"

// Instances of this class are fragments representing a single
// object in our collection.
class DemoObjectFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_foo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView: TextView = view.findViewById(R.id.textView1)
            textView.text = getInt(ARG_OBJECT).toString()
        }
    }
}