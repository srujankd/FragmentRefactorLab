package edu.temple.fragmentrefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GreetingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GreetingFragment : Fragment() {

    private var lastGreeting: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_greeting, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dispTextView = view.findViewById<TextView>(R.id.displayTextView)
        val nameEditText = view.findViewById<EditText>(R.id.nameEditText)
        val changeBtn = view.findViewById<Button>(R.id.changeButton)

        // preserve or restore that old name if there is one
        lastGreeting = savedInstanceState?.getString("lastGreeting")
        lastGreeting?.let {
            dispTextView.text = it
        }


        changeBtn.setOnClickListener {
            val name = nameEditText.text.toString()
            var text = ""
            if (name.isNotBlank()) {
                text = "Hello, $name!"
            } else {
                text = "Please enter your name"
            }
            dispTextView.text = text
            lastGreeting = text
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("lastGreeting", lastGreeting)
    }

}