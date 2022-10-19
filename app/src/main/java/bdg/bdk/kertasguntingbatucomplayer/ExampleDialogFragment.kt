package bdg.bdk.kertasguntingbatucomplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.DialogFragment
import bdg.bdk.kertasguntingbatucomplayer.databinding.FragmentExampleDialogBinding



class ExampleDialogFragment() : DialogFragment() {
    lateinit var name: String

    private lateinit var bindingDialog : FragmentExampleDialogBinding



    //Secondary Constructor untuk menangani jika DialogFragment membutuhkan data custom
    constructor(name: String):this(){
        this.name = name
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingDialog = FragmentExampleDialogBinding.inflate(layoutInflater,container, false)

        return inflater.inflate(R.layout.fragment_dialog, container, false)
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //Cek apakah variable name sudah diinisialisasi?
        if(this::name.isInitialized){

//            tvHello.text = name
        }

//        bindingDialog.btnTutup.setOnClickListener {
//            Toast.makeText(activity,"DialogFragment Ditutup dari dalam fragment",Toast.LENGTH_LONG).show()
//            dialog?.dismiss()
//        }
    }
}



//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//
//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [ExampleDialogFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
//class ExampleDialogFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_example_dialog, container, false)
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment ExampleDialogFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            ExampleDialogFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}