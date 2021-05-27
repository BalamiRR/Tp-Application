package com.sorbonne.paris.nord.university.tpteamshandlingapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TeamDto(@JsonProperty("id") Long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("slogan") String slogan) {

    public TeamDto(@JsonProperty("name") String name, @JsonProperty("slogan") String slogan) {
        this(null, name, slogan);
    }
}
