package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()


    }

    /**
     * Roll the dice and update the screen with result
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRollOne = dice.roll()
        val diceRollTwo = dice.roll()

        // Find imageView in the layout
        val diceImageOne: ImageView = findViewById(R.id.imageViewOne)
        // Determine which drawable resource ID is to be used for diceRoll
        val drawableResourceOne = when (diceRollOne) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update imageview with correct resource ID
        diceImageOne.setImageResource(drawableResourceOne)
        // Update the content description
        diceImageOne.contentDescription = diceRollOne.toString()

        val diceImageTwo: ImageView = findViewById(R.id.imageViewTwo)
        val drawableResourceTwo = when (diceRollTwo) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImageTwo.setImageResource(drawableResourceTwo)
        diceImageTwo.contentDescription = diceRollTwo.toString()
    }
    // Update the screen with the dice roll
    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}