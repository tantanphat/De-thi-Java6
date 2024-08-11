package com.example.java6.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
    private String mssv;
    private String name;
    private Double mark;
    private String major;
}
