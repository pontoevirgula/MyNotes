package com.chslcompany.mynotes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chslcompany.mynotes.database.NoteEntity
import com.chslcompany.mynotes.databinding.ActivityMainBinding
import com.chslcompany.mynotes.databinding.ContentMainBinding
import com.chslcompany.mynotes.repository.NoteRepositoryImpl
import com.chslcompany.mynotes.util.ViewModelFactory
import com.chslcompany.mynotes.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private var _bindingRecycler: ContentMainBinding? = null
    private val binding get() = _binding
    private val bindingRecycler get() = _bindingRecycler

    private lateinit var linearLayoutManager : LinearLayoutManager
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var mainViewModel: MainViewModel

    private val noteList : MutableList<NoteEntity> = mutableListOf()

    private val noteAdapter : NoteAdapter by lazy {
        NoteAdapter(this, noteList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        _bindingRecycler = binding?.contentMain
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding?.fab?.setOnClickListener {
            startActivity(Intent(this,EditorActivity::class.java))
        }

        initViewModel()

        initRecyclerView()
    }

    private fun initViewModel() {
        mainViewModel =  ViewModelProvider(this,
            ViewModelFactory(NoteRepositoryImpl()))[MainViewModel::class.java]
        noteList.addAll(mainViewModel.getNotesViewModel())
        for(note in noteList){
            Log.i(NOTE,note.toString())
        }
    }

    private fun initRecyclerView(){
        linearLayoutManager = LinearLayoutManager(this)
        bindingRecycler?.rvNotes?.layoutManager = linearLayoutManager
        bindingRecycler?.rvNotes?.adapter = noteAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        _bindingRecycler = null
    }

    companion object{
        private const val NOTE = "ANOTAÇÃO"
    }
}
