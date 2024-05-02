package com.eotw95.androidutsample

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class WeatherForecastTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun shouldBringUmbrella_givenSunny_returnTrue() {
        val satellite = StubSatellite(Weather.Rainy)
        val weatherForecast = WeatherForecast(satellite)
        val actual = weatherForecast.shouldBringUmbrella()
        assertEquals(true, actual)
    }
}