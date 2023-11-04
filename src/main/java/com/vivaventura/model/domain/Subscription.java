package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.Objects;

public class Subscription implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private boolean isSubscribed;
    private boolean paymentConfirmed;

    //Default constructor
    public Subscription(){}

    //Overloaded constructor
    public Subscription(boolean isSubscribed, boolean paymentConfirmed) {
        this.isSubscribed = isSubscribed;
        this.paymentConfirmed = paymentConfirmed;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isPaymentConfirmed() {
        return paymentConfirmed;
    }

    public void setPaymentConfirmed(boolean paymentConfirmed) {
        this.paymentConfirmed = paymentConfirmed;
    }

    //Custom toString method
    @Override
    public String toString() {
        return "Subscription{" +
                "paymentConfirmed=" + paymentConfirmed +
                '}';
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription that)) return false;
        return isSubscribed() == that.isSubscribed() && isPaymentConfirmed() == that.isPaymentConfirmed();
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(isSubscribed(), isPaymentConfirmed());
    }
}
