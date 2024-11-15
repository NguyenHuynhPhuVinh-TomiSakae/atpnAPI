package com.tomisakae.amthucphuongnam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "thuc_don")
public class ThucDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "loai_mon", nullable = false)
    private String loaiMon;
    
    @Column(name = "ten_mon_an", nullable = false)
    private String tenMonAn;
    
    @Column(name = "gia_vua")
    private Double giaVua;
    
    @Column(name = "gia_nho")
    private Double giaNho;
}