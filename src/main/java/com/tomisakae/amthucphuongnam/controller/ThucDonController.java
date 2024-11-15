package com.tomisakae.amthucphuongnam.controller;

import com.tomisakae.amthucphuongnam.entity.ThucDon;
import com.tomisakae.amthucphuongnam.service.ThucDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thucdon")
public class ThucDonController {
    @Autowired
    private ThucDonService thucDonService;
    
    @GetMapping
    public ResponseEntity<?> layTatCaMonAn() {
        return ResponseEntity.ok(thucDonService.getAllMonAn());
    }
    
    @GetMapping("/loai/{loaiMon}")
    public ResponseEntity<?> layMonAnTheoLoai(@PathVariable String loaiMon) {
        return ResponseEntity.ok(thucDonService.getMonAnTheoLoai(loaiMon));
    }
    
    @PostMapping
    public ResponseEntity<?> themMonAn(@RequestBody ThucDon thucDon) {
        return ResponseEntity.ok(thucDonService.themMonAn(thucDon));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> capNhatMonAn(@PathVariable Long id, @RequestBody ThucDon thucDon) {
        ThucDon updated = thucDonService.capNhatMonAn(id, thucDon);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> xoaMonAn(@PathVariable Long id) {
        thucDonService.xoaMonAn(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/timkiem")
    public ResponseEntity<?> timKiemMonAn(@RequestParam String keyword) {
        return ResponseEntity.ok(thucDonService.timKiemMonAn(keyword));
    }
    
    @GetMapping("/timkiem-gia")
    public ResponseEntity<?> timKiemTheoGia(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return ResponseEntity.ok(thucDonService.timKiemTheoGia(minPrice, maxPrice));
    }
    
    @GetMapping("/tim-gia")
    public ResponseEntity<?> timTheoKhoangGia(
            @RequestParam(required = false) Double minGiaVua,
            @RequestParam(required = false) Double maxGiaVua,
            @RequestParam(required = false) Double minGiaNho,
            @RequestParam(required = false) Double maxGiaNho) {
        return ResponseEntity.ok(thucDonService.timTheoKhoangGia(
            minGiaVua, maxGiaVua, minGiaNho, maxGiaNho));
    }
}