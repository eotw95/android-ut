package com.eotw95.androidutsample

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class WeatherForecastTest {
    private lateinit var weatherForecast: WeatherForecast
    private lateinit var weatherRecorder: MockWeatherRecord

    @Before
    fun setUp() {
//        val satellite = StubSatellite(Weather.Rainy)
        val satellite = mock<Satellite>(name = "MockSatellite")
//        whenever(satellite.getWeather(any(), any())).thenReturn(Weather.Cloudy)
//        whenever(satellite.getWeather(eq(37.580006),eq(-122.345106))).thenReturn(Weather.Sunny)
//        whenever(satellite.getWeather(eq(37.792872),eq(-122.396915))).thenReturn(Weather.Rainy)
        whenever(satellite.getWeather(any(), any())).thenAnswer { invocation ->
            val latitude = invocation.arguments[0] as Double
            val longitude = invocation.arguments[1] as Double
            if (latitude in 20.424086..45.550999 &&
                longitude in 122.933872..153.980789) return@thenAnswer Weather.Sunny
            else return@thenAnswer Weather.Rainy
        }
//        whenever(satellite.getWeather(0.0, 0.0))
//            .thenThrow(IllegalArgumentException::class.java)
        weatherRecorder = mock(name = "MockRecorder")
        weatherForecast = WeatherForecast(satellite, weatherRecorder)
    }

    @After
    fun tearDown() {
    }

//    @Test
//    fun shouldBringUmbrella_givenSunny_returnTrue() {
//        val actual = weatherForecast.shouldBringUmbrella()
//        assertEquals(true, actual)
//    }
    @Test
    fun recordCurrentWeather_assertCalled() {
        weatherForecast.recordCurrentWeather()
        assertEquals(true, weatherRecorder.isCalled)
    }
    @Test
    fun recordCurrentWeather_verifyCalled_record() {
        weatherForecast.recordCurrentWeather()
        verify(weatherRecorder, times(1)).record(eq(Weather.Rainy))
    }
    @Test
    fun shouldBringUmbrella_givenInJapan_returnFalse() {
        val actual = weatherForecast.shouldBringUmbrella(35.669784, 139.817728)
        assertEquals(false, actual)
    }
    @Test
    fun shouldBringUmbrella_givenBurlingame_returnsTrue() {
        val actual = weatherForecast.shouldBringUmbrella(37.580006,-122.345106)
        assertEquals(true, actual)
    }
    @Test(expected = IllegalArgumentException::class)
    fun shouldBringUmbrella_givenZero_returnsException() {
        val actual = weatherForecast.shouldBringUmbrella(0.0, 0.0)
    }
}