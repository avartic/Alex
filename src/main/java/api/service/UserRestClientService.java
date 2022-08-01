package api.service;


import api.dto.UserData;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pages.BasePage;

import java.util.List;

import static api.constants.UserConstants.*;

public class UserRestClientService {

    private WebClient webClient;

    public UserRestClientService(WebClient webClient) {
        this.webClient = webClient;
    }


    public UserData createUser(UserData userData) {
        return webClient.post().uri(CREATE_USER)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userData)
                .retrieve()
                .bodyToMono(UserData.class)
                .block();
    }

    public UserData updateUserById(int userId, UserData userData) {
        return webClient.put().uri(UPDATE_USER_BY_ID, userId)
                .bodyValue(userData)
                .retrieve()
                .bodyToMono(UserData.class)
                .block();
    }

    public List<UserData> getAllUsers() {
        return webClient.get().uri(GET_ALL_USERS)
                .retrieve()
                .bodyToFlux(UserData.class)
                .collectList().block();
    }

    public UserData getUserById(int userId) {
        return webClient.get().uri(GET_USER_BY_ID, userId)
                .retrieve()
                .bodyToMono(UserData.class)
                .block();
    }

    public UserData deleteUserById(int userId) {
        return webClient.delete().uri(DELETE_USER_BY_ID, userId)
                .retrieve()
                .bodyToMono(UserData.class)
                .block();

    }

}