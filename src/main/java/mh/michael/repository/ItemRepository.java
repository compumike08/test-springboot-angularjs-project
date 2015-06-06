package mh.michael.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mh.michael.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
