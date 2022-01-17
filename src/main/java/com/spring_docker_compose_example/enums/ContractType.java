package com.spring_docker_compose_example.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public enum ContractType {
    @JsonProperty("permanent")
    PERMANENT ("permanent"),

    @JsonProperty("fixed")
    FIXED ("fixed"),

    @JsonProperty("casual")
    CASUAL ("casual");

    private final String type;
    ContractType(String type){
        this.type = type;
    }
}
