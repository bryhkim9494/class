package com.hi.app.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderCommand {
    private List<OrderItem> orderItems; // 객체 여러개를 저장하려고 List를 씀 , List에 구현체로 ArrayList가 있음
    private Address address;


}
