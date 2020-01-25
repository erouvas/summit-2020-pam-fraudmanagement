package com.redhat.ukconsulting.summit2020.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CardTransaction {

    private Long cardId;

    public CardTransaction(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cardId", cardId)
                .toString();
    }
}
