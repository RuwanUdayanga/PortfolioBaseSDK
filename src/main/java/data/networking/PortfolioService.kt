package data.networking

import data.entities.Portfolio

interface PortfolioService {
    suspend fun fetchPortfolio(userId: String): Portfolio
    suspend fun updatePortfolio(portfolio: Portfolio): Boolean
}