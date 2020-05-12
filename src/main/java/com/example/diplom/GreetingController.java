package com.example.diplom;

import com.example.diplom.domain.Message;
import com.example.diplom.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }


    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name_pr, @RequestParam String tag,@RequestParam String qr,@RequestParam Integer ideal, @RequestParam Integer real,  Map<String, Object> model) {
        Message message = new Message(name_pr, tag, qr,ideal,real);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }


    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

    //check = qr
    @PostMapping("check")
    public String check(@RequestParam String check, Map<String, Object> model) {
        Iterable<Message> messages;
        //check = qr
        if (check != null && !check.isEmpty()) {

            boolean bool = messageRepo.existsByQr(check);
            //messages = messageRepo.findByQr(check);
            if(bool)
            {
              messages.
            }


        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

}


