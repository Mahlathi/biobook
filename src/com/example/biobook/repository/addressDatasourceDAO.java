package com.example.biobook.repository;

import com.example.biobook.domain.Address;

import java.util.List;

/**
 * Created by akhona on 2014/08/19.
 */
public interface addressDatasourceDAO {
    public void createAddress(Address address);
    public void updateAddress(Address address);
    public Address findAddressById(int id);
    public void deleteAddress(Address address);
    public Address getAddress();
    public List<Address> getAddressList();
}
