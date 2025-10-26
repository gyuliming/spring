package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dao.TodoDAO;
import com.ssg.webmvc.todo.domain.TodoVO;
import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// enum 클래스
// 장점 : 정해진 수만큼 객체를 생성할 수 있다.
@Log4j2
public enum TodoService {
    INSTANCE; // 객체의 개수를 결정할 때 사용
              // 현재 INSTANCE가 1개이므로 서비스 객체도 1개만 사용
              // TodoService.INSTANCE로 접근
              // 객체를 하나만 생성해서 사용 => Singleton pattern
              // 여러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고 받는 구조로 구성

    private TodoDAO dao; // 인젝션, 독립된 객체를 다른 객체에 주입(=DI)
    private ModelMapper modelMapper;

    TodoService() {
        this.dao = new TodoDAO();
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class); // reflection 기법(원형으로 copy)
//        System.out.println("todoVO");
        log.info(todoVO);
        dao.insert(todoVO);
        // register() TodoDTO 파라미터를 Servlet한테 받아서 ModelMapper를 통해서 TodoVO 객체로 변환을 한 후,
        // dao.insert(todoVO)를 통해 todoVO 객체를 전달하며 등록 기능을 요청한다.
    }

//    // 10개의 TodoDTO 객체를 만들어 반환
//    public List<TodoDTO> getList() {
//        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(
//                i -> {
//                    TodoDTO dto = new TodoDTO();
//                    dto.setTno((long) i);
//                    dto.setTitle("Todo..title" + i);
//                    dto.setDueDate(LocalDate.now());
//                    return dto;
//                }
//        ).collect(Collectors.toList());
//        return todoDTOS;
//    }
//
    // TodoReadController가 요청
//    public TodoDTO get(Long tno) {
//        TodoDTO dto = new TodoDTO();
//        dto.setTno(tno);
//        dto.setTitle("Sample Todo");
//        dto.setDueDate(LocalDate.now());
//        dto.setFinished(true);
//        return dto;
//    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList ----------------------");
        log.info(voList);
        List<TodoDTO> dtoList = voList.stream().map(
                vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO listOne(Long tno) throws Exception {
        TodoVO vo = dao.selectOne(tno);
        log.info("vo ------------------");
        log.info(vo);
        TodoDTO todoDTO = modelMapper.map(vo, TodoDTO.class);

        return todoDTO;
    }

    public void update(TodoDTO dto) throws Exception {
        TodoVO vo = modelMapper.map(dto, TodoVO.class);
        dao.updateOne(vo);
    }
}
