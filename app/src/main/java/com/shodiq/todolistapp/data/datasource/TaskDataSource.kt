package com.shodiq.todolistapp.data.datasource

import com.shodiq.todolistapp.data.model.Task

class TaskDataSource {

    private var tasks = mutableListOf<Task>().apply {
        add(
            Task(
                1,
                "Mencuci Baju",
                "Banyak yang harus dicuci di laundry mpok eti 1",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                true
            )
        )
        add(
            Task(
                2,
                "Mencuci Baju 2",
                "Banyak yang harus dicuci di laundry mpok eti 2",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                true
            )
        )
        add(
            Task(
                3,
                "Mencuci Baju 3",
                "Banyak yang harus dicuci di laundry mpok eti 3",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                true
            )
        )
        add(
            Task(
                4,
                "Mencuci Baju 4",
                "Banyak yang harus dicuci di laundry mpok eti 4",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                false
            )
        )
        add(
            Task(
                5,
                "Mencuci Baju 5",
                "Banyak yang harus dicuci di laundry mpok eti 5",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                false
            )
        )
        add(
            Task(
                6,
                "Mencuci Baju 6",
                "Banyak yang harus dicuci di laundry mpok eti 6",
                "https://image-cdn.medkomtek.com/JWQlRCsCKHDuTFy4VN-CTsnMTBQ=/1200x675/smart/klikdokter-media-buckets/medias/2263302/original/061757600_1530255518-Agar-Tidak-Kram-Otot-Hindari-Ini-Saat-Mencuci-Baju-By-birdbyb-stockphoto-shutterstock.jpg",
                false
            )
        )
    }

    fun add(task: Task) {
        tasks.add(task)
    }

    fun delete(taskId: Int) {
        tasks.remove(tasks.first {
            it.id == taskId
        })
    }

    fun changeTaskStatus(taskId: Int) {
        tasks.first {
            it.id == taskId
        }.apply {
            isTaskCompleted = isTaskCompleted.not()
        }
    }

    fun getData(isTaskCompleted: Boolean): List<Task> {
        return tasks.filter { it.isTaskCompleted == isTaskCompleted }
    }
}