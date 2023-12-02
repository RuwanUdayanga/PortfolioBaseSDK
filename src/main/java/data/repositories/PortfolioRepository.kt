package data.repositories

import data.entities.Portfolio

interface PortfolioRepository {
    suspend fun getPortfolio(userId: String): Portfolio
    suspend fun updatePortfolio(portfolio: Portfolio): Boolean
}