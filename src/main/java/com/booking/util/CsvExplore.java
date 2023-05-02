package com.booking.util;

import com.booking.payload.UserDTO;
import com.opencsv.CSVWriter;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
public class CsvExplore {
    public static ByteArrayInputStream exportUsersToCsv(List<UserDTO>
                                                                userDTOS) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (CSVWriter csvWriter = new CSVWriter(new
                OutputStreamWriter(out))) {
            // Write header
            csvWriter.writeNext(new String[]{"ID", "First Name","Last Name", "Email", "Phone Number","Profile Picture"});
                    // Write data
            for (UserDTO userDTO : userDTOS) {
                csvWriter.writeNext(new String[]{
                        userDTO.getId().toString(),
                        userDTO.getFirstName(),
                        userDTO.getLastName(),
                        userDTO.getEmail(),
                        userDTO.getPhoneNumber(),
                        userDTO.getProfilePicture()
                });
            }
            csvWriter.flush();
 } catch (IOException e) {
                e.printStackTrace();
            }
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
