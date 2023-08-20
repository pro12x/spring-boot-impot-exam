package com.isi.dao;

import com.isi.entity.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationRepository extends JpaRepository<Declaration, Long>
{
    @Query("select dec from Declaration dec where dec.isPayed = false")
    List<Declaration> listNotPayed();
}
