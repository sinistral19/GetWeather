package org.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord
{   @JsonProperty("lon")
    Float lon;
    @JsonProperty("lat")
    Float lat;
}