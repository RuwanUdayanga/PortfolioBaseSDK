package data.networking

import data.entities.Portfolio
import kotlinx.coroutines.flow.Flow

interface PortfolioService {
    fun fetchPortfolio(userId: String): Flow<Portfolio>
    suspend fun updatePortfolio(portfolio: Portfolio): Boolean
}