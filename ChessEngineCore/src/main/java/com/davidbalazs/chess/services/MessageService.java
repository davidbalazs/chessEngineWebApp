package com.davidbalazs.chess.services;

import com.davidbalazs.chess.models.MessageModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by David B on 4/26/2016.
 */
public interface MessageService {
    List<MessageModel> getAll();

    MessageModel getById(long id);

    void markAsRead(long id);

    void markAsUnread(long id);

    void delete(long id);

    @Transactional
    void create(MessageModel message);
}
