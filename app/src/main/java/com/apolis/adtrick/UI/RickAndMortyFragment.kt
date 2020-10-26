package com.apolis.adtrick.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apolis.adtrick.R
import com.apolis.adtrick.adapters.RickAndMortyAdapter
import com.apolis.adtrick.viewmodel.RickAndMortyViewModel
import kotlinx.android.synthetic.main.fragment_rick_and_morty.*


class RickAndMortyFragment : Fragment() {

    private lateinit var viewModel: RickAndMortyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rick_and_morty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = RickAndMortyViewModel()
        displayCharacters()

    }

    private fun displayCharacters(){
        viewModel.getCharacters().observe(viewLifecycleOwner, Observer {
            val adapter = RickAndMortyAdapter(requireContext(), it.results)
            recycler_view.layoutManager = LinearLayoutManager(requireContext())
            recycler_view.adapter = adapter
        })
    }


}