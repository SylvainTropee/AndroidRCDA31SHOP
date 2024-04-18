package com.example.eni_shop.ui.articlelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.androiddemo.ArticleAdapter
import com.example.eni_shop.R
import com.example.eni_shop.databinding.FragmentListArticleBinding
import com.example.eni_shop.repository.ArticleRepository


class ListArticleFragment : Fragment() {

    lateinit var binding: FragmentListArticleBinding
    lateinit var viewModel : ListArticleViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_article, container, false)

        // Creer un view model et associer à la vue
        viewModel = ListArticleViewModel(requireContext())
        binding.viewModel = viewModel;

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ecoute quand la liste des articles est mise à jour
        viewModel.articles.observe(viewLifecycleOwner, Observer {
            val adapter = ArticleAdapter();
            binding.rvArticle.adapter = adapter;
            adapter.submitList(it)
        })

        // Appel la synchronisation des articles
        viewModel.syncArticles();

        // Le bouton pour voir un article
        binding.buttonToDetail.setOnClickListener {
            // Ouvrir une page avec l'id en parametre
            val direction = ListArticleFragmentDirections.actionListeToDetailArticle(viewModel.articles.value!!.random().id)
            Navigation.findNavController(view).navigate(direction)
        }

    }


}