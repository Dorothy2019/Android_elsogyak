package hu.bme.aut.android.tictactoe.model

import java.lang.Boolean.TRUE

object TicTacToeModel {

    const val EMPTY: Byte = 0
    const val CIRCLE: Byte = 1
    const val CROSS: Byte = 2

    var nextPlayer: Byte = CIRCLE

    private var model: Array<ByteArray> = arrayOf(
            byteArrayOf(EMPTY, EMPTY, EMPTY),
            byteArrayOf(EMPTY, EMPTY, EMPTY),
            byteArrayOf(EMPTY, EMPTY, EMPTY))

    fun resetModel() {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                model[i][j] = EMPTY
            }
        }
    }

    fun getFieldContent(x: Int, y: Int) = model[x][y]

    fun changeNextPlayer() {
        if (nextPlayer == CIRCLE) {
            nextPlayer = CROSS
        } else {
            nextPlayer = CIRCLE
        }
    }

    fun setFieldContent(x: Int, y: Int, content: Byte): Byte {
        changeNextPlayer()
        model[x][y] = content
        return content
    }

    fun endGame():Boolean {
        var winner: Boolean = false

        if(model.isNotEmpty() && winner != true) {
            // sor ellenőrzése
            for (i in 0 until 3 ) {
                if(winner == true)
                    break
                if(model[i][0] == model[i][1] && 1.toByte() == model[i][2])
                    winner = true
                if(model[i][0] == model[i][1] && 2.toByte() == model[i][2])
                    winner = true

            }
            // oszlop ellenőrzése
            for (j in 0 until 3) {
                if(winner==true)
                    break
                if(model[0][j] == model[1][j] && 1.toByte() == model[2][j])
                    winner= true
                if(model[0][j] == model[1][j] && 2.toByte() == model[2][j])
                    winner= true
            }
            // a két átlós irány ellenőrzése
            if (model[0][0] == model[1][1] && 1.toByte()  == model[2][2]) {
                winner = true
            }
            if (model[0][0] == model[1][1] && 2.toByte()  == model[2][2]) {
                winner = true
            }
            if (model[0][2] == model[1][1] && 1.toByte() == model[2][0]) {
                winner = true
            }
            if (model[0][2] == model[1][1] && 2.toByte() == model[2][0]) {
                winner = true
            }
        }
        return winner
    }

}