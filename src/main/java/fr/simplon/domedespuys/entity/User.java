package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.UserView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.Id.class)
    private Long id;
    @Column(nullable = false)
    @JsonView(UserView.Email.class)
    private String email;
    @Column(nullable = false, length = 128)
    @JsonView(UserView.Password.class)
    private String password;
    @Column(nullable = false, length = 50)
    @JsonView(UserView.Firstname.class)
    private String firstname;
    @Column(nullable = false, length = 50)
    @JsonView(UserView.Lastname.class)
    private String lastname;
    @Column(length = 50)
    @JsonView(UserView.Phone.class)
    private String phone;
    @Column(nullable = false, updatable = false)
    @JsonView(UserView.CreatedAt.class)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @JsonView(UserView.Addresses.class)
    private List<Address> addresses;
    @OneToMany(mappedBy = "user")
    @JsonView(UserView.Purchases.class)
    private List<Purchase> purchases;
}

