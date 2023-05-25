package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity è la classe principale dell'applicazione.
 * Estende AppCompatActivity per fornire funzionalità di base.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Il metodo onCreate viene chiamato quando l'attività viene creata.
     * Inizializza l'interfaccia utente e imposta il listener del pulsante di lancio.
     *
     * @param savedInstanceState L'istanza di Bundle contenente lo stato precedente dell'attività.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ottieni il riferimento al pulsante di lancio dall'interfaccia utente
        val rollButton: Button = findViewById(R.id.button)
        val rollButton2: Button = findViewById(R.id.button2)

        rollDice(6,R.id.label_dice,R.id.imageView)
        rollDice(6,R.id.label_dice2,R.id.imageView2 )

        // Imposta il listener per il pulsante di lancio
        rollButton.setOnClickListener {
            rollDice(6,R.id.label_dice,R.id.imageView)
        }
        rollButton2.setOnClickListener {
            rollDice(6,R.id.label_dice2,R.id.imageView2 )
        }
    }

    /**
     * rollDice genera un valore casuale simulando il lancio di un dado e lo visualizza nella TextView.
     */
    private fun rollDice(number: Int, idLabel: Int,idImage :Int) {
        // Crea un oggetto Dice con il numero di facce specificato
        val dice = Dice(number)

        // Esegue il lancio del dado
        val diceRoll = dice.roll()


        // Ottieni il riferimento alla TextView per il risultato del lancio
        val resultTextView: TextView = findViewById(idLabel)


        // Imposta il risultato del lancio nella TextView
        resultTextView.text = diceRoll.toString()


        val diceImage: ImageView = findViewById(idImage)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)

        }
    }


    /**
     * Dice è una classe interna che rappresenta un dado con un numero specificato di facce.
     */
    private class Dice(private val numSides: Int) {

        /**
         * roll genera un valore casuale simulando il lancio del dado.
         *
         * @return Il valore casuale ottenuto dal lancio del dado.
         */
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}
