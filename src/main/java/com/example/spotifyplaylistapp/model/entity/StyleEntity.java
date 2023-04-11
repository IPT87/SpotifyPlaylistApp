package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.enums.StyleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "styles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StyleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "style_name", unique = true)
    private StyleName styleName;

    private String description;

}
