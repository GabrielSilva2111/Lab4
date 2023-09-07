package hangman.model;

public class OriginalScore implements GameScore{

    /**
     * @pre Posee 100 puntos
     * @pos Puede acabar minimo con 0 puntos
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        int puntaje = 100;
        for(int i = 0 ; incorrectCount>= 10; i++){
            puntaje -= 10;
        }
        return puntaje;
     }
    
}
