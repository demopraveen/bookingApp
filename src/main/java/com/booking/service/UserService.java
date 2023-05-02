package com.booking.service;

import com.booking.entities.BusOperator;
import com.booking.payload.UserDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    Page<UserDTO> getUsers(Pageable pageable);
    void deleteUser(Long userId);
    UserDTO updateUser(Long userId, UserDTO userDTO);


    InputStreamResource getUserAsExcel();
    InputStreamResource getUserAsPdf() throws Exception;
    //Now Add This
    InputStreamResource getUserCsv();


}
