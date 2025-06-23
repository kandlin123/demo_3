package com.example.demo_3.service;

import com.example.demo_3.dto.BoardDTO;
import com.example.demo_3.dto.PageRequestDTO;
import com.example.demo_3.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
