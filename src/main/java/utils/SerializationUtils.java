package utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Collectors;

public class SerializationUtils {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public String serializeObjectToString(Object object) {
        String objectAsString = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            Map<String, Object> filteredMap = this.createNewMapWithNoNullFields(objectMapper, object);
            objectAsString = objectMapper.writeValueAsString(filteredMap);
            DocumentContext jsonContext = JsonPath.parse(objectAsString);

            objectAsString = jsonContext.jsonString();
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        } catch (PathNotFoundException e) {
            logger.warn("Path not found: $.externalBalanceAmountAvailable");
        }
        return objectAsString;
    }

    private Map<String, Object> createNewMapWithNoNullFields(ObjectMapper objectMapper, Object object) {
        // Convert DTO to a Map
        Map<String, Object> map = objectMapper.convertValue(object, Map.class);

        // Remove null values - sometimes some null values persist because of @JsonInclude annotation in DTO so we need the following to remove all null values
        // which maybe still present:
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
