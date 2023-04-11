package com.example.spotifyplaylistapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "songs")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "performer_name")
    private String performerName;

    @NotNull
    @Size(min = 2, max = 20)
    private String title;

    @NotNull
    @Min(1)
    private int duration;

    @Past
    @Column(name = "release_date")
    private Date releaseDate;

    @OneToMany(mappedBy = "songStyles", fetch = FetchType.EAGER)
    private List<StyleEntity> styles;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserEntity> userSongs;

}
