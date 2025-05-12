package com.example.masterbudgetapp.ui.screens.homeScreen

class HomeViewModel @Inject constructor(
    private val repository: BudgetRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    init {
        loadBudgetData()
        loadTransactions()
    }

    private fun loadBudgetData() {
        viewModelScope.launch {
            val budget = repository.getMonthlyBudget()
            val spent = repository.getTotalSpent()
            uiState = uiState.copy(
                monthlyBudget = budget,
                totalSpent = spent,
                remaining = budget - spent
            )
        }
    }

    private fun loadTransactions() {
        viewModelScope.launch {
            val transactions = repository.getRecentTransactions()
            uiState = uiState.copy(transactions = transactions)
        }
    }

    fun refresh() {
        loadBudgetData()
        loadTransactions()
    }

    fun onErrorShown() {
        uiState = uiState.copy(errorMessage = null)
    }
}
