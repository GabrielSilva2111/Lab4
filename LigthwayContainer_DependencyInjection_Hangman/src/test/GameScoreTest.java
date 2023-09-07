package hangman;

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
        Assert.assetTrue(res>=0);

    }

    @Test
    public void OriginalShouldSubstract(){
        
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
