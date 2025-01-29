package com.juaracoding.dapspringbootrestapi.repo;
/*
IntelliJ IDEA 2024.3 (Community Edition)
Build #IC-243.21565.193, built on November 13, 2024
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 29/01/2025 13:59
@Last Modified 29/01/2025 13:59
Version 1.0
*/

import com.juaracoding.dapspringbootrestapi.model.Peserta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PesertaRepo extends JpaRepository<Peserta, Integer> {
    List<Peserta> findByNama(String nama);
    void deleteByNama(String nama);
    int countByBatch(String batch);
    List<Peserta> findTop4ByBatchAndAlamatContaining(String batch, String alamatMengandung);

//    @Query(value = "SELECT * FROM peserta WHERE nama = ?1 AND batch = ?2", nativeQuery = true)
//    List<Peserta> findPesertaByNamaBatch(String nama, String batch);

    @Query(value = "SELECT * FROM contohSchema.Peserta WHERE nama = :isi1 AND batch = :isi2", nativeQuery = true)
    List<Peserta> findPesertaByNamaBatch(@Param("isi1") String nama, @Param("isi2") String batch);
}