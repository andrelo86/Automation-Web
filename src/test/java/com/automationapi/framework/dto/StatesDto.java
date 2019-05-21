package com.automationapi.framework.dto;

import com.automationapi.framework.entities.State;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "states"
})
public class StatesDto {

  @JsonProperty("states")
  private List<State> states = null;

  /**
   * No args constructor for use in serialization
   */
  public StatesDto() {
  }

  /**
   *
   * @param states
   */
  public StatesDto(List<State> states) {
    super();
    this.states = states;
  }

  @JsonProperty("states")
  public List<State> getStates() {
    return states;
  }

  @JsonProperty("states")
  public void setStates(List<State> states) {
    this.states = states;
  }

  public String toString() {
    return new ToStringBuilder(this).append("states", states).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(states).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof StatesDto) == false) {
      return false;
    }
    StatesDto rhs = ((StatesDto) other);
    return new EqualsBuilder().append(states, rhs.states).isEquals();
  }

}