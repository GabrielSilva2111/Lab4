package hangman.model;

public class PowerBonusScore implements GameScore {
    int puntaje = 0;
     /**
     * @pre Posee 0 puntos
     * @pos Puede acabar minimo con 0 puntos o maximo 500, se penaliza con 5 puntos y bonifica con 10
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        if (correctCount == 0){
            return 0;
        }
        int puntajeActual = puntaje;
        puntajeActual += Math.pow(5, correctCount);
        puntajeActual  -= incorrectCount*8;
        if(puntajeActual > 500) return 500;
        if(puntajeActual< 0) return 0;
        return puntajeActual;
    }


    
}
