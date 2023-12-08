package data.networking

import data.entities.Portfolio
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PortfolioServiceImpl : PortfolioService {

    // Hardcoded portfolio data for demonstration purposes
    private val hardcodedPortfolio1 = Portfolio(
        userId = "123",
        portfolioValue = 15000.00,
        currency = "AED",
        increment = 2.50,
        rate = 1.25
    )
    private val hardcodedPortfolio2 = Portfolio(
        userId = "456",
        portfolioValue = 25000.00,
        currency = "AED",
        increment = 3.50,
        rate = 2.50
    )
    private val hardcodedPortfolioInvalid = Portfolio(
        userId = "null",
        portfolioValue = 0.00,
        currency = "___",
        increment = 0.00,
        rate = 0.00
    )
    override fun fetchPortfolio(userId: String): Flow<Portfolio> = flow {

        // Simulate checking process
        when (userId) {
            "123" -> emit(hardcodedPortfolio1)
            "456" -> emit(hardcodedPortfolio2)
            else -> emit(hardcodedPortfolioInvalid)
        }
        // Simulate update
        while(userId == "123"){
            delay(2000)
            emit(hardcodedPortfolio1)
            delay(2000)
            emit(hardcodedPortfolio2)
        }
    }

    override suspend fun updatePortfolio(portfolio: Portfolio): Boolean {
        // Simulate updating portfolio (dummy implementation always returns true)
        return true
    }
}