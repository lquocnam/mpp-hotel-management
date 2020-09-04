package edu.miu.cs401.mpp.hotelmanagement.service;

import org.mapstruct.MappingTarget;

public interface Converter<E, D> {
    D toDto(E entity);

    E fromDto(D dto);

    E fromDto(D dto, @MappingTarget E entity);
}
