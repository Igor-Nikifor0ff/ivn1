package com.example.android.ivn1.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.android.ivn1.APP
import com.example.android.ivn1.R
import com.example.android.ivn1.adapter.NoteAdapter
import com.example.android.ivn1.databinding.FragmentStartBinding
import com.example.android.ivn1.model.NoteModel


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        binding.rvNotes.also { recyclerView = it }
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setList(listNotes.asReversed())
        }

        binding.btnNext.setOnClickListener{
            APP!!.navController.navigate(R.id.action_startFragment_to_addNoteFragment)

        }
    }
    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP!!.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }
    }
}