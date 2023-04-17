package ch.noser.projektauftrag_uek295_Scherrer.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Author")
public class Author {

    @Id
    @NotBlank(message = "ID must be given.")
    private Integer ID;

    @NotBlank(message = "Name mustn't be empty.")
    private String name;

    private String birthdate;

    @Column(name = "profilePicture_URL")
    private String profilePictureURL;
}