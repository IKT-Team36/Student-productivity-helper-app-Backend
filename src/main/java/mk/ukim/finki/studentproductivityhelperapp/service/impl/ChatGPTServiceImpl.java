package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.ChatGPT;
import mk.ukim.finki.studentproductivityhelperapp.repository.ChatGPTRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.ChatGPTService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {

    private final ChatGPTRepository chatGPTRepository;

    public ChatGPTServiceImpl(ChatGPTRepository chatGPTRepository) {
        this.chatGPTRepository = chatGPTRepository;
    }

    public ChatGPT saveChatGPT(ChatGPT chatGPT) {
        return this.chatGPTRepository.save(chatGPT);
    }

    public List<ChatGPT> getAllChatGPTs() {
        return this.chatGPTRepository.findAll();
    }

    public ChatGPT getChatGPTById(Long dataId) {
        return this.chatGPTRepository.findById(dataId).orElseThrow(() -> new IllegalArgumentException("Invalid ChatGPT ID: " + dataId));

    }

    public void deleteChatGPT(ChatGPT chatGPT) {
        this.chatGPTRepository.delete(chatGPT);
    }
}
