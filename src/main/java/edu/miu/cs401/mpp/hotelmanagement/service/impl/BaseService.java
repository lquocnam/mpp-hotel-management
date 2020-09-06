package edu.miu.cs401.mpp.hotelmanagement.service.impl;

import edu.miu.cs401.mpp.hotelmanagement.service.Converter;
import edu.miu.cs401.mpp.hotelmanagement.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BaseService<E, D, ID> implements Service<D, ID> {

    @Autowired
    protected JpaRepository<E, ID> repository;

    @Autowired
    protected Converter<E, D> converter;

    @Override
    public List<D> getAll() {
        return repository.findAll().stream().map(e -> converter.toDto(e)).collect(toList());
    }

    @Override
    public D getById(ID id) {
        return repository.findById(id).map(e -> converter.toDto(e)).orElse(null);
    }

    @Override
    public D add(D dto) {
        return converter.toDto(repository.save(converter.fromDto(dto)));
    }

    @Override
    public D update(D dto) {
        E savedEntity = repository.save(converter.fromDto(dto));
        return converter.toDto(savedEntity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
