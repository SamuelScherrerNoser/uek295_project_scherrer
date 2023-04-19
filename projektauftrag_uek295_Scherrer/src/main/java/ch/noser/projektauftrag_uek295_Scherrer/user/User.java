package ch.noser.projektauftrag_uek295_Scherrer.user;

import ch.noser.projektauftrag_uek295_Scherrer.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "role_id")
    private Role role;


}