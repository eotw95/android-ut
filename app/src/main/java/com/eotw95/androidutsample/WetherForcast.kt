package com.eotw95.androidutsample

class WeatherForecast(
    private val satellite: Satellite,
    private val weatherRecorder: WeatherRecorder
) {
    fun shouldBringUmbrella(): Boolean {
        return when (satellite.getWeather()) {
            Weather.Sunny, Weather.Cloudy -> false
            Weather.Rainy -> true
        }
    }
    fun recordCurrentWeather() {
        weatherRecorder.record(satellite.getWeather())
    }
}

open class Satellite {
    open fun getWeather(): Weather {
        // 何かしらの実装がある想定で、仮でSunnyを返すようにしている
        return Weather.Sunny
    }
}
open class WeatherRecorder() {
    val weather: Weather? = null
    open fun record(weather: Weather) {
        // 何かしらの実装がある想定
    }
}

enum class Weather {
    Sunny,
    Cloudy,
    Rainy
}

/**
 *  以下はテスト用のスタブクラス
 *  スタブクラス作るためにオリジナルのclassのアクセス修飾子をopenに変更しているので、良くない
 */
class StubSatellite(private val weather: Weather): Satellite() {
    override fun getWeather(): Weather {
        return weather
    }
}
/**
 *  以下はテスト用のモッククラス
 */
class MockWeatherRecord(): WeatherRecorder() {
    var isCalled = false

    override fun record(weather: Weather) {
        isCalled = true
    }
}