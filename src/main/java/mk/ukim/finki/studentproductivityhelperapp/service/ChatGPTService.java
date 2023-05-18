package mk.ukim.finki.studentproductivityhelperapp.service;

import mk.ukim.finki.studentproductivityhelperapp.model.ChatGPT;

import java.util.List;

public interface ChatGPTService {

     ChatGPT saveChatGPT(ChatGPT chatGPT);
     List<ChatGPT> getAllChatGPTs();
     ChatGPT getChatGPTById(Long dataId) ;
     void deleteChatGPT(ChatGPT chatGPT);
}
