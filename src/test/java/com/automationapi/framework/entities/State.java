package com.automationapi.framework.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "label",
    "abbreviation",
    "minLoanAmount",
    "minAge"
})
public class State {

  @JsonProperty("label")
  private String label;
  @JsonProperty("abbreviation")
  private String abbreviation;
  @JsonProperty("minLoanAmount")
  private Double minLoanAmount;
  @JsonProperty("minAge")
  private Integer minAge;

  /**
   * No args constructor for use in serialization
   */
  public State() {
  }

  /**
   *
   * @param minAge
   * @param label
   * @param abbreviation
   * @param minLoanAmount
   */
  public State(String label, String abbreviation, Double minLoanAmount, Integer minAge) {
    super();
    this.label = label;
    this.abbreviation = abbreviation;
    this.minLoanAmount = minLoanAmount;
    this.minAge = minAge;
  }

  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  @JsonProperty("label")
  public void setLabel(String label) {
    this.label = label;
  }

  @JsonProperty("abbreviation")
  public String getAbbreviation() {
    return abbreviation;
  }

  @JsonProperty("abbreviation")
  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  @JsonProperty("minLoanAmount")
  public Double getMinLoanAmount() {
    return minLoanAmount;
  }

  @JsonProperty("minLoanAmount")
  public void setMinLoanAmount(Double minLoanAmount) {
    this.minLoanAmount = minLoanAmount;
  }

  @JsonProperty("minAge")
  public Integer getMinAge() {
    return minAge;
  }

  @JsonProperty("minAge")
  public void setMinAge(Integer minAge) {
    this.minAge = minAge;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("label", label).append("abbreviation", abbreviation)
        .append("minLoanAmount", minLoanAmount).append("minAge", minAge).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(minAge).append(label).append(abbreviation)
        .append(minLoanAmount).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof State) == false) {
      return false;
    }
    State rhs = ((State) other);
    return new EqualsBuilder().append(minAge, rhs.minAge).append(label, rhs.label)
        .append(abbreviation, rhs.abbreviation).append(minLoanAmount, rhs.minLoanAmount).isEquals();
  }

}