package com.videogames.cucumber;

import com.videogames.utils.TestUtils;
import com.videogames.videogameinfo.VideoGameSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class VidoegameStepdefs {
    static int id = 1 + TestUtils.getRandomValueInt();
    static String name = "Suoer Mario";
    static String releaseDate = ("2019-09-20T08:55:58.510Z");
    static int reviewScore = 80;
    static String category = "Kids";
    static String rating  = "Universal";


    @Steps
    VideoGameSteps videoGameSteps;

    @When("^I create a new videogame by providing the information name \"([^\"]*)\" releaseDate \"([^\"]*)\" rating \"([^\"]*)\"$")
    public void iCreateANewVideogameByProvidingTheInformationNameReleaseDateRating(String name, String releaseDate, String rating)  {
        videoGameSteps.createVideoGame(id,name,releaseDate,reviewScore,category,rating).log().all().statusCode(200).extract().response().body()
                .jsonPath();
    }

    @Then("^I verify the videogame is created$")
    public void iVerifyTheVideogameIsCreated() {
        videoGameSteps.getSingleVideoGameByid(id).log().all().statusCode(200);
    }

    @When("^I send GET request to videogames endpoint with Id \"([^\"]*)\",I should received the videogame information$")
    public void iSendGETRequestToVideogamesEndpointWithIdIShouldReceivedTheVideogameInformation(String videogameId)  {
        videoGameSteps.getSingleVideoGameByid(id).log().all().statusCode(200);

    }

    @When("^I update a created videogame by providing the new name\"([^\"]*)\" category and rating$")
    public void iUpdateACreatedVideogameByProvidingTheNewNameCategoryAndRating(String name)  {
        id = id;
        name = name + "_updated";
        releaseDate = releaseDate;
        reviewScore = reviewScore + 1;
        category = category + "_changed";
        rating = rating + "_new";

        videoGameSteps.updatesingleVideoGameById(id, name, releaseDate, reviewScore, category, rating).statusCode(200).log().all();



    }

    @Then("^I verify the videogame is updated$")
    public void iVerifyTheVideogameIsUpdated() {
        videoGameSteps.getSingleVideoGameByid(id).body("id", equalTo(id));

    }

    @When("^I delete a created videogame ,I should get back a valid status code  (\\d+)$")
    public void iDeleteACreatedVideogameIShouldGetBackAValidStatusCode(int videogameId) {
        videoGameSteps.deleteGameById(videogameId).log().all().statusCode(200);
    }

    @When("^User sends a GET requets to videogames endpoint, user should get back a valid status code 200$")
    public void userSendsAGETRequetsToVideogamesEndpointUserShouldGetBackAValidStatusCode() {
        videoGameSteps.getAllVideoGames().log().all().statusCode(200);
    }
}
