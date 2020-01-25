package com.redhat.ukconsulting.summit2020.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class ValidateCardDataRequest {

    private Long cardId;
    private List<CardTransaction> transactions;

    public ValidateCardDataRequest(final Long cardId, final List<CardTransaction> transactions) {
        this.cardId = cardId;
        this.transactions = transactions;
    }

    public Long getCardId() {
        return cardId;
    }

    public List<CardTransaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cardId", cardId)
                .append("transactions", transactions)
                .toString();
    }
}
