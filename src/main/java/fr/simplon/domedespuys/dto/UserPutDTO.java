package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserPutDTO {
    @NotBlank(message = "firstName doit être renseigné")
    @Length(max = 50, message = "firstName ne peut pas faire plus de 180 charactères")
    public String firsName;
    @NotBlank(message = "lastName doit être renseigné")
    @Length(max = 50, message = "lastName ne peut pas faire plus de 180 charactères")
    public String lastName;
    @Length(max = 50, message = "phone ne peut pas faire plus de 180 charactères")
    public String phone;
}
