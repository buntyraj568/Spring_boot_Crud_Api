package com.repository;


import com.model.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository<Doc,Integer>
{

}
