// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ISBNValidatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.isbnvalidator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ISBNValidatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ISBNValidatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ISBNValidatorData.class);
        writer = mapper.writerFor(ISBNValidatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ISBNValidatorData.java

package com.apiverve.isbnvalidator.data;

import com.fasterxml.jackson.annotation.*;

public class ISBNValidatorData {
    private boolean valid;
    private String isbn;
    private String type;
    private String normalized;
    private String formatted;
    private boolean checksumValid;
    private String prefix;
    private String group;
    private String publisher;
    private String title;
    private String checkDigit;
    private Object error;

    @JsonProperty("valid")
    public boolean getValid() { return valid; }
    @JsonProperty("valid")
    public void setValid(boolean value) { this.valid = value; }

    @JsonProperty("isbn")
    public String getIsbn() { return isbn; }
    @JsonProperty("isbn")
    public void setIsbn(String value) { this.isbn = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("normalized")
    public String getNormalized() { return normalized; }
    @JsonProperty("normalized")
    public void setNormalized(String value) { this.normalized = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }

    @JsonProperty("checksum_valid")
    public boolean getChecksumValid() { return checksumValid; }
    @JsonProperty("checksum_valid")
    public void setChecksumValid(boolean value) { this.checksumValid = value; }

    @JsonProperty("prefix")
    public String getPrefix() { return prefix; }
    @JsonProperty("prefix")
    public void setPrefix(String value) { this.prefix = value; }

    @JsonProperty("group")
    public String getGroup() { return group; }
    @JsonProperty("group")
    public void setGroup(String value) { this.group = value; }

    @JsonProperty("publisher")
    public String getPublisher() { return publisher; }
    @JsonProperty("publisher")
    public void setPublisher(String value) { this.publisher = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("check_digit")
    public String getCheckDigit() { return checkDigit; }
    @JsonProperty("check_digit")
    public void setCheckDigit(String value) { this.checkDigit = value; }

    @JsonProperty("error")
    public Object getError() { return error; }
    @JsonProperty("error")
    public void setError(Object value) { this.error = value; }
}