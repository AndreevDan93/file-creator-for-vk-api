package ru.fileCreator.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;


import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import ru.fileCreator.model.VkUserDto;

import java.util.List;

public class ApiUtils {

    static {
        Unirest.config().defaultBaseUrl(Config.get("api_base_url"));
    }

    public static List<VkUserDto> get(String requestPath) {
        String response = Unirest.get(requestPath)
                .asJson().getBody().toString();
        Unirest.shutDown();

        ObjectMapper objectMapper = new ObjectMapper();
        List<VkUserDto> vkUserDtoList = null;
        try {
            vkUserDtoList = objectMapper.readValue(response,
                    new TypeReference<List<VkUserDto>>() {
                    });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return vkUserDtoList;
    }

}
