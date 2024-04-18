package com.example.androiddemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ArticleCellBinding
import com.example.eni_shop.ui.articlelist.ListArticleFragmentDirections

class ArticleAdapter : ListAdapter<Article, ArticleAdapter.ViewHolder>(ArticleDiffCallback()) {

    /**
     * Charger le xml/le rendu
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Récupérer la personne
        val article = getItem(position)

        // je l'envoie dans la vue
        holder.bind(article);
    }

    /**
     * Classe Interne (inception)
     * Permet de determiner comment on charge la cellule et faire le lien avec la donnée (donc Article)
     */
    class ViewHolder(val myParent : ViewGroup, val myBinding : ArticleCellBinding) : RecyclerView.ViewHolder(myBinding.root) {

        /**
         * Envoyer une donnée dans la cellule
         */
        fun bind(article: Article){
            myBinding.article = article;
        }

        companion object {
            /**
             * Charger/DataBinder le xml
             */
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ArticleCellBinding.inflate(layoutInflater, parent, false);

                // Ajouter un evenement click listener
                binding.itemView.setOnClickListener {
                    val direction = ListArticleFragmentDirections.actionListeToDetailArticle(binding.article!!.id)
                    Navigation.findNavController(it!!).navigate(direction)
                }

                return ViewHolder(parent, binding);
            }
        }
    }
}