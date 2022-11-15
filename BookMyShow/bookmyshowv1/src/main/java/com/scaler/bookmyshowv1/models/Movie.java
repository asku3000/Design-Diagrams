package com.scaler.bookmyshowv1.models;

import com.scaler.bookmyshowv1.enums.Language;
import com.scaler.bookmyshowv1.enums.MovieFeature;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Movie extends BaseModel {

    private String name;
    private Integer duration;
    private Double rating;

    @ElementCollection//for primitve data type Strings
    @Enumerated
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

}
