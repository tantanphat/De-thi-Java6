package com.example.java6.Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaNV")
    private int maNV;

    @Column(name = "HoTen")
    private String hoTen;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;
}
