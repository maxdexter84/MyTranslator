package ru.maxdexter.mytranslator.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.maxdexter.mytranslator.R
import ru.maxdexter.mytranslator.databinding.FragmentBottomSheetBinding


class BottomSheetFragment : BottomSheetDialogFragment() {
        var onClickListener: ((String) -> Unit)? = null

        fun setClickListener(listener: ((String) -> Unit)){
            onClickListener = listener
        }


    lateinit var binding: FragmentBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bottom_sheet, container, false)
        binding.etSearch.addTextChangedListener(textWatcher)




        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = BottomSheetFragment()
    }

    var textWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
            if (s != null) {
                if (s.length >= 2){
                    onClickListener?.invoke(s.toString())
                }
            }
        }
    }


}