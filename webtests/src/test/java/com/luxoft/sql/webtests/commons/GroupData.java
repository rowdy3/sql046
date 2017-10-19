package com.luxoft.sql.webtests.commons;

public class GroupData {
    String name;
    String lastName;
    String middleName;
    String address;

    public GroupData(String name, String lastName, String middleName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return lastName != null ? lastName.equals(groupData.lastName) : groupData.lastName == null;
    }

    @Override
    public String toString() {
        return lastName  + " " + name;
    }
}
