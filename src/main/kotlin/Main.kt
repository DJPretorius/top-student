import java.io.File

fun main(args: Array<String>) {
    val inputFileName = args[0]
    val outputFileName = args[1]

    val students: List<Student> = File(inputFileName).useLines {
        it.toList()
    }.map {
        val parts = it.split(",")
        Student(parts[0], parts[1], parts[2].toInt())
    }

    val sortedStudents = students.sortedBy { it.score }.reversed()

    val highestScore = sortedStudents.first().score

    val highestScorers = sortedStudents.filter {
         it.score == highestScore
    }

    File(outputFileName).printWriter().use { out ->
        highestScorers.forEach {
            out.println("${it.firstName} ${it.lastName}")
        }
    }

    println("Done")
}