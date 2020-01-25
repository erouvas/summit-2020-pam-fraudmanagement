package com.redhat.ukconsulting.summit2020.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ValidateCardDataResponse {

    private Integer riskRating = 0;
    private Boolean isHigh = false;

    public ValidateCardDataResponse(final Integer riskRating, final Boolean isHigh) {
        this.riskRating = riskRating;
        this.isHigh = isHigh;
    }

    public Integer getRiskRating() {
        return riskRating;
    }

    public Boolean getHigh() {
        return isHigh;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("riskRating", riskRating)
                .append("isHigh", isHigh)
                .toString();
    }
}
