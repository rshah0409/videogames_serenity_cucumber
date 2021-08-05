package com.videogames.videogameinfo;

import com.videogames.constants.EndPoints;
import com.videogames.model.VideoGamePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VideoGameSteps {
    @Step("Creating videogame with id:{0},name:{1}, releaseDate:{2},reviewScore:{3},category:{4} and rating:{5}")
    public ValidatableResponse createVideoGame(int id,String name,String releaseDate,int reviewScore,String category,String rating){

        VideoGamePojo videoGamePojo = new VideoGamePojo();
        videoGamePojo.setId( id );
        videoGamePojo.setName( name );
        videoGamePojo.setReleaseDate( releaseDate );
        videoGamePojo.setReviewScore( reviewScore );
        videoGamePojo.setCategory(category);
        videoGamePojo.setRating( rating );
        return SerenityRest.rest()
                .given().log().all()
                .contentType( ContentType.JSON )
                .when()
                .body( videoGamePojo ).accept( "application/json" )
                .post(EndPoints.CREATE_NEW_VIDEOGAME)
                .then().log().all();


    }
    @Step("getting info with sinlge id")
    public ValidatableResponse getSingleVideoGameByid(int videogameId){
        return SerenityRest.rest()
                .given().log().all()
                .pathParam( "id", videogameId)
                .header("Accept","application/json")
                .when()
                .get(EndPoints.GET_VIDEOGAME_BY_ID)
                .then();
    }
    @Step("This will get All videogames")
    public ValidatableResponse getAllVideoGames(){
        return SerenityRest.rest()
                .given().log().all()
                .when()
                .get( EndPoints.GET_ALL_VIDEOGAMES)
                .then();

    }
    @Step("Updating videogame info by id")

    public ValidatableResponse updatesingleVideoGameById(int id,String name,String releaseDate,int reviewScore,String category,String rating) {
        VideoGamePojo videoGamePojo = new VideoGamePojo();
        return SerenityRest.rest()
                .given().log().all()
                .header( "Content-Type","application/json" )
                .pathParam( "id",id )
                .when()
                .body( videoGamePojo ).accept( "application/json" )
                .put( EndPoints.UPDATE_VIDEOGAME_BY_ID )
                .then().log().all();

    }
@Step("Deleting videogame by id")
    public ValidatableResponse deleteGameById(int videoGameId){

        return SerenityRest.rest()
                .given().log().all()
                .pathParam( "id",videoGameId )
                .when()
                .delete(EndPoints.DELETE_VIDEOGAME_BY_ID).then();




}


}
