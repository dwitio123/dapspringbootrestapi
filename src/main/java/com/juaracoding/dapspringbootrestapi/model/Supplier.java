package com.juaracoding.dapspringbootrestapi.model;

/*
IntelliJ IDEA 2024.3.2.2 (Community Edition)
Build #IC-243.23654.189, built on January 29, 2025
@Author TGS a.k.a. Dwitio Ahmad Pranoto
Java Developer
Created on 03/02/2025 17:20
@Last Modified 03/02/2025 17:20
Version 1.0
*/

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Supplier")
public class Supplier implements Serializable {
    private static final Long serializeVersion = 70003L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSupplier")
    private Long idSupplier;

    @Column(name = "NamaSupplier")
    private String namaSupplier;

    @Column(name = "AlamatSupplier")
    private String alamatSupplier;

    @ManyToMany
    @JoinTable(name = "MapBarangSupplier",
    joinColumns = {@JoinColumn(name = "IDSupplier", referencedColumnName = "IDSupplier", foreignKey = @ForeignKey(name = "fkMapToSupplier"))},
    inverseJoinColumns = {@JoinColumn(name = "IDBarang", referencedColumnName = "IDBarang", foreignKey = @ForeignKey(name = "fkMapToBarang"))},
    uniqueConstraints = @UniqueConstraint(columnNames = {"IDSupplier", "IDBarang"}))
    private List<Barang> listBarang;

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    public String getAlamatSupplier() {
        return alamatSupplier;
    }

    public void setAlamatSupplier(String alamatSupplier) {
        this.alamatSupplier = alamatSupplier;
    }

    public List<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }
}
