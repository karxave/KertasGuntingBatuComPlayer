package bdg.bdk.kertasguntingbatucomplayer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager2(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList: MutableList<Fragment> = mutableListOf()
    private val fragmentTitleList: MutableList<Fragment> = mutableListOf()

    fun addFragment(fragment: Fragment, title: String = "") {
        if (fragment.isAdded && fragmentList.contains(fragment)) {
            return
        }
        fragmentList.add(fragment)
//        fragmentTitleList.add(title)

    }


    override fun getItemCount(): Int {
        return fragmentList.size

    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun getpageTitle(position: Int) : String {
        return fragmentTitleList[position].toString()
    }



}


//
//class AdapterViewPager2 (fa: FragmentActivity, private val dataFragments : MutableList<Fragment>) : FragmentStateAdapter(fa) {
//
//    // tujuannya setting berapa banyak fragment yang mau ditampilkan
//
//    override fun getItemCount(): Int = dataFragments.size
//
//    // tujuannya membuat fragment by position of index fragment, index pake []
//    override fun createFragment(position: Int): Fragment = dataFragments[position]
//}