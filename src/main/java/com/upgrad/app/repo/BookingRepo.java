package com.upgrad.app.repo;

import com.upgrad.app.entity.BookingInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepo extends CrudRepository<BookingInfoEntity, Integer> {
}
