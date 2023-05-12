package com.hi.todo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class ModifyTodoRequest { //Command 클래스

    private int tno;  // tno는 String으로 받아도되고 int로 받아도됨
    private String todo;
    private String duedate;
    private String finished;

}
