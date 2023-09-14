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

1. Ingresamos en la carpeta FactoryMethod para hacer uso de la inyecciones, en la clase Abstract declaramos un nuevo metodo "createGameScore"  en la clase HangmanFactoryMethod para usarlo en la clase siguiente.
 ```  
   package hangman.setup.factoryMethod;

import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;

abstract public class HangmanFactoryMethod {
    abstract public Language createLanguage();
    abstract public HangmanDictionary createDictionary();
    abstract public HangmanPanel createHangmanPanel();
    abstract public GameScore createGameScore();
}
```
2. En la clase HangmanDefaultFactoryMethod creamos el nuevo modo GameScore donde creamos los nuevos objetos de la clase GameScore
```   
 package hangman.setup.factoryMethod;

import hangman.model.English;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.OriginalScore;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.setup.factoryMethod.HangmanFactoryMethod;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

public class HangmanDefaultFactoryMethod extends HangmanFactoryMethod {
    @Override
    public Language createLanguage() {
        return new English();
    }

    @Override
    public HangmanDictionary createDictionary() {
        return new EnglishDictionaryDataSource();
    }

    @Override
    public HangmanPanel createHangmanPanel() {return new HangmanStickmanPanel();}

    @Override
    public GameScore createGameScore() {return new OriginalScore();}
}
```  

3. Actualizamos las dependencias de nuestro contenedor Google Guice en el pom.xml en la versión 5.1.0

![image](https://github.com/GabrielSilva2111/Lab4/assets/123813120/a9346bff-b72c-47f6-ba21-986a8edbfa03)

4. Aplicamos lass inyecciones, por lo tanto modificaremos las clase HangmanFactoryServices,para este ejemplo, implementaremos PowerBonusScore, idioma Inglés, y diccionario Inglés, por último el panel Hagnman.bind()  Esto lo que nos permitirá es cambiar los modos del juego
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

/**
 *
 * @author 2106913
 */

import hangman.model.*;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.model.dictionary.SpanishDictionaryDataSource;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

public class HangmanFactoryServices extends com.google.inject.AbstractModule {

    @Override
    protected void configure() {
        /* Guice dependency injection */
        // bind(Interface.class).to(Concrete.class);
        bind(Language.class).to(English.class);
        bind(HangmanDictionary.class).to(EnglishDictionaryDataSource.class);
        bind(HangmanPanel.class).to(HangmanStickmanPanel.class);
        bind(GameScore.class).to(PowerBonusScore.class);
    }

}
```
- se modifica la clase GUI creando el parametro gameScore, para añadirlo a los dos constructores

```
private GameScore gameScore;

public GUI(HangmanFactoryMethod factoryMethod) {
        this.language = factoryMethod.createLanguage();
        this.dictionary = factoryMethod.createDictionary();
        this.hangmanPanel = factoryMethod.createHangmanPanel();
        this.gameScore = factoryMethod.createGameScore();
    }

@Inject
    // Use Guice constructor
    public GUI(Language language, HangmanDictionary dictionary, HangmanPanel hangmanPanel, GameScore gameScore){
        this.language = language;
        this.dictionary= dictionary;
        this.hangmanPanel = hangmanPanel;
        this.gameScore = gameScore;
    }

/* Dentro del metodo setup (){}
*/ 
GameModel gameModel = new GameModel(dictionary,gameScore);
```
- Por último modificamos la clase GameModel, para quitarle complejidad a la clase y desacoplarla. Para ello creamos un nuevo parametro score y modificando su constructor, será el parametro que nos conectará con nuestra interfaz GameScore 
  
```
Private GameScore score;
public GameModel(HangmanDictionary dictionary,GameScore score ){
        //this.dictionary = new EnglishDictionaryDataSource();
        this.dictionary=dictionary;
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        this.score = score;
        incorrectCount = 0;
        correctCount = 0;
        gameScore = score.calculateScore(correctCount, incorrectCount);
        
    }
public void reset(){
        randomWord = selectRandomWord();
        randomWordCharArray = randomWord.toCharArray();
        incorrectCount = 0;
        correctCount = 0;
        gameScore = score.calculateScore(correctCount,incorrectCount);
    }
public ArrayList<Integer> makeGuess(String guess){
        char guessChar = guess.charAt(0);
        ArrayList<Integer> positions = new ArrayList<>();
        for(int i = 0; i < randomWordCharArray.length; i++){
            if(randomWordCharArray[i] == guessChar){
                positions.add(i);
            }
        }
        if(positions.size() == 0){
            incorrectCount++;
            gameScore = score.calculateScore(correctCount,incorrectCount);
            
        } else {
            correctCount += positions.size();
            gameScore = score.calculateScore(correctCount,incorrectCount);
        }

        return positions;
        
    }
```
5. Para que nuestra inyección quede completa en nuestra clase SwingProyect en nuestro metodo main implementamos el metodo createGUIUsing() Esto nos permitira hacer uso de la inyección en GUI
```
public static void main(String[] args) {
        createGUIUsingGuice().play();
    }
```







   
   
   

  
  


  
