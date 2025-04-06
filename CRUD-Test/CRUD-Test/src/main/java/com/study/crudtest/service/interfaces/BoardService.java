package com.study.crudtest.service.interfaces;

import com.study.crudtest.dto.DetailDTO;
import com.study.crudtest.dto.ListDTO;
import com.study.crudtest.dto.PostFormDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BoardService {

    ResponseEntity save(PostFormDTO postFormDTO);

    List<ListDTO> getAll();

    DetailDTO getDetail(Long id);
}
