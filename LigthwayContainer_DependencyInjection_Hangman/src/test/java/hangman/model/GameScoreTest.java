package hangman.model;

import org.junit.Assert;
import org.junit.Test;

import hangman.model.GameScore;
import hangman.model.OriginalScore;

public class GameScoreTest {

    
    @Test
    public void OriginalScoreShouldntBeNegative(){
        //Arrange
        GameScore prueba = new OriginalScore();
        //Act
        int res = prueba.calculateScore(0, 13);
        //Assert
        Assert.assertTrue(res>=0);

    }

    @Test
    public void OriginalShouldSubstract(){
        //Arrange
        GameScore prueba = new OriginalScore();
        //Act
        int res = prueba.calculateScore(15, 3);
        //Assert
        Assert.assertTrue(res==70);
    }

    @Test
    public void BonusShouldAdd(){
        
    }

    @Test
    public void BonusShouldSubstract(){
        
    }

    @Test
    public void PowerBonusShouldntBeNegative(){
        
    }

    @Test
    public void PowerBonusShouldAdd(){
        
    }

    @Test
    public void PowerBonusShouldSubstract(){
        
    }

    @Test
    public void PowerBonusShouldBeLessThanFiveHundreed(){
        
    }
}
