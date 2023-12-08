package com.example.mylibrary

import data.entities.Portfolio
import data.networking.PortfolioService
import data.repositories.PortfolioImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RepositoryUnitTest {
    @ExperimentalCoroutinesApi
    @Test
    fun testGetPortfolioUser1() = runTest {
        // Mock PortfolioService
        val portfolioService = mock(PortfolioService::class.java)

        // Prepare test data
        val testData1 = Portfolio(
            userId = "123",
            portfolioValue = 15000.0,
            currency = "USD",
            increment = 2.5,
            rate = 1.25
        )

        `when`(portfolioService.fetchPortfolio("123")).thenReturn(flow {
            emit(testData1)
        })

        // Create the repository
        val repository = PortfolioImpl(portfolioService)

        // Collect the flow from the repository
        var collectedPortfolio: Portfolio? = null
        repository.getPortfolio("123").collect {
            collectedPortfolio = it
        }

        assertEquals(testData1, collectedPortfolio)
    }

    @Test
    fun testGetPortfolioUser2() = runTest {
        // Mock PortfolioService
        val portfolioService = mock(PortfolioService::class.java)

        // Prepare test data
        val testData2 = Portfolio(
            userId = "456",
            portfolioValue = 10000.0,
            currency = "AED",
            increment = 3.5,
            rate = 1.50
        )

        val repository = PortfolioImpl(portfolioService)

        `when`(portfolioService.fetchPortfolio("456")).thenReturn(flow {
            emit(testData2)
        })
        // Collect the flow from the repository
        var collectedPortfolio: Portfolio? = null
        repository.getPortfolio("456").collect {
            collectedPortfolio = it
        }
        assertEquals(testData2, collectedPortfolio)
    }
}