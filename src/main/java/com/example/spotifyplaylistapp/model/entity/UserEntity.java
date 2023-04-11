package com.example.spotifyplaylistapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    @ManyToMany(mappedBy = "userSongs", fetch = FetchType.EAGER)
    private List<SongEntity> playlist;

}
