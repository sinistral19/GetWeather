package org.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind
{   @JsonProperty("speed")
    Float speed;
    @JsonProperty("deg")
    Float deg;
    @JsonProperty("gust")
    Float gust;
}
