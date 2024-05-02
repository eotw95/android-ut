package com.eotw95.androidutsample

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class WeatherForecastTest {
    private lateinit var weatherForecast: WeatherForecast
    private lateinit var weatherRecorder: MockWeatherRecord

    @Before
    fun setUp() {
//        val satellite = StubSatellite(Weather.Rainy)
        val satellite = mock<Satellite>(name = "MockSatellite")
        whenever(satellite.getWeather()).thenReturn(Weather.Sunny)
        weatherRecorder = MockWeatherRecord()
        weatherForecast = WeatherForecast(satellite, weatherRecorder)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun shouldBringUmbrella_givenSunny_returnTrue() {
        val actual = weatherForecast.shouldBringUmbrella()
        assertEquals(true, actual)
    }
    @Test
    fun recordCurrentWeather_assertCalled() {
        weatherForecast.recordCurrentWeather()
        assertEquals(true, weatherRecorder.isCalled)
    }
}