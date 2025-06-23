package com.example.demo_3.service;

import com.example.demo_3.dto.BoardDTO;
import com.example.demo_3.dto.PageRequestDTO;
import com.example.demo_3.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("Sample Title...")
                .content("Sample Content..")
                .writer("user00")
                .build();

        Long bno = boardService.register(boardDTO);
        log.info("bno: "+ bno);
    }

    @Test
    public void testModify() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(101L)
                .title("Updated")
                .content("updated content")
                .build();

        boardService.modify(boardDTO);
    }

    @Test
    public void testlist() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        log.info(responseDTO);
    }
}
