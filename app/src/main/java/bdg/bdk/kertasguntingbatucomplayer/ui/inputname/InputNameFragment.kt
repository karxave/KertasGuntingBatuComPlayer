package bdg.bdk.kertasguntingbatucomplayer.ui.inputname

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import bdg.bdk.kertasguntingbatucomplayer.databinding.FragmentInputNameBinding
import bdg.bdk.kertasguntingbatucomplayer.model.SliderData
import bdg.bdk.kertasguntingbatucomplayer.ui.MenuActivity
import bdg.bdk.kertasguntingbatucomplayer.ui.OnFinishNavigateListener

class InputNameFragment : Fragment(), OnFinishNavigateListener {

    private lateinit var binding: FragmentInputNameBinding
//    private lateinit var bindingStart: LandingPageActivity

    private var listener: SetNameInputListener? = null

    fun setNameInputListener(listener: SetNameInputListener) {
        this.listener = listener
    }

    private var sliderData: SliderData? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputNameBinding.inflate(layoutInflater, container, false)
//        bindingStart = LandingPageActivity()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindSliderData()
        setOnClickListener()

    }

    private fun bindSliderData() {
        with(binding) {

            tvInputFragment.text = sliderData?.title.orEmpty()

            etInputFragment.setText(sliderData?.name)

            sliderData?.let { ivInputFragment.setImageResource(it.imgSlider) }


        }
    }

    private fun setOnClickListener() {

        val name = binding.etInputFragment.text.toString().trim()



        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Type your name", Toast.LENGTH_LONG).show()

        } else {

            Toast.makeText(requireContext(), "Name123 : $name", Toast.LENGTH_LONG).show()




//            bindingStart.binding.tvNextLandingPage.isInvisible = false
//            bindingStart.binding.tvNextLandingPage.isEnabled = false
//            bindingStart.binding.tvNextLandingPage.text = "START"
//            goToMenu(name)
        }

    }

    private fun goToMenu(name: String) {
        Toast.makeText(requireContext(), "Name : $name", Toast.LENGTH_LONG).show()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            sliderData = it.getParcelable(ARG_SLIDER_DATA)
        }
    }

    companion object {
        private const val ARG_SLIDER_DATA = "ARG_SLIDER_DATA"
//        private const val EXTRAS_NAME = "EXTRAS NAME"

        @JvmStatic
        fun newInstance(sliderData: SliderData) =
            InputNameFragment().apply {
                arguments = Bundle().apply {

                    putParcelable(ARG_SLIDER_DATA, sliderData)
                }
            }
    }

    override fun onFinishNavigateListener() {
        val name = binding.etInputFragment.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Type your name abc", Toast.LENGTH_LONG).show()
        } else {
            goToMenuActivity(name)




        }
    }

    private fun goToMenuActivity(name: String) {

//        Toast.makeText(requireContext(), " your name : $name", Toast.LENGTH_LONG).show()

        val intent = Intent(requireContext(), MenuActivity::class.java)
        intent.putExtra("databaru", name)
        startActivity(intent)




    }

}

interface SetNameInputListener {
    fun setNameInputListener(name: String)
}