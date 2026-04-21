package com.ra.ptit_cntt2_it210_ss12_btth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @PatientCode
    private String id;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 5, max = 50, message = "Họ tên từ 5-50 ký tự")
    private String fullName;

    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải đúng 10 số và bắt đầu bằng 0")
    private String phone;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotBlank(message = "Triệu chứng không được để trống")
    private String symptom;

    @NotBlank(message = "Ngày nhập viện không được để trống")
    private String admissionDate;
}