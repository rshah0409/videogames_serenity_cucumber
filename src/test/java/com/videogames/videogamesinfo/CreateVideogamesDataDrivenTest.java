package com.videogames.videogamesinfo;

import com.videogames.testbase.TestBase;
import com.videogames.videogameinfo.VideoGameSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "4x")
@UseTestDataFrom( "src/test/java/resources/featurefile" )
@RunWith(SerenityParameterizedRunner.class)
public class CreateVideogamesDataDrivenTest extends TestBase {
    private int id;
    private String name;
    private String releaseDate;
    private int reviewScore;
    private String category;
    private String rating;
    @Steps
    VideoGameSteps videoGameSteps;


    @Title( "Data Driven Test for adding multiple videogames to the application" )
    @Test
    public void createMultipleVideogames(){
        videoGameSteps.createVideoGame( id,name,releaseDate,reviewScore,category,rating ).log().all();


    }





}
