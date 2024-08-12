package com.example.java6.API;

import com.example.java6.Entity.NhanVien;
import com.example.java6.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienAPI {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("")
    public ResponseEntity<?> getALlNhanVien() {
        return ResponseEntity.ok(nhanVienService.getAllNhanVien());
    }

    @GetMapping("/one")
    public ResponseEntity<?> getNhanVienById(@RequestParam("maNV") int maNV) {
        return ResponseEntity.ok(nhanVienService.getNhanVienById(maNV));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNhanVien(@RequestBody NhanVien nhanVien) {
        nhanVienService.addNhanVien(nhanVien);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateNhanVien(@RequestBody NhanVien nhanVien) {
        nhanVienService.addNhanVien(nhanVien);
        return ResponseEntity.ok("Update thành công");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteNhanVien(@RequestParam("maNV") int maNV) {
        nhanVienService.deleteNhanVien(maNV);
        return ResponseEntity.ok("Xóa thành công");
    }
}
