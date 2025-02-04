package com.juaracoding.dapspringbootrestapi.service;

/*
IntelliJ IDEA 2024.3.2.2 (Community Edition)
Build #IC-243.23654.189, built on January 29, 2025
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 04/02/2025 14:27
@Last Modified 04/02/2025 14:40
Version 1.1
*/

import com.juaracoding.dapspringbootrestapi.core.IService;
import com.juaracoding.dapspringbootrestapi.model.KategoriBarang;
import com.juaracoding.dapspringbootrestapi.repo.KategoriBarangRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class KategoriBarangService implements IService<KategoriBarang> {

    private final KategoriBarangRepo kategoriBarangRepo;

    @Autowired
    public KategoriBarangService(KategoriBarangRepo kategoriBarangRepo) {
        this.kategoriBarangRepo = kategoriBarangRepo;
    }

    @Override
    public ResponseEntity<Object> save(KategoriBarang kategoriBarang, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        // Validasi data sebelum disimpan
        if (kategoriBarang == null || kategoriBarang.getNamaKategoriBarang() == null || kategoriBarang.getNamaKategoriBarang().trim().isEmpty()) {
            response.put("status", "error");
            response.put("message", "Nama kategori tidak boleh kosong.");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            KategoriBarang savedKategori = kategoriBarangRepo.save(kategoriBarang);
            response.put("status", "success");
            response.put("message", "Data kategori berhasil disimpan.");
            response.put("data", savedKategori);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Terjadi kesalahan saat menyimpan data: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> update(Long id, KategoriBarang kategoriBarang, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        Optional<KategoriBarang> existingKategori = kategoriBarangRepo.findById(id);
        if (existingKategori.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Kategori tidak ditemukan.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            KategoriBarang kategoriToUpdate = existingKategori.get();
            kategoriToUpdate.setNamaKategoriBarang(kategoriBarang.getNamaKategoriBarang());

            KategoriBarang updatedKategori = kategoriBarangRepo.save(kategoriToUpdate);
            response.put("status", "success");
            response.put("message", "Data kategori berhasil diperbarui.");
            response.put("data", updatedKategori);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Terjadi kesalahan saat memperbarui data: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> delete(Long id, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        if (!kategoriBarangRepo.existsById(id)) {
            response.put("status", "error");
            response.put("message", "Kategori tidak ditemukan.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            kategoriBarangRepo.deleteById(id);
            response.put("status", "success");
            response.put("message", "Kategori berhasil dihapus.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Terjadi kesalahan saat menghapus data: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(Long id, HttpServletRequest request) {
        Optional<KategoriBarang> kategoriBarang = kategoriBarangRepo.findById(id);

        if (kategoriBarang.isPresent()) {
            return new ResponseEntity<>(kategoriBarang.get(), HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Kategori tidak ditemukan.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> findAll(HttpServletRequest request) {
        List<KategoriBarang> kategoriList = kategoriBarangRepo.findAll();
        return new ResponseEntity<>(kategoriList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> saveBatch(List<KategoriBarang> lt, HttpServletRequest request) {
        List<KategoriBarang> savedList = kategoriBarangRepo.saveAll(lt);
        return new ResponseEntity<>(savedList, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> findByPage(Integer page, Integer size, String columFirst, String valueFirst, HttpServletRequest request) {
        return new ResponseEntity<>("Fitur belum diimplementasikan.", HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Object> findAllByPage(Integer page, Integer size, HttpServletRequest request) {
        return new ResponseEntity<>("Fitur belum diimplementasikan.", HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Object> dataToExport(MultipartFile multipartFile, HttpServletRequest request) {
        return new ResponseEntity<>("Fitur belum diimplementasikan.", HttpStatus.NOT_IMPLEMENTED);
    }
}
