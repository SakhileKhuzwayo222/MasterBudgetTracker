package com.example.masterbudgetapp.ui.screens.achievementsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masterbudgetapp.R
import com.example.masterbudgetapp.R.drawable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AchievementsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AchievementsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.achievementsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        //define achievements
        val achievements = listOf(
            Achievement("Saved \$1000", "You’ve reached your first \$1000!", drawable.ic_rewards_1, true),
            Achievement("No Spend Week", "A full week without spending.", drawable.ic_rewards_1, false),
            Achievement("Save More", "Saved R500 this month",drawable.ic_rewards_1, 80, false),
            Achievement("Budget Master", "Stuck to your budget for 30 days", drawable.ic_rewards_1, 100, true),
            Achievement("Expense Tracker", "Logged expenses for a week", drawable.ic_rewards_1, 60, false)
        )

        recyclerView.adapter = AchievementAdapter(achievements)
    }

    private fun Achievement(
        string: String,
        string: String,
        i: Int,
        bool: Boolean
    ) {
    }
}
