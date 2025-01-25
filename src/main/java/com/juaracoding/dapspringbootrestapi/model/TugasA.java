package com.juaracoding.dapspringbootrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MstTugasA")
public class TugasA {

    @Id
    @Column(name = "IDTugasA", length = 255, nullable = false)
    private String idTugasA;

    @Column(name = "Nama", length = 40, nullable = false)
    private String nama;

    @Column(name = "Alamat", length = 500, nullable = false)
    private String alamat;

    @Column(name = "TanggalLahir", nullable = false)
    private Date tanggalLahir;

    @Column(name = "JenisKelamin", length = 1, nullable = false)
    private String jenisKelamin;

    @Column(name = "MasihHidup", nullable = false)
    private boolean masihHidup;

    @Column(name = "CreatedDate", length = 7, nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy", nullable = false)
    private int createdBy;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @Column(name = "ModifiedBy")
    private int modifiedBy;

    @Column(name = "IsDelete", nullable = false)
    private short isDelete;

    public String getIdTugasA() {
        return idTugasA;
    }

    public void setIdTugasA(String idTugasA) {
        this.idTugasA = idTugasA;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public boolean isMasihHidup() {
        return masihHidup;
    }

    public void setMasihHidup(boolean masihHidup) {
        this.masihHidup = masihHidup;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(short isDelete) {
        this.isDelete = isDelete;
    }
}
