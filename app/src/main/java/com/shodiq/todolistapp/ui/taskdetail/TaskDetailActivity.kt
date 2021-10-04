package com.shodiq.todolistapp.ui.taskdetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.shodiq.todolistapp.App
import com.shodiq.todolistapp.R
import com.shodiq.todolistapp.data.model.Task
import com.shodiq.todolistapp.databinding.ActivityTaskDetailBinding
import com.shodiq.todolistapp.utils.ShareUtils

class TaskDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskDetailBinding
    private lateinit var taskData: Task

    companion object {
        const val EXTRAS_TASK_DATA = "EXTRAS_TASK_DATA"

        @JvmStatic
        fun startActivity(context: Context?, task: Task) {
            val intent = Intent(context, TaskDetailActivity::class.java)
            intent.putExtra(EXTRAS_TASK_DATA, task)
            context?.startActivity(intent)
        }
    }

    private fun getIntentData() {
        intent.extras?.getParcelable<Task>(EXTRAS_TASK_DATA)?.let {
            taskData = it
        }
    }

    override fun onStart() {
        super.onStart()
        getIntentData()
        bindData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun bindData() {
        supportActionBar?.hide()
        binding.tvTitleTask.text = taskData.title
        binding.tvDescTask.text = taskData.desc
        Glide.with(this)
            .load(taskData.imgHeaderUrl)
            .centerCrop()
            .placeholder(R.drawable.img_placeholder)
            .into(binding.ivHeaderTask)
        setFabIcon(taskData.isTaskCompleted)
        binding.fab.setOnClickListener {
            setTaskCompleteStatus()
        }
        binding.ivShare.setOnClickListener {
            ShareUtils.shareText(
                this,
                "Task Title : ${taskData.title} \n Task Desc : ${taskData.desc}"
            )
        }

    }

    private fun setTaskCompleteStatus() {
        (application as App).getDataSource()?.changeTaskStatus(taskData.id)
        taskData = taskData.apply {
            isTaskCompleted = !isTaskCompleted
        }
        setFabIcon(taskData.isTaskCompleted)
        if (taskData.isTaskCompleted) {
            Toast.makeText(this, "Success set Task to Done!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Success set Task to Not Done!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setFabIcon(isTaskComplete: Boolean) {
        binding.fab.setImageResource(
            if (isTaskComplete)
                R.drawable.ic_task_done_true
            else
                R.drawable.ic_task_done_false
        )
    }


}