package ch.noser.projektauftrag_uek295_Scherrer.domain.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author {

    @Id
    @NotNull(message = "ID mustn't be empty.")
    private Integer id;

    @NotBlank(message = "Name mustn't be empty.")
    private String name;

    private String birthdate;

    @Column(name = "profilepicture_url")
    private String profilePictureURL;
}