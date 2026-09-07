/*
 * @ (#) Student.java     1.0    8/26/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */
package iuh.fit.vantruong.bai1;


import lombok.*;

/*
 * @description
 * @author:NguyenTruong
 * @date:  8/26/2026
 * @version:    1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {

    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String mobile;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String[] hobbies;
    private String qualification;
    private String course;


}