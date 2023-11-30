package domain.usecases

import data.entities.Portfolio
import data.repositories.PortfolioRepository

class UpdatePortfolioUseCase(private val portfolioRepository: PortfolioRepository) {

    // Method to update portfolio data
    suspend operator fun invoke(portfolio: Portfolio): Boolean {
        return portfolioRepository.updatePortfolio(portfolio)
    }
}