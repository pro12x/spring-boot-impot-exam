package com.isi.dao;

import com.isi.entity.Declarant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long>
{
    //
}
