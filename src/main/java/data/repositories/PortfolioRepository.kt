package data.repositories

import data.entities.Portfolio
import kotlinx.coroutines.flow.Flow

interface PortfolioRepository {
    fun getPortfolio(userId: String): Flow<Portfolio>
    suspend fun updatePortfolio(portfolio: Portfolio): Boolean
}