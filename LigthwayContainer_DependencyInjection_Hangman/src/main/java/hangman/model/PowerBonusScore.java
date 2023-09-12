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
        
        puntaje += Math.pow(5, correctCount);
        puntaje -= incorrectCount*8;
        if(puntaje >=500) return 500;
        if(puntaje< 0) return 0;
        return puntaje;
    }

    public int reset(){
        puntaje = 0;
        return puntaje;
     }
    
}
