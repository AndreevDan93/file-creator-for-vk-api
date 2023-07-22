package ru.fileCreator.api;

import ru.fileCreator.model.VkUserDto;
import ru.fileCreator.utils.ApiUtils;
import ru.fileCreator.utils.Config;

import java.util.List;

public class ApiRequest {
    private static final String API_PATH = Config.get("api-path");

    public static List<VkUserDto> getVkUsers() {
        return ApiUtils.get(API_PATH);
    }
}
