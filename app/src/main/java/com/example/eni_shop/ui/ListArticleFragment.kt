package com.example.eni_shop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.eni_shop.R
import com.example.eni_shop.databinding.FragmentListArticleBinding
import com.example.eni_shop.repository.ArticleRepository


class ListArticleFragment : Fragment() {

    lateinit var binding: FragmentListArticleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_article, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articles = ArticleRepository.getAllArticles()

        articles.forEach {
            val tv = TextView(context)
            tv.text = it.titre
            binding.llListeArticles.addView(tv)
        }

        binding.buttonToDetail.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.actionListeToDetailArticle)
        }
    }


}