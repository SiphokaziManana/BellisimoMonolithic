package com.bellisimo.monolithic.domain;

import java.util.List;

/**
 * Created by siphokazi on 2017/07/17.
 */
public interface AbstractDTO<E,D> {
    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntities(List<D> dto);

    List<D> toDTOs(List<E> entities);
}
