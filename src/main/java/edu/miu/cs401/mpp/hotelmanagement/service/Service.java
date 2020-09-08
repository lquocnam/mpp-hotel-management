package edu.miu.cs401.mpp.hotelmanagement.service;

import java.util.List;
import java.util.Optional;

public interface Service<D, ID> {
    List<D> getAll();

    Optional<D> getById(ID id);

    D add(D dto);

    D update(D dto);

    void delete(ID id);
}
