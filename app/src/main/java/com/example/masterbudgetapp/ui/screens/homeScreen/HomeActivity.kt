package com.example.masterbudgetapp.ui.screens.homeScreen

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var budgetTextView: TextView
    private lateinit var spentTextView: TextView
    private lateinit var remainingTextView: TextView
    private lateinit var transactionRecyclerView: RecyclerView
    private lateinit var refreshButton: Button
    private lateinit var transactionAdapter: TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        budgetTextView = findViewById(R.id.budgetTextView)
        spentTextView = findViewById(R.id.spentTextView)
        remainingTextView = findViewById(R.id.remainingTextView)
        transactionRecyclerView = findViewById(R.id.transactionRecyclerView)
        refreshButton = findViewById(R.id.refreshButton)

        transactionAdapter = TransactionAdapter()
        transactionRecyclerView.layoutManager = LinearLayoutManager(this)
        transactionRecyclerView.adapter = transactionAdapter

        // Observe LiveData
        viewModel.uiState.observe(this) { state ->
            budgetTextView.text = "Budget: R${state.monthlyBudget}"
            spentTextView.text = "Spent: R${state.totalSpent}"
            remainingTextView.text = "Remaining: R${state.remaining}"
            transactionAdapter.submitList(state.transactions)

            state.errorMessage?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }

        refreshButton.setOnClickListener {
            viewModel.refresh()
        }

        viewModel.loadInitialData()
    }
}
