package bdg.bdk.kertasguntingbatucomplayer.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import bdg.bdk.kertasguntingbatucomplayer.R
import bdg.bdk.kertasguntingbatucomplayer.adapter.AdapterViewPager2
import bdg.bdk.kertasguntingbatucomplayer.adapter.getNextIndex
import bdg.bdk.kertasguntingbatucomplayer.adapter.getPreviousIndex
import bdg.bdk.kertasguntingbatucomplayer.databinding.ActivityLandingPageBinding
import bdg.bdk.kertasguntingbatucomplayer.databinding.FragmentInputNameBinding
import bdg.bdk.kertasguntingbatucomplayer.model.SliderData
import bdg.bdk.kertasguntingbatucomplayer.ui.inputname.InputNameFragment

import bdg.bdk.kertasguntingbatucomplayer.ui.slider.SliderFragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment
import java.lang.reflect.Array.getInt

class LandingPageActivity : AppIntro2() {

    lateinit var binding: ActivityLandingPageBinding
//    lateinit var bindingInputNameFragment: FragmentInputNameBinding


//    private val pagerAdapter: AdapterViewPager2 by lazy {
//        AdapterViewPager2(supportFragmentManager, lifecycle)
//    }

//    private var listener: OnNameSubmittedListener? = null
//
//    fun setNameSubmittedListener(listener: OnNameSubmittedListener) {
//        this.listener = listener
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityLandingPageBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//
//        bindingInputNameFragment = FragmentInputNameBinding.inflate(layoutInflater)


//        tryViewPager2Manual()

        setupAppIntro()


    }

    private fun setupAppIntro() {
        isSkipButtonEnabled = false
        addSlide(
            SliderFragment.newInstance(
                SliderData(
                    title = getString(R.string.text_landing_page1),
                    imgSlider = R.drawable.landing_page1,
                    name = ""
                )
            )
        )
        addSlide(
            SliderFragment.newInstance(
                SliderData(
                    title = getString(R.string.text_landing_page2),
                    imgSlider = R.drawable.landing_page2,
                    name = ""
                )
            )
        )
        addSlide(
            InputNameFragment.newInstance(
                SliderData(
                    title = getString(R.string.text_landing_page3),
                    imgSlider = R.drawable.landing_page3,
                    name = ""
                )
            )
        )

    }

//    private fun tryViewPager2Manual() {
//        initAdapter()
//        setupViewPager2()
//
//        setOnClickListeners()
//    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if (currentFragment is OnFinishNavigateListener) {
            currentFragment.onFinishNavigateListener()
        }
        finish()

    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        finish()
    }


//
//    private fun initAdapter() {
//        pagerAdapter.apply {
//            addFragment(
//                SliderFragment.newInstance(
//                    SliderData(
//                        title = getString(R.string.text_landing_page1),
//                        imgSlider = R.drawable.landing_page1,
//                        name = ""
//                    )
//                )
//            )
//            addFragment(
//                SliderFragment.newInstance(
//                    SliderData(
//                        title = getString(R.string.text_landing_page2),
//                        imgSlider = R.drawable.landing_page2,
//                        name = ""
//                    )
//                )
//            )
//            addFragment(
//                InputNameFragment.newInstance(
//                    SliderData(
//                        title = getString(R.string.text_landing_page3),
//                        imgSlider = R.drawable.landing_page3,
//                        name = ""
//                    )
//                )
//            )
//
//        }
//    }

//    private fun getMaxIndex(): Int {
//        return pagerAdapter.itemCount - 1
//    }
//
//    private fun setupViewPager2() {
//        binding.vp2LandingPage.apply {
//            adapter = pagerAdapter
//            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    super.onPageSelected(position)
//                    when {
//                        position == 0 -> {
//                            binding.tvNextLandingPage.isInvisible = false
//                            binding.tvNextLandingPage.isEnabled = true
//                            binding.tvPreviousLandingPage.isInvisible = true
//                            binding.tvPreviousLandingPage.isEnabled = false
//                        }
//                        position < getMaxIndex() -> {
//                            binding.tvNextLandingPage.isInvisible = false
//                            binding.tvNextLandingPage.isEnabled = true
//                            binding.tvPreviousLandingPage.isInvisible = false
//                            binding.tvPreviousLandingPage.isEnabled = true
//                        }
//                        position == getMaxIndex() -> {
//                            binding.tvNextLandingPage.isInvisible = true
//                            binding.tvNextLandingPage.isEnabled = false
//                            binding.tvPreviousLandingPage.isInvisible = false
//                            binding.tvPreviousLandingPage.isEnabled = true
//
//
////                            if (bindingInputNameFragment.etInputFragment.text.isEmpty()) {
////                                Toast.makeText(
////                                    this@LandingPageActivity,
////                                    "Type your name please",
////                                    Toast.LENGTH_LONG
////                                ).show()
////                            } else {
////                                val playerName =
////                                    bindingInputNameFragment.etInputFragment.text.toString().trim()
////                                binding.tvNextLandingPage.isEnabled = true
////                                binding.tvNextLandingPage.isVisible = true
////
////                            }
//
//
//                        }
//
//
//                    }
//                }
//            })
//        }
//        binding.dotsIndicatorLandingPage.attachTo(binding.vp2LandingPage)
//    }


//    private fun checkEditText() {
//
//
//

//
//
//
//        if (playerName != null && playerName.isNotEmpty()) {
//            binding.tvNextLandingPage.text = "START"
//            binding.tvNextLandingPage.isEnabled = true
//            binding.tvNextLandingPage.isVisible = true
//
//            listener?.onNameSubmittedListener(playerName)
//            Toast.makeText(
//                this@LandingPageActivity,
//                "$playerName",
//                Toast.LENGTH_LONG
//            ).show()
//
//        } else {
//            Toast.makeText(
//                this@LandingPageActivity,
//                "Type your name please",
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }

//    private fun setOnClickListeners() {
//        binding.tvNextLandingPage.setOnClickListener {
//
//            if (bindingInputNameFragment.etInputFragment.text.isNotEmpty()) {
//                goToMenuActivity()
//
//            } else {
//                goToNextFragment()
//
//            }


//        }
//        binding.tvPreviousLandingPage.setOnClickListener {
//            goToPreviousFragment()
//        }
//
//
//    }
//
//    private fun goToMenuActivity() {
//        val playerName = bindingInputNameFragment.etInputFragment.text.toString().trim()
//        val intent = Intent(this@LandingPageActivity, MenuActivity::class.java)
//        startActivity(intent)
//    }
//
//    private fun goToPreviousFragment() {
//        val nextIndex = binding.vp2LandingPage.getPreviousIndex()
//        if (nextIndex != 1) {
//            binding.vp2LandingPage.setCurrentItem(nextIndex, true)
//        }
//    }

//    private fun goToNextFragment() {
//        val nextIndex = binding.vp2LandingPage.getNextIndex()
//        if (nextIndex != -1) {
//            binding.vp2LandingPage.setCurrentItem(nextIndex, true)
//        }
//    }
}

interface OnFinishNavigateListener {
    fun onFinishNavigateListener()

}