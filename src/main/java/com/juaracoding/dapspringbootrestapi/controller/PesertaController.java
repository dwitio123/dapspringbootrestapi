package com.juaracoding.dapspringbootrestapi.controller;
/*
IntelliJ IDEA 2024.3 (Community Edition)
Build #IC-243.21565.193, built on November 13, 2024
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 29/01/2025 14:00
@Last Modified 29/01/2025 14:00
Version 1.0
*/

import com.juaracoding.dapspringbootrestapi.model.Peserta;
import com.juaracoding.dapspringbootrestapi.repo.PesertaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peserta")
public class PesertaController {
    @Autowired
    PesertaRepo pesertaRepo;

    @GetMapping("/")
    public List<Peserta> getAllData() {
        List<Peserta> daftarPeserta = pesertaRepo.findAll();
        return daftarPeserta;
    }

    @PostMapping("/")
    public String postData(@RequestBody Peserta peserta) {
        pesertaRepo.save(peserta);
        return peserta.getNama() + " berhasil ditambahkan";
    }

    @GetMapping("/search-peserta-by-id")
    public Peserta searchPesertaById(@RequestParam(value = "id") Integer id) {
        Optional<Peserta> hasil = pesertaRepo.findById(id);
        return hasil.get();
    }

    @GetMapping("/search-peserta-by-nama")
    public List<Peserta> searchPesertaByNama(@RequestParam(value = "nama") String nama) {
        List<Peserta> hasil = pesertaRepo.findByNama(nama);
        return hasil;
    }

    @PostMapping("/delete-peserta-by-nama")
    public String deleteByNama(@RequestParam(value = "nama") String nama) {
        pesertaRepo.deleteByNama(nama);
        return "Peserta bernama " + nama + " berhasil dihapus";
    }

    @GetMapping("/count-peserta-by-batch")
    public int countPesertaByBatch(@RequestParam(value = "batch") String batch) {
        int hasil = pesertaRepo.countByBatch(batch);
        return hasil;
    }

    @GetMapping("/search-4-peserta-by-batch-and-kota")
    public List<Peserta> searchPesertaByBatchAndKota(@RequestParam(value = "batch") String batch, @RequestParam(value = "kota") String kota) {
        List<Peserta> hasil = pesertaRepo.findTop4ByBatchAndAlamatContaining(batch, kota);
        return hasil;
    }

    @GetMapping("/seach-peserta-by-nama-and-batch")
    public List<Peserta> searchPesertaByNamaAndBatch(@RequestParam(value = "nama") String nama, @RequestParam(value = "batch") String batch) {
        List<Peserta> hasil = pesertaRepo.findPesertaByNamaBatch(nama, batch);
        return hasil;
    }
}
