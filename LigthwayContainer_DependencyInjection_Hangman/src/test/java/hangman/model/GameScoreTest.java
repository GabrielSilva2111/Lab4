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
        //Arrange
        GameScore prueba = new BonusScore();
        //Act
        int res = prueba.calculateScore(10, 1);
        //Assert
        Assert.assertTrue(res>=0);
    }

    @Test
    public void BonusShouldSubstract(){
        //Arrange
        GameScore prueba = new BonusScore();
        //Act
        int res = prueba.calculateScore(1, 1);
        //Assert
        Assert.assertTrue(res>=5);
    }

    @Test
    public void PowerBonusShouldntBeNegative(){
        //Arrange
        GameScore prueba = new PowerBonusScore();
        //Act
        int res = prueba.calculateScore(0, 13);
        //Assert
        Assert.assertTrue(res>=0);
    }

    @Test
    public void PowerBonusShouldAdd(){
                //Arrange
        GameScore prueba = new PowerBonusScore();
        //Act
        int res = prueba.calculateScore(1, 0);
        //Assert
        Assert.assertTrue(res==5);
    }

    @Test
    public void PowerBonusShouldSubstract(){
                //Arrange
        GameScore prueba = new PowerBonusScore();
        //Act
        int res = prueba.calculateScore(2, 1);
        //Assert
        Assert.assertTrue(res==17);
    }

    @Test
    public void PowerBonusShouldBeLessThanFiveHundreed(){
                //Arrange
        GameScore prueba = new PowerBonusScore();
        //Act
        int res = prueba.calculateScore(13, 0);
        //Assert
        Assert.assertTrue(res==500);
    }
}
