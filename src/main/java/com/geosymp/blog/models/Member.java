package com.geosymp.blog.models;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode @Getter @Setter
public class Member implements Serializable {
    private String name;
    private String speciality;
    private double lat;
    private double lon;
}
