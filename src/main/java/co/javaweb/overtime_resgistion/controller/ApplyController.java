package co.javaweb.overtime_resgistion.controller;

import co.javaweb.overtime_resgistion.common.Message;
import co.javaweb.overtime_resgistion.common.Messages;
import co.javaweb.overtime_resgistion.dao.ApplyDao;
import co.javaweb.overtime_resgistion.entity.mybatis.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/apply")
public class ApplyController {
    //    @Autowired
//    ApplyRepository applyRepository;
    @Autowired
    ApplyDao applyDao;

    @PostMapping
    public Message addApply(HttpServletRequest request, @RequestBody Apply apply) throws Exception {
//        String username = request.getSession().getAttribute("username").toString();
////        apply.setEmployee_name(new String(Base64.getDecoder().decode(username.getBytes("utf-8"))));
//
//        apply.setEmployee_id(apply.getEmployee_id());

        int ret = applyDao.save(apply);
//        Apply ret = applyRepository.save(apply);
        if (ret <= 0) {
            return Messages.SYSTEM_ERROR;
        }
        return Messages.SUCCESS;
    }

    @GetMapping
    public Message getApplyList(Apply apply) {
//        List<Apply> applyList = applyRepository.findAll();
//        Message message = null;
//        if (applyList.isEmpty()) {
//            message = Message.successForLayui(applyList, 0);
//        } else {
//            message = Message.successForLayui(applyList, applyList.size());
//        }
//        return message;
        List<Apply> applyList = applyDao.findByExample(apply);
        Message message = null;
        if (applyList.isEmpty()) {
            message = Message.successForLayui(applyList, 0);
        } else {
            message = Message.successForLayui(applyList, applyList.size());
        }
        return message;
    }

}
