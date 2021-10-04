package com.shodiq.todolistapp.ui.taskform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.shodiq.todolistapp.App
import com.shodiq.todolistapp.R
import com.shodiq.todolistapp.data.model.Task
import com.shodiq.todolistapp.databinding.ActivityMainBinding
import com.shodiq.todolistapp.databinding.ActivityTaskFormBinding
import kotlin.random.Random

class TaskFormActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTaskFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitleActionBar()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btnSaveTask.setOnClickListener {
            saveTodo()
        }
    }
    private fun saveTodo() {
        if (isFormTodoFilled()) {
            val todo = Task(
                Random.nextInt(),
                binding.etTaskName.text.toString(),
                binding.etTaskDesc.text.toString(),
                binding.etTaskHeaderImg.text.toString(),
                false
            )
            (application as App).getDataSource()?.add(todo)
            Toast.makeText(this, "Task Saved!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun isFormTodoFilled(): Boolean {
        val title = binding.etTaskName.text.toString()
        val desc = binding.etTaskDesc.text.toString()
        val imgHeaderUrl = binding.etTaskHeaderImg.text.toString()
        var isFormValid = true

        if(title.isEmpty()){
            isFormValid = false
            binding.tilTaskName.isErrorEnabled = true
            binding.tilTaskName.error = getString(R.string.text_error_field_task_name)
        }else{
            binding.tilTaskName.isErrorEnabled = false
        }

        if(desc.isEmpty()){
            isFormValid = false
            binding.tilTaskDesc.isErrorEnabled = true
            binding.tilTaskDesc.error = getString(R.string.text_error_field_task_desc)
        }else{
            binding.tilTaskDesc.isErrorEnabled = false
        }

        if(imgHeaderUrl.isEmpty()){
            isFormValid = false
            binding.tilTaskHeaderImg.isErrorEnabled = true
            binding.tilTaskHeaderImg.error = getString(R.string.text_error_field_task_header)
        }else{
            binding.tilTaskHeaderImg.isErrorEnabled = false
        }
        return isFormValid
    }

    private fun setTitleActionBar() {
        supportActionBar?.title = getString(R.string.text_title_task_form_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }



}