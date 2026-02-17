package nl.crocstock.mapper;

import lombok.experimental.UtilityClass;
import tools.jackson.databind.ObjectMapper;

@UtilityClass
public class JsonMapper {
    public <T> String toJsonString(T object) {
        return new ObjectMapper().writeValueAsString(object);
    }
}
