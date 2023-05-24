package com.example.diceroller

import android.os.Bundle
import android.widget.Button
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

        // Imposta il listener per il pulsante di lancio
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    /**
     * rollDice genera un valore casuale simulando il lancio di un dado e lo visualizza nella TextView.
     */
    private fun rollDice() {
        // Crea un oggetto Dice con il numero di facce specificato
        val dice = Dice(6)

        // Esegue il lancio del dado
        val diceRoll = dice.roll()

        // Ottieni il riferimento alla TextView per il risultato del lancio
        val resultTextView: TextView = findViewById(R.id.label_dice)

        // Imposta il risultato del lancio nella TextView
        resultTextView.text = diceRoll.toString()
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
