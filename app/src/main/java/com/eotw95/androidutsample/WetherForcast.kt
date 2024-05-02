package com.eotw95.androidutsample

class WeatherForecast(private val satellite: Satellite) {
    fun shouldBringUmbrella(): Boolean {
        return when (satellite.getWeather()) {
            Weather.Sunny, Weather.Cloudy -> false
            Weather.Rainy -> true
        }
    }
}

open class Satellite {
    open fun getWeather(): Weather {
        // 何かしらの実装がある想定で、仮でSunnyを返すようにしている
        return Weather.Sunny
    }
}

enum class Weather {
    Sunny,
    Cloudy,
    Rainy
}

/**
 *  以下はテスト用のスタブクラス
 */
class StubSatellite(private val weather: Weather): Satellite() {
    override fun getWeather(): Weather {
        return weather
    }
}