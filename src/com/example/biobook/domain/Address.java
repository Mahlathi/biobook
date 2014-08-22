package com.example.biobook.domain;

/**
 * Created by akhona on 2014/08/19.
 */
public class Address {
    private int id;
    private String street_number;
    private String street_name;
    private String town;
    private String postal_code;

    private Address()
    {}

    private Address( Builder builder )
    {
        id = builder.id;
        street_number = builder.street_number;
        street_name = builder.street_name;
        town = builder.town;
        postal_code = builder.postal_code;
    }

    public static class Builder
    {
        private int id;
        private String street_number;
        private String street_name;
        private String town;
        private String postal_code;

        public Builder( String street_number )
        {
            this.street_number = street_number;

        }

        public Builder id( int value )
        {
            id = value;
            return this;
        }

        public Builder street_name( String value )
        {
            street_name = value;
            return this;
        }

        public Builder town( String value )
        {
            town = value;
            return this;
        }

        public Builder postal_code( String value )
        {
            postal_code = value;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }

    }

    public int getId() {
        return id;
    }

    public String getStreet_number() {
        return street_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public String getTown() {
        return town;
    }

    public String getPostal_code() {
        return postal_code;
    }
}
