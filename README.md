# LAB04
# Integrantes
- Santiago Nicolas Parra Giraldo
- Gabriel Alejandro Silva Lozada

# parte I
1. Clonar el proyecto de la guía del laboratorio del codigo para el haciendo uso del comando ```git clone < https://github.com/GabrielSilva2111/Lab4.git > ```
2. Se realiza la implementación de los cascarones de cada una de las clases con sus respectivas especificicación
- GameScore
```  
package hangman.model;

public interface GameScore {
    
     public int calculateScore(int correctCount, int incorrectCount);
}
```
- OriginalScore
  
 ```      
}public class OriginalScore implements GameScore{
    
    /**
     * @pre Posee 100 puntos
     * @pos Puede acabar minimo con 0 puntos
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     *
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
       return 0;
     } 
}
```
  
  


  
