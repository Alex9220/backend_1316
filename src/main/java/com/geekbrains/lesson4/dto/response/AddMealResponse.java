package com.geekbrains.lesson4.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Generated;

import javax.sql.RowSet;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "id"
})
@Generated()
public class AddMealResponse {

    @JsonProperty("status")
    public String status;
    @JsonProperty("id")
    public Integer id;

}
