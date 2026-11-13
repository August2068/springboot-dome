package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserPostDTO {
    @NotBlank(message = "email doit être renseigné")
    @Email
    @Length(max = 255, message = "email ne peut pas faire plus de 255 charactères")
    public String email;
    @NotBlank(message = "password doit être renseigné")
    @Length(max = 30, message = "password doit avoir 30 charactères max")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message ="au moins 8 charactères, une majuscule, une minuscule et un charactère spécial")
    public String password;
    @NotBlank(message = "firstName doit être renseigné")
    @Length(max = 50, message = "firstName ne peut pas faire plus de 180 charactères")
    public String firsName;
    @NotBlank(message = "lastName doit être renseigné")
    @Length(max = 50, message = "lastName ne peut pas faire plus de 180 charactères")
    public String lastName;
}
