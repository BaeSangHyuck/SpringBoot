package com.example.ex04.service;

import com.example.ex04.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionMapper transactionMapper;

//    @Transactional
//    하나의 서비스에서 여러 DML을 사용할 때
//    특정 예외 발생 시 자동 rollback기능을 수행해준다.

//    만약 원하는 예외를 대상으로 하고 싶다면,
//    rollbackFor = Exception.class를 작성해주고
//    특정 예외에서는 rollback을 하지 않아야 할 때에는
//    noRollbackFor = Exception.class를 작성한다.
    @Transactional
    public void doInsert(String id, String name){
        transactionMapper.insertTest2(name);
        transactionMapper.insertTest1(id, name);
    }
}
