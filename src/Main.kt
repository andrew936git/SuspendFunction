import kotlin.random.Random
import kotlinx.coroutines.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() = coroutineScope{
    val random = Random
    val array = (1..10).map { random.nextInt(0, 100) }
    val weather = listOf(
        Weather("Москва", "дождь", 21.5),
        Weather("Санкт-Петербург", "пасмурно", 24.0),
        Weather("Екатеринбург", "дождь", 15.3),
        Weather("Магнитогорск", "ливень", 16.1),
        Weather("Сочи", "ясно", 31.7)
    )
    val person = listOf(
        Person("Андрей", 34),
        Person("Евгения", 14),
        Person("Николай", 26),
        Person("Мария", 41),
        Person("Екатерина", 30),
        Person("Анастасия", 11),
        Person("Павел", 58),
        Person("Константин", 17),
    )

    val tasks = listOf(
        launch { getServerData(array) },
        launch { getServerData(person) },
        launch { getServerData(weather) }
    )
    tasks.joinAll()
    println("Данные загружены")
    array.forEach { i -> print("$i ") }
    println()
    person.forEach { i -> print("$i ") }
    println()
    weather.forEach { i -> print("$i ") }
    println()
    println("Программа завершена")

}
private suspend fun <T> getServerData(value: List<T>){

    for (i in value){
        delay(1000L)
        println("Загружено: $i")
    }
}