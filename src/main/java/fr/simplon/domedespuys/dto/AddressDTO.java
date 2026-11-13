package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class AddressDTO {
    @NotBlank(message = "line doit être renseigné")
    @Length(max = 50, message = "line ne peut pas faire plus de 50 charactères")
    public String line;
    @Length(max = 50, message = "extraLine ne peut pas faire plus de 50 charactères")
    public String extraLine;
    @NotBlank(message = "zipCode doit être renseigné")
    @Length(max = 50, message = "zipCode ne peut pas faire plus de 50 charactères")
    public String zipCode;
    @NotBlank(message = "city doit être renseigné")
    @Length(max = 50, message = "city ne peut pas faire plus de 50 charactères")
    public String city;
    @NotBlank(message = "country doit être renseigné")
    @Length(max = 50, message = "country ne peut pas faire plus de 100 charactères")
    public String country;
    @Length(max = 50, message = "phone ne peut pas faire plus de 50 charactères")
    public String phone;
    @NotBlank(message = "firstName doit être renseigné")
    @Length(max = 50, message = "firstName ne peut pas faire plus de 50 charactères")
    public String firstName;
    @NotBlank(message = "lastName doit être renseigné")
    @Length(max = 50, message = "lastName ne peut pas faire plus de 50 charactères")
    public String lastName;
}
