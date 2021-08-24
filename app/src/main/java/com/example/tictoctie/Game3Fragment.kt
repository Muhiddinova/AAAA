package com.example.tictoctie

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProviders
import com.example.tictoctie.databinding.FragmentGameBinding
import com.idrok.dars2.Game3ViewModel
import com.idrok.dars2.GameViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

@Suppress("SameParameterValue")
class Game3Fragment : Fragment() , View.OnClickListener {
    private lateinit var binding:FragmentGameBinding
    private lateinit var viewModel: Game3ViewModel
    private val listButtons = arrayListOf<ArrayList<TextView>>()
    private var isPlayer1 = true
    private var player1 = 0
    private var player2 = 0
    private var listString = arrayListOf<ArrayList<String>>()







    @SuppressLint("SetTextI18n")
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentGameBinding.inflate(inflater, container, false)
        sizeScreen()
        binding.tv00.visibility=View.GONE
        binding.tv33.visibility=View.GONE
        viewModel= ViewModelProviders.of(requireActivity()).get(Game3ViewModel::class.java)
        if (viewModel.getPlayer1().value==null)
            viewModel.setPlayer1(0)
        if (viewModel.getPlayer2().value==null)
            viewModel.setPlayer2(0)
        if (viewModel.getPlayer1().value!=null)
            player1=viewModel.getPlayer1().value!!
        if (viewModel.getPlayer2().value != null)
            player2 = this.viewModel.getPlayer2().value!!

        binding.apply {
            this@Game3Fragment.viewModel.getPlayer1().observe(viewLifecycleOwner, { player1 ->
                this.tvPlayer1.text = "PlayerX: $player1"
            })
            this@Game3Fragment.viewModel.getPlayer2().observe(viewLifecycleOwner, { player2 ->
                tvPlayer2.text = "PlayerO: $player2"
            })
        }
        addButtons()
        getList()
        setOnClick()
        binding.apply {

            btnNewGame.setOnClickListener {
                clearPanel1(false)
            }
            btnExit.setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
        return binding.root}


    private fun sizeScreen(): Float {
        return (Resources.getSystem().displayMetrics.widthPixels / Resources.getSystem()
            .displayMetrics.density)
    }

    private fun getHeight(context: Game3Fragment): Int {
        return context.resources.displayMetrics.heightPixels
    }

    private fun getWidth(context: Game3Fragment): Int {
        return context.resources.displayMetrics.widthPixels
    }


    private fun getList() {


        Log.d("GameFragment", "getList: ${viewModel.getListText()}")
        if (viewModel.getListText().isNotEmpty()) {
            listString = viewModel.getListText()

        } else {
            (0..3).forEach { _ ->
                (0..3).forEach{ _ ->
                    listString.add(arrayListOf("", "", "", ""))
                }}

        }


    }







    private fun setSavedText() {
        (0..3).forEach { i ->
            (0..3).forEach { j ->
                listButtons[i][j].text = listString[i][j]
            }
        }
    }
    private fun setOnClick() {
        (0..3).forEach { position1 ->
            (0..3).forEach { position2 ->
                listButtons[position1][position2].setOnClickListener(this)

            }
        }
    }

    private fun addButtons() {
        binding.apply {
            listButtons.add(arrayListOf(tv00, tv01, tv02, tv03))
            listButtons.add(arrayListOf(tv10, tv11, tv12, tv13))
            listButtons.add(arrayListOf(tv20, tv21, tv22, tv23))
            listButtons.add(arrayListOf(tv30, tv31, tv32, tv33))
        }

    }


    @SuppressLint("SetTextI18n")
    private fun clearPanel(isSomeoneWon: Boolean) {
        isPlayer1 = true
        if (!isSomeoneWon ) {
            (0..3).forEach { position1->
                (0..3).forEach { position2 ->
                    listButtons[position1][position2].text = ""
                    listString[position1][position2]
                }

            }


        } else {
            (0..3).forEach { position1 ->
                (0..3).forEach { position2 ->
                    listButtons[position1][position2].text = ""
                }

            }
        }

        binding.apply {

            tvPlayer1.text = "PlayerX = $player1"
            tvPlayer2.text = "PlayerO = $player2"

        }

        if(player1 > player2){
            val positiveButtonClick = { _: DialogInterface, _: Int ->
                Toast.makeText(
                    context,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
            }

            val builder = AlertDialog.Builder(context)
            with(builder) {
                builder.setTitle("PlayerX = $player1")
                builder.setView(R.layout.fragment_dialog)
                builder.setPositiveButton(
                    "OK",
                    DialogInterface.OnClickListener(positiveButtonClick)
                )

                builder.setPositiveButton(android.R.string.yes) { _, _ ->
                }
                show()
            }
        }
        else {
            val positiveButtonClick = { _: DialogInterface, _: Int ->
                Toast.makeText(
                    context,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
            }

            val builder = AlertDialog.Builder(context)
            with(builder) {
                builder.setTitle("PlayerO = $player2")
                builder.setView(R.layout.fragment_dialog)
                builder.setPositiveButton(
                    "OK",
                    DialogInterface.OnClickListener(positiveButtonClick)
                )

                builder.setPositiveButton(android.R.string.yes) { _, _ ->
                }
                show()

            }}

    }



    private fun clearPanel1(isSomeoneWon: Boolean) {

        isPlayer1 = true
        if (!isSomeoneWon) {
            (0..3).forEach { position1 ->
                (0..3).forEach { position2 ->
                    listButtons[position1][position2].text = ""
                    listString[position1][position2]
                }

            }


        }

        binding.apply {

            tvPlayer1.text = "PlayerX = $player1"
            tvPlayer2.text = "PlayerO = $player2"

        }}

    override fun onClick(view: View?) {
        Log.d("GameFragment", "onClick: ")
        binding.apply {
            when (view) {
                tv00 -> {
                    setText(tv00, 0, 0)
                }
                tv01 -> {
                    setText(tv01, 0, 1)
                }
                tv02 -> {
                    setText(tv02, 0, 2)
                }
                tv03 -> {
                    setText(tv03, 0, 3)
                }
                tv10 -> {
                    setText(tv10, 1, 0)
                }
                tv11 -> {
                    setText(tv11, 1, 1)
                }
                tv12 -> {
                    setText(tv12, 1, 2)
                }
                tv13 -> {
                    setText(tv13, 1, 3)
                }
                tv20 -> {
                    setText(tv20, 2, 0)
                }
                tv21 -> {
                    setText(tv21, 2, 1)
                }
                tv22 -> {
                    setText(tv22, 2, 2)
                }
                tv23 -> {
                    setText(tv23, 2, 3)
                }
                tv30->{
                    setText(tv30,3,0)
                }
                tv31->{
                    setText(tv31,3,1)
                }
                tv32->{
                    setText(tv32,3,2)
                }
                tv33->{
                    setText(tv33,3,3)
                }


            }
        }
    }

    private fun setText(text: TextView, i: Int, j: Int) {
        Log.d("GameFragment", "setText: ")

        if (text.text.isEmpty()) {
            if (isPlayer1) {
                text.text = "x"
                listString[i][j] = "x"
                viewModel.setListText(listString)
                isPlayer1 = false
                checkWin()
            } else {
                text.text = "o"
                listString[i][j] = "o"
                viewModel.setListText(listString)
                isPlayer1 = true
                checkWin()
            }
        }

    }

    private fun checkWin() {


        var scheat1 = 0
        var scheat2 = 0
        var counter = 0


        (0..2).forEach { position1 ->
            (0..2).forEach { position2 ->
                val text = listButtons[position1][position2]
                if (text.text == "x") {
                    scheat1++
                } else if (text.text == "o") {
                    scheat2++
                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (0..2).forEach { position1 ->
            (0..2).forEach { position2 ->
                val text = listButtons[position2][position1]
                if (text.text == "x") {
                    scheat1++
                } else if (text.text == "o") {
                    scheat2++
                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (0..2).forEach { position ->
            val text = listButtons[position][position]
            if (text.text == "x") {
                scheat1++
            } else if (text.text == "o") {
                scheat2++
            }
        }

        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }
            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }

        (0..2).forEach { position1 ->
            (0..2).forEach { position2 ->
                if (position1 + position2 == 2) {
                    val text = listButtons[position1][position2]
                    if (text.text == "x") {
                        scheat1++
                    } else if (text.text == "o") {
                        scheat2++
                    }
                }
            }
        }

        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }
            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }
        /////////////////////////////////////////////


        (1..3).forEach { position1 ->
            (0..2).forEach { position2 ->
                val text = listButtons[position1][position2]
                if (text.text == "x") {
                    scheat1++

                } else if (text.text == "o") {
                    scheat2++

                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (0..2).forEach { position1 ->
            (1..3).forEach { position2 ->
                val text = listButtons[position2][position1]
                if (text.text == "x") {
                    scheat1++
                } else if (text.text == "o") {
                    scheat2++
                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (1..3).forEach { position1 ->
            (0..2).forEach { position2 ->
                if (position1 - 1 == position2) {
                    val text = listButtons[position1][position2]
                    if (text.text == "x") {
                        scheat1++
                    } else if (text.text == "o") {
                        scheat2++
                    }
                }
            }
        }

        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }
            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }

        (1..3).forEach { position1 ->
            (0..2).forEach { position2 ->
                if (position1 + position2 == 3) {
                    val text = listButtons[position1][position2]
                    if (text.text == "x") {
                        scheat1++
                    } else if (text.text == "o") {
                        scheat2++
                    }
                }
            }
        }
        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }

            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }


//////////////////////////////////////////////////////////////////////


        (0..2).forEach { position1 ->
            (1..3).forEach { position2 ->
                val text = listButtons[position1][position2]
                if (text.text == "x") {
                    scheat1++

                } else if (text.text == "o") {
                    scheat2++

                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (1..3).forEach { position1 ->
            (0..2).forEach { position2 ->
                val text = listButtons[position2][position1]
                if (text.text == "x") {
                    scheat1++
                } else if (text.text == "o") {
                    scheat2++
                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (0..2).forEach { position1 ->
            (1..3).forEach { position2 ->
                if (position1 + 1 == position2) {
                    val text = listButtons[position1][position2]
                    if (text.text == "x") {
                        scheat1++
                    } else if (text.text == "o") {
                        scheat2++
                    }
                }
            }
        }

        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }
            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }

        (0..2).forEach { position1 ->
            (1..3).forEach { position2 ->
                if (position1 + position2 == 3) {
                    val text = listButtons[position1][position2]
                    if (text.text == "x") {
                        scheat1++
                    } else if (text.text == "o") {
                        scheat2++
                    }
                }
            }
        }
        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }

            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }

        /////////////////////////////////////////////////////////////




        (1..3).forEach { position1 ->
            (1..3).forEach { position2 ->
                val text = listButtons[position1][position2]
                if (text.text == "x") {
                    scheat1++
                } else if (text.text == "o") {
                    scheat2++
                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (1..3).forEach { position1 ->
            (1..3).forEach { position2 ->
                val text = listButtons[position2][position1]
                if (text.text == "x") {
                    scheat1++
                } else if (text.text == "o") {
                    scheat2++
                }
            }
            when {
                scheat1 == 3 -> {
                    player1++
                    clearPanel(true)
                    return
                }
                scheat2 == 3 -> {
                    player2++
                    clearPanel(true)
                    return
                }
                else -> {
                    scheat1 = 0
                    scheat2 = 0
                }
            }
        }

        (1..3).forEach { position ->
            val text = listButtons[position][position]
            if (text.text == "x") {
                scheat1++
            } else if (text.text == "o") {
                scheat2++
            }
        }

        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }
            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }

        (1..3).forEach { position1 ->
            (1..3).forEach { position2 ->
                if (position1 + position2 == 4) {
                    val text = listButtons[position1][position2]
                    if (text.text == "x") {
                        scheat1++
                    } else if (text.text == "o") {
                        scheat2++
                    }
                }
            }
        }

        when {
            scheat1 == 3 -> {
                player1++
                clearPanel(true)
                return
            }
            scheat2 == 3 -> {
                player2++
                clearPanel(true)
                return
            }
            else -> {
                scheat1 = 0
                scheat2 = 0
            }
        }
        ///////////////////////////////////




        (0..3).forEach { position1 ->
            (0..3).forEach { position2 ->
                if (listButtons[position1][position2].text.isNotEmpty()) {
                    counter++
                }
            }
        }
        if (counter == 14) {

            val positiveButtonClick = { _: DialogInterface, _: Int ->
                Toast.makeText(
                    context,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
            }

            val builder = AlertDialog.Builder(context)
            with(builder) {
                builder.setTitle("There is no winner ")
                builder.setView(R.layout.fragment_defeat)
                builder.setPositiveButton(
                    "OK",
                    DialogInterface.OnClickListener(positiveButtonClick)
                )

                builder.setPositiveButton(android.R.string.yes) { _, _ ->
                }
                show()
            }

            clearPanel1(false)
        }
        else {
            counter = 0
        }

    }

    @Suppress("DEPRECATED_IDENTITY_EQUALS")
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            getWidth(this)
            getHeight(this)
            sizeScreen()
            // Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            getWidth(this)
            getHeight(this)
            sizeScreen()
        }
    }
    override fun onResume() {
        super.onResume()
        requireActivity().apply {
            app_bar.visibility = View.VISIBLE
            toolbar.setNavigationIcon(R.drawable.ic_menu)
            toolbar.setNavigationOnClickListener {
                requireActivity().drawer_layout.openDrawer(GravityCompat.START)
            }
        }

    }




}



