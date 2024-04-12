package com.example.eni_shop.ui

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.eni_shop.R
import com.example.eni_shop.databinding.FragmentDetailArticleBinding
import com.squareup.picasso.Picasso


class DetailArticleFragment : Fragment() {

    val args by navArgs<DetailArticleFragmentArgs>()
    lateinit var binding: FragmentDetailArticleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailArticleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article
        binding.article = article
        Picasso.get().load(article.urlImage).into(binding.imageView);

        binding.tvTitle.setOnClickListener {
//            Intent(Intent.ACTION_WEB_SEARCH).also {
//                it.putExtra(SearchManager.QUERY, "eni-shop " + article.titre)
//            }.also {
//                startActivity(it)
//            }
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/search?q=eni-shop+" + article.titre)
            ).also {
                startActivity(it)
            }
        }
    }
}