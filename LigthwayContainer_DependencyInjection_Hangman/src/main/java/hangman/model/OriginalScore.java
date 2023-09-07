package hangman.model;

public class OriginalScore implements GameScore{
    private int puntaje = 100;
    /**
     * @pre Posee 100 puntos
     * @pos Puede acabar minimo con 0 puntos
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        puntaje -= incorrectCount*10;

        return puntaje<0 ? 0 : puntaje;
     }
    
}
