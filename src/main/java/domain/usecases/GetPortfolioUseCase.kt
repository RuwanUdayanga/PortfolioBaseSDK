package domain.usecases

import data.entities.Portfolio
import data.repositories.PortfolioRepository

class GetPortfolioUseCase(private val portfolioRepository: PortfolioRepository) {

    // Method to fetch portfolio data for a specific user
    suspend operator fun invoke(userId: String): Portfolio? {
        return portfolioRepository.getPortfolio(userId)
    }
}