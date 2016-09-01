package com.trial.guava;

import com.cqs.demo2.models.user.model.User;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by li on 2015/11/28.
 */
@Component
public class GuavaOptional {

    protected Logger logger = LoggerFactory.getLogger(GuavaOptional.class);
   @Resource
   User user;



    public void optionalMethods(){
        logger.debug("optionMethods");
        Optional<Integer> possible = Optional.of(5);
        boolean f= possible.isPresent(); // returns true
        int result = possible.get(); // returns 5



        Optional<User> optional = Optional.fromNullable(user);
        System.out.println(optional.isPresent());
//        User user;
        user = new User();
        user.setName("Kate");
        user = Optional.fromNullable(user).or(new User());
        System.out.println(user);



        System.out.println(f + "\t" + result);
    }
}
