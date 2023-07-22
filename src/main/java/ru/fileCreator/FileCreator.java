package ru.fileCreator;

import ru.fileCreator.api.ApiRequest;
import ru.fileCreator.model.VkUserDto;
import ru.fileCreator.writer.WriterToExel;

import java.util.List;

public class FileCreator {
    public static void main(String[] args) {
        List<VkUserDto> vkUserDtoList = ApiRequest.getVkUsers();
        WriterToExel.write(vkUserDtoList);
    }
}