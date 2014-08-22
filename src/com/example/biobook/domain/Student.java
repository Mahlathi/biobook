package com.example.biobook.domain;

/**
 * Created by Davinci on 17/08/2014.
 */
public class Student {
    private int id;
    private String stud_name;
    private String stud_last;
    private String stud_mail;
    private String stud_cell;

    private Student()
    {}

    private Student( Builder builder )
    {
        id = builder.id;
        stud_name = builder.stud_name;
        stud_last = builder.stud_last;
        stud_mail = builder.stud_mail;
        stud_cell = builder.stud_cell;

    }

    public static class Builder
    {
        private int id;
        private String stud_name;
        private String stud_last;
        private String stud_mail;
        private String stud_cell;

        public Builder( String stud_name )
        {
             this.stud_name = stud_name;

        }

        public Builder id( int value )
        {
            id = value;
            return this;
        }

        public Builder lastname( String value )
        {
            stud_last = value;
            return this;
        }

        public Builder email( String value )
        {
            stud_mail = value;
            return this;
        }

        public Builder cell( String value )
        {
            stud_cell = value;
            return this;
        }

        public Student build()
        {
            return new Student(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public String getStud_last() {
        return stud_last;
    }

    public String getStud_mail() {
        return stud_mail;
    }

    public String getStud_cell() {
        return stud_cell;
    }
}
