package com.example.eni_shop.ui

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.eni_shop.R
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.FragmentDetailArticleBinding
import com.squareup.picasso.Picasso


class DetailArticleFragment : Fragment() {

    val args by navArgs<DetailArticleFragmentArgs>()
    lateinit var binding: FragmentDetailArticleBinding
    lateinit var viewModel: DetailArticleViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Instancier le view model
        viewModel = DetailArticleViewModel(requireContext())

        // Inflate the layout for this fragment
        binding = FragmentDetailArticleBinding.inflate(layoutInflater)

        // IMPORTANT : Article affiché dans le XML
        // Attention il est null/vide pour l'instant
        binding.article = Article();

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ecouter quand l'article a été récupéré
        viewModel.article.observe(viewLifecycleOwner, Observer { article ->
            binding.article = article
            // Picasso.get().load(article.urlImage).into(binding.imageView);

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
        });

        // Récupérer l'id envoyé pendant la navigation
        val id = args.id;

        // Enclancher l'appel API
        viewModel.requestArticle(id);
    }
}