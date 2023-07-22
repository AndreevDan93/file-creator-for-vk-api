package ru.fileCreator.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VkUserDto {
    private Long id;
    private Long vkId;
    private String firstName;
    private String lastName;
    private String date;
    private String city;
    private String phone;

    @Override
    public String toString() {
        return "VkUserDto{" +
                "id=" + id +
                ", vkId=" + vkId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
