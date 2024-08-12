package com.example.java6.Service;

import com.example.java6.Entity.NhanVien;
import com.example.java6.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }

    public void addNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(int maNV) {
        nhanVienRepository.deleteById(maNV);
    }

    public void updateNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public NhanVien getNhanVienById(int maNV) {
        return nhanVienRepository.findById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân viên: " + maNV));
    }

}
