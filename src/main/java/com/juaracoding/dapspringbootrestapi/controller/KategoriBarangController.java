package com.juaracoding.dapspringbootrestapi.controller;
/*
IntelliJ IDEA 2024.3.2.2 (Community Edition)
Build #IC-243.23654.189, built on January 29, 2025
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 04/02/2025 14:29
@Last Modified 04/02/2025 14:29
Version 1.0
*/

import com.juaracoding.dapspringbootrestapi.model.KategoriBarang;
import com.juaracoding.dapspringbootrestapi.service.KategoriBarangService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/katbarang")
public class KategoriBarangController {
    private KategoriBarangService kategoriBarangService;

    public KategoriBarangController(KategoriBarangService kategoriBarangService) {
        this.kategoriBarangService = kategoriBarangService;
    }

    @PostMapping("/v1/sv")
    public ResponseEntity<Object> save(@RequestBody KategoriBarang kategoriBarang, HttpServletRequest request) {
        return kategoriBarangService.save(kategoriBarang, request);
    }

    @PostMapping("/v1/upd/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody KategoriBarang kategoriBarang, HttpServletRequest request) {
        return kategoriBarangService.update(id, kategoriBarang, request);
    }

    @DeleteMapping("/v1/del/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id, HttpServletRequest request) {
        return kategoriBarangService.delete(id, request);
    }
}
