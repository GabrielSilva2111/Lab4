package hangman.model;

public class BonusScore implements GameScore {
    int puntaje = 0;
     /**
     * @pre Posee 0 puntos
     * @pos Puede acabar minimo con 0 puntos, se penaliza con 5 puntos y bonifica con 10
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        int puntajeActual;
        puntajeActual = correctCount * 10  - incorrectCount * 5 ;
        return puntajeActual < 0 ? 0 : puntajeActual;
    }

    
}
