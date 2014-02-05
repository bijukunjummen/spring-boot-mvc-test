package mvctest.service;


import mvctest.domain.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {

}
