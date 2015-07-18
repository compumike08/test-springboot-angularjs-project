package mh.michael.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mh.michael.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
