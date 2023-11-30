package data.networking

import data.entities.Portfolio

class PortfolioServiceImpl : PortfolioService {

    // Hardcoded portfolio data for demonstration purposes
    private val hardcodedPortfolio = Portfolio(
        userId = "user123",
        portfolioValue = 15000.0,
        currency = "USD",
        rate = 1.25
    )

    override suspend fun fetchPortfolio(userId: String): Portfolio? {
        // Simulate fetching portfolio by userId (ignoring the provided userId for simplicity)
        return hardcodedPortfolio
    }

    override suspend fun updatePortfolio(portfolio: Portfolio): Boolean {
        // Simulate updating portfolio (dummy implementation always returns true)
        return true
    }
}