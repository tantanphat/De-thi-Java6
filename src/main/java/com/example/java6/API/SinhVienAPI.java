package com.example.java6.API;

import com.example.java6.Entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/sinh-vien")
public class SinhVienAPI {
     @Autowired
     private RestTemplate restTemplate;

     @GetMapping("")
     public ResponseEntity<?> getAllStudent() {
          return restTemplate.getForEntity("https://mssv-ps36560-default-rtdb.asia-southeast1.firebasedatabase.app/sinh-vien.json", String.class);
     }
     @GetMapping("/{key}")
     public ResponseEntity<?> getStudentById(@PathVariable String key) {
          String url = "https://mssv-ps36560-default-rtdb.asia-southeast1.firebasedatabase.app/sinh-vien/" + key + ".json";
          try {
               return restTemplate.getForEntity(url, com.example.java6.Entity.SinhVien.class);
          } catch (HttpClientErrorException e) {
               return new ResponseEntity<>("Không tìm thấy sinh viên với key này", HttpStatus.NOT_FOUND);
          } catch (Exception e) {
               return new ResponseEntity<>("Đã xảy ra l��i, vui lòng thử lại", HttpStatus.INTERNAL_SERVER_ERROR);
          }
     }

     @PutMapping("/{key}")
     public ResponseEntity<?> putStudent(@PathVariable String key,@RequestBody com.example.java6.Entity.SinhVien sinhVien) {
          String url = "https://mssv-ps36560-default-rtdb.asia-southeast1.firebasedatabase.app/sinh-vien/" + key + ".json";
          try {
               restTemplate.put(url, sinhVien);
               return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
          } catch (HttpClientErrorException e) {
               return new ResponseEntity<>("Không thể cập nhật, kiểm tra lại key", HttpStatus.NOT_FOUND);
          } catch (Exception e) {
               return new ResponseEntity<>("Đã xảy ra lỗi, vui lòng thử lại", HttpStatus.INTERNAL_SERVER_ERROR);
          }
     }

     @PostMapping("/add")
     public ResponseEntity<?> postStudent(@RequestBody SinhVien student) {
          String url = "https://mssv-ps36560-default-rtdb.asia-southeast1.firebasedatabase.app/sinh-vien.json";
          String checkExistUrl = "https://mssv-ps36560-default-rtdb.asia-southeast1.firebasedatabase.app/sinh-vien.json";

          try {
               ResponseEntity<String> checkResponse = restTemplate.getForEntity(checkExistUrl, String.class);
               if (checkResponse.getStatusCode() == HttpStatus.OK) {
                    String responseBody = checkResponse.getBody();
                   assert responseBody != null;
                   if (responseBody.contains("\"mssv\":\"" + student.getMssv() + "\"")) {
                         return new ResponseEntity<>("Sinh viên đã tồn tại", HttpStatus.CONFLICT);
                    }
               }


               return  restTemplate.postForEntity(url, student, String.class);
          } catch (Exception e) {
               return new ResponseEntity<>("Đã xảy ra lỗi, vui lòng thử lại", HttpStatus.INTERNAL_SERVER_ERROR);
          }
     }

     @DeleteMapping("/{key}")
     public ResponseEntity<?> deleteStudent(@PathVariable String key) {
          String url = "https://mssv-ps36560-default-rtdb.asia-southeast1.firebasedatabase.app/sinh-vien/" + key + ".json";
          try {
               restTemplate.delete(url);
               return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
          } catch (HttpClientErrorException e) {
               return new ResponseEntity<>("Không thể xóa, kiểm tra lại key", HttpStatus.NOT_FOUND);
          } catch (Exception e) {
               return new ResponseEntity<>("Đã xảy ra lỗi, vui lòng thử lại", HttpStatus.INTERNAL_SERVER_ERROR);
          }
     }
}
