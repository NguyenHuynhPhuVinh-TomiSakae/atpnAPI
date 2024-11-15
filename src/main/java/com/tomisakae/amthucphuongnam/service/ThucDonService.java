package com.tomisakae.amthucphuongnam.service;

import com.tomisakae.amthucphuongnam.entity.ThucDon;
import com.tomisakae.amthucphuongnam.repository.ThucDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ThucDonService {
    @Autowired
    private ThucDonRepository thucDonRepository;
    
    public List<ThucDon> getAllMonAn() {
        return thucDonRepository.findAll();
    }
    
    public List<ThucDon> getMonAnTheoLoai(String loaiMon) {
        return thucDonRepository.findByLoaiMon(loaiMon);
    }
    
    public ThucDon themMonAn(ThucDon thucDon) {
        return thucDonRepository.save(thucDon);
    }
    
    public ThucDon capNhatMonAn(Long id, ThucDon thucDon) {
        if (thucDonRepository.existsById(id)) {
            thucDon.setId(id);
            return thucDonRepository.save(thucDon);
        }
        return null;
    }
    
    public void xoaMonAn(Long id) {
        thucDonRepository.deleteById(id);
    }
    
    public List<ThucDon> timKiemMonAn(String keyword) {
        return thucDonRepository.searchByKeyword(keyword);
    }
    
    public List<ThucDon> timKiemTheoGia(Double minPrice, Double maxPrice) {
        return thucDonRepository.findByPriceRange(minPrice, maxPrice);
    }
    
    public List<ThucDon> timTheoKhoangGia(
            Double minGiaVua, Double maxGiaVua,
            Double minGiaNho, Double maxGiaNho) {
        return thucDonRepository.timTheoKhoangGia(
            minGiaVua, maxGiaVua, minGiaNho, maxGiaNho);
    }
}