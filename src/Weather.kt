class Weather(val city: String, val description: String, val temp: Double) {
    override fun toString(): String = "[$city: $description, $temp]"
}