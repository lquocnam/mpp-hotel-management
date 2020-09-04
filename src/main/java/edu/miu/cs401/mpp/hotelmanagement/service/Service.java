package edu.miu.cs401.mpp.hotelmanagement.service;

import java.util.List;

public interface Service<D, ID> {
    List<D> getAll();

    D getById(ID id);

    D add(D dto);
}
