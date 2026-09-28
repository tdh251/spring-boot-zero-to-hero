package com.tranduchai.masterspringboot.service;

import java.util.List;

import com.tranduchai.masterspringboot.dto.record.UserRequestRecord;
import com.tranduchai.masterspringboot.dto.record.UserResponseRecord;

public interface UserService {
   void create(UserRequestRecord rq);

   void update(String id, UserRequestRecord rq);

   List<UserResponseRecord> index();

   void delete(String id);
}
