package com.shodiq.todolistapp.ui.about

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.shodiq.todolistapp.R
import com.shodiq.todolistapp.databinding.FragmentAboutDialogBinding

class AboutDialogFragment : DialogFragment() {
    private lateinit var binding : FragmentAboutDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutDialogBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindsViews()
    }

    private fun bindsViews() {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        context?.let {
            Glide.with(it)
                .load("https://statics.indozone.news/content/2021/07/19/gmsEZ6r/varian-baru-seorang-ahli-bedah-di-tiongkok-meninggal-akibat-terpapar-virus-monkey-b87_700.jpg")
                .circleCrop()
                .into(binding.ivImageProfile)
        }
        binding.btnRedirectGithub.setOnClickListener {
            val intent = Intent(Intent. ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/Shodiqq")
            startActivity(intent)
        }
    }
}