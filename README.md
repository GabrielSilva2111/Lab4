# LAB04
# Integrantes
- Santiago Nicolas Parra Giraldo
- Gabriel Alejandro Silva Lozada

# PARTE I
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
- BonusScore
```
  package hangman.model;

public class BonusScore implements GameScore {
     /**
     * @pre Posee 0 puntos
     * @pos Puede acabar minimo con 0 puntos, se penaliza con 5 puntos y bonifica con 10
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    } 
}
```
- PowerScore
```
package hangman.model;

public class PowerBonusScore implements GameScore {
     /**
     * @pre Posee 0 puntos
     * @pos Puede acabar minimo con 0 puntos o maximo 500, se penaliza con 5 puntos y bonifica con 10
     * @param correctCount var entero
     * @param incorrectCount var entero
     * @return puntaje
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }   
}
```
3. Editamos el pom.xml y actualizamos las dependencias del compilador de java
   ![image](https://github.com/GabrielSilva2111/Lab4/assets/123813120/cec34a80-4465-4fe6-a5bf-bffa0a0fd9f8)

4. Implementación de lógica para pasar las pruebas
- OriginalScore
```
  package hangman.model;

public class OriginalScore implements GameScore{
    private int puntaje = 100;
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
        puntaje = 100;
        puntaje -=  incorrectCount * 10;
        System.out.println(puntaje);
        return puntaje <= 0 ? 0 : puntaje;
     }  
}
```
- BonusScore
```
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
```
- PowerBonusScore
```
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

```
5. por Último guardamos los cambios con el comando git Push

# PARTE II

1. Ingresamos en la carpeta FactoryMethod para hacer uso de la inyecciones
   
   
   

  
  


  
