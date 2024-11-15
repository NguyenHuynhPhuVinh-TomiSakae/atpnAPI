package com.tomisakae.amthucphuongnam.repository;

import com.tomisakae.amthucphuongnam.entity.ThucDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ThucDonRepository extends JpaRepository<ThucDon, Long> {
    List<ThucDon> findByLoaiMon(String loaiMon);
    
    @Query("SELECT t FROM ThucDon t WHERE " +
           "LOWER(t.tenMonAn) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(t.loaiMon) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<ThucDon> searchByKeyword(@Param("keyword") String keyword);
    
    @Query("SELECT t FROM ThucDon t WHERE " +
           "t.giaVua >= :minPrice AND t.giaVua <= :maxPrice")
    List<ThucDon> findByPriceRange(@Param("minPrice") Double minPrice, 
                                  @Param("maxPrice") Double maxPrice);
    
    @Query("SELECT t FROM ThucDon t WHERE " +
           "(:minGiaVua IS NULL OR t.giaVua >= :minGiaVua) AND " +
           "(:maxGiaVua IS NULL OR t.giaVua <= :maxGiaVua) AND " +
           "(:minGiaNho IS NULL OR t.giaNho >= :minGiaNho) AND " +
           "(:maxGiaNho IS NULL OR t.giaNho <= :maxGiaNho)")
    List<ThucDon> timTheoKhoangGia(
        @Param("minGiaVua") Double minGiaVua,
        @Param("maxGiaVua") Double maxGiaVua,
        @Param("minGiaNho") Double minGiaNho,
        @Param("maxGiaNho") Double maxGiaNho
    );
}