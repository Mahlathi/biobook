package com.example.biobook.repository;

import com.example.biobook.domain.Address;

import java.util.List;

/**
 * Created by akhona on 2014/08/19.
 */
public interface addressDatasourceDAO {
    public void createAddress(Address address);
    public void updateAddress(Address address);
    public Address findStudentById(int id);
    public void deleteStudent(Address address);
    public Address getAddress();
    public List<Address> getAddressList();
}
